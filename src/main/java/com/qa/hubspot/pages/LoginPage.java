package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

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
	 }
	
	// page actions
	 
	 public String getPageTitle(){
		 return driver.getTitle();
	 }
	
	public boolean verifySignInLink(){
		return driver.findElement(signInLink).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password){
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginButton).click();
		
		return new HomePage(driver);// login method  is landing HomePage is called Pagechaining
	}
	

}
