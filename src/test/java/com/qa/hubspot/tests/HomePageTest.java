package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest {
	
    WebDriver driver;
	
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Properties prop;
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.inti_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority = 3)
	public void verifyHomePageTitleTest(){
	String title = homePage.getHomePageTitle();
	System.out.println("homepage title is : "+ title);
	Assert.assertEquals(title, Constants.HOMEPAGE_PAGE_TITLE, "home page title is not matched...");
	}
	
	@Test(priority = 1)
	public void verifyHomePageHeaderTest(){
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home page header is :" + header);
		Assert.assertEquals(header, Constants.HOMEPAGE_PAGE_HEADER, "Home page header is not present");
	}
	
	
	@Test(priority = 2)
	public void verifyLoggedInUserTesta(){
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in User is :" + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "Logged in user is not matched");
		
		
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	

}
