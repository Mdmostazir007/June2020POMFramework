package com.qa.hubspot.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver);
	}
	
	
	public List<WebElement> getElements(By locator){
		List<WebElement> elementsList = driver.findElements(locator);
		return elementsList;
	}
	
	
	/**
	 * This method is used to create the webElement on the basis of locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try{
		 System.out.println("locator is : " + locator);	
		 element = driver.findElement(locator);
		if( prop.getProperty("highlight").equalsIgnoreCase("yes")){
		 jsUtil.flash(element);
		}
		 System.out.println("WebElement is created successfully " + locator);
		}catch(Exception e){
			System.out.println("some exception is occoured with this locator");
			System.out.println(e.getMessage());
		} 
		return element;
	}
	
	
	/**
	 * This method is used to click on the element
	 * @param locator
	 */
   public void doClick(By locator){
	   try{
	   getElement(locator).click();
	   }catch(Exception e){
		   System.out.println("some exception is occured while click on the element...");
		   System.out.println(e.getMessage());
	   }
   }
	
   /**
    * This method is used to pass the value in a webelement
    * @param locator
    * @param value
    */
	public void doSendKeys(By locator, String value){
		try{
		getElement(locator).sendKeys(value);
		}catch(Exception e){
			System.out.println("some exception is occured while passing value to the webelement...");
			System.out.println(e.getMessage());
		}
	}
	
	public boolean doIsDisplayed(By locator){
		 return getElement(locator).isDisplayed();
	}
	
	
	

	// generic Actions class methods
	
	public void doActionsClick(By locator){
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.click(element).build().perform();
	}
	
	public void doActionsSendKeys(By locator, String value){
		Actions action = new Actions(driver);
		WebElement element = getElement(locator);
		action.sendKeys(element, value).build().perform();
	}
	
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	
	public void selectDroDownByIndex(By locator, int num){
		
	}
	
	
	public void selectDropDownValue(By locator, String value){
		
	}
	
	public void getDropDownValueList(String locator){
		
	}
	public void doSelectValueWithOutSelect(String locator, String locatorValue, String value){
		
	}
	
	
	//*********** wait custom method : wait util ***************
	
		/**
		 * This method is used for explicit wait to a element
		 * @param locator
		 * @param timeOut
		 * @return 
		 */
		public WebElement waitForElementToBePresent(By locator, int timeout){
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			 return getElement(locator);
		}

		public WebElement waitForElementToBeClikable(By locator, int timeout){
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.elementToBeClickable(locator));
			 return getElement(locator);
		}

		public WebElement waitForElementToBeVisible(By locator, int timeout){
			WebElement element = getElement(locator);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.visibilityOf(element));
			 return  element;
		}
		
		public WebElement waitForElementToBeVisibleLocated(By locator, int timeout){
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			 return getElement(locator);
		}
		
		/**
		 * This method is used for explicit wait to page title 
		 * @param title
		 * @param timeOut
		 * @return 
		 */
		public String waitForTitleToBePresent(String title, int timeout){
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.titleContains(title));
			 return driver.getTitle();
			 
		}
		
	
		public String waitForUrl(String url, int timeout){
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.urlContains(url));
			 return driver.getCurrentUrl();
			 
		}
		
		public boolean waitForAlertToBePresent(int timeout){
 			WebDriverWait wait = new WebDriverWait(driver, timeout);
			 wait.until(ExpectedConditions.alertIsPresent());
			 return true;
			 
		}
		
		
		public void clickWhenReady(By locator, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			 wait.until(ExpectedConditions.elementToBeClickable(locator));
			  getElement(locator).click();
			
		}
		
	public void visibilityOfAllElement(List<WebElement> elements, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements)); 
	}
	
	

	
	
	
	
	

}
