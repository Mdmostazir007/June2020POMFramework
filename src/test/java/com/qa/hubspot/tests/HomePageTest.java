package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;

public class HomePageTest extends BaseTest {
	
   HomePage homePage;  
	
	
	@BeforeClass
	public void homeSetUP(){
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	
	@Test(priority = 3)
	public void verifyHomePageTitleTest(){
	String title = homePage.getHomePageTitle();
	System.out.println("homepage title is : "+ title);
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "home page title is not matched...");
	}
	
	@Test(priority = 1)
	public void verifyHomePageHeaderTest(){
		String header = homePage.getHomePageHeaderText();
		System.out.println("Home page header is :" + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home page header is not present");
	}
	
	
	@Test(priority = 2)
	public void verifyLoggedInUserTesta(){
		String loggedInUser = homePage.getLoggedInUser();
		System.out.println("Logged in User is :" + loggedInUser);
		Assert.assertEquals(loggedInUser, prop.getProperty("accountname"), "Logged in user is not matched");
		
		
	}
	
	
	 
	
	
	
	

}
