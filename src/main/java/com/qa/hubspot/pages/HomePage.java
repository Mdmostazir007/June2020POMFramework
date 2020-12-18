package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	// By locator --OR
	
	By header = By.cssSelector(".page-heading");
	By accountName = By.linkText("Md Islam");
	
	
	// crater a constuctor
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
   // page actions
	
	public String getHomePageTitle(){
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText(){
		if(driver.findElement(header).isDisplayed()){
		 return driver.findElement(header).getText();
		}
		return null;
	}
	
	
	public String getLoggedInUser(){
		if(driver.findElement(accountName).isDisplayed()){
		return driver.findElement(accountName).getText();
		}
		return null;
 	}
	
	
	
	
	
	
	
}
	
	
