package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
 	
	
	// By locator - - OR
	By username = By.id("email");
	By password = By.id("passwd");
	By loginButton = By.id("SubmitLogin");
	By signInLink = By.linkText("Sign in");
	
	
	// create a contructor of login page class
	 public LoginPage(WebDriver driver){
		 this.driver = driver;
		 elementUtil = new ElementUtil(this.driver);
	 }
	
	// page actions
	
	 @Step("get login page title.... ")
	 public String getLoginPageTitle(){
		 //return driver.getTitle();
 		 return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	 }
	
	 @Step("check sing in link on login page....")
	public boolean verifySignInLink(){
		//return driver.findElement(signInLink).isDisplayed();
		return elementUtil.doIsDisplayed(signInLink);
	}
	
	 @Step("login to app with username: {0} and password: {1}")
	public HomePage doLogin(String username, String password){
		//driver.findElement(this.username).sendKeys(username);//Non generic
		//driver.findElement(this.password).sendKeys(password);
		//driver.findElement(loginButton).click();
		
		elementUtil.waitForElementToBeVisible(this.username, 10);//Generic
		elementUtil.doActionsSendKeys(this.username, username);
		elementUtil.doActionsSendKeys(this.password, password);
		elementUtil.doClick(this.loginButton);
		
		return new HomePage(driver);// login method  is landing HomePage is called PageChaining
	}
	

}
