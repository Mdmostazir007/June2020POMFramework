package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ElementUtil;
import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Sumon
 *
 */

public class BasePage {
	
	WebDriver driver;
	public Properties prop;
	public ElementUtil elementUtil;
	public OptionsManager optionsManager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver(){
		return tlDriver.get();
	}

	
	/**
	 * this method is used to intialized the WebDriver on the basis of browser
	 * @param browserName
	 * @return driver
	 */
	public WebDriver init_driver(Properties prop){
		optionsManager = new OptionsManager(prop);
        String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup(); 
			//driver = new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));

		}
		else if(browserName.equalsIgnoreCase("safari")){
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}
		
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		getDriver().get(prop.getProperty("url"));
		//driver.get(prop.getProperty("url"));
		
		//return driver;
		return getDriver();
	}
	
	/**
	 * this method is used to initialize the properties from config.properties file
	 * @return prop
	 */
	public Properties inti_prop(){
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
 			e.printStackTrace();
		} catch (IOException e) {
 			e.printStackTrace();
		}
		
		return prop;
	}
	 
	
	
	public String getScreenshot(){
		
	 File src = 	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	 String path = System.getProperty("user.dir")+"/screenshot"+System.currentTimeMillis()+".png";
	 File destination = new File(path);
	 try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
 		e.printStackTrace();
	}
	
	return path;
	
	}
	 
	
	
	
	
	
	
	
	
	
	
	

}
