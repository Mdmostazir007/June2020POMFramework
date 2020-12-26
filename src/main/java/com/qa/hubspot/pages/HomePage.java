package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
 	
	// By locator --OR
	
	By header = By.cssSelector(".page-heading");
	By accountName = By.linkText("Md Islam");
	By contractLink = By.xpath("//a[text()='Contact us']");

	
	// crater a constuctor
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
   // page actions
	
	public String getHomePageTitle(){
		//return driver.getTitle();
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10);
	}
	
	public String getHomePageHeaderText(){
		/*if(driver.findElement(header).isDisplayed()){
		 return driver.findElement(header).getText();
		}
		return null;*/
		
		if(elementUtil.doIsDisplayed(header)){
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	
	public String getLoggedInUser(){
		/*if(driver.findElement(accountName).isDisplayed()){
		return driver.findElement(accountName).getText();
		}
		return null;*/
		if(elementUtil.doIsDisplayed(accountName)){
			 return elementUtil.doGetText(accountName);
		}
		return null;
 	}
	
	
	public ContactsPage goToConcactsPage(){
		clickOnContactLink();
		return new ContactsPage(driver);
	}
	
	
	private void clickOnContactLink(){
		elementUtil.waitForElementToBeVisible(contractLink, 10);
		elementUtil.doClick(contractLink);
	}
	
	
	
}
	
	
