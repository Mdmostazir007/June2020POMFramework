package com.qa.hubspot.tests;

 
 import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

 import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.listeners.ExtentReportListener;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

// @Listeners(ExtentReportListener.class)
@Epic("Epic - 101 : desing login page with differnt features.....")
@Story("US - 102 : design basic login page with signup, title and login form.... ")
public class LoginPageTest extends BaseTest{
	 
	
	@Test(priority = 1)
	@Description("verify Login Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is :" + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "login page is not match...");
	}
	
 
	@Test(priority = 2)
	@Description("verify sign in link Test....")
	@Severity(SeverityLevel.CRITICAL)
    public void verifySignInLinkTest(){
		Assert.assertTrue(loginPage.verifySignInLink(), "sigup link is not displayed...");
	}
	
	@Test(priority = 3)
	@Description("verify Login Test....")
	@Severity(SeverityLevel.BLOCKER)

    public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	 
	

}
