package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest{
	
	HomePage homePage;
	ContactsPage contactsPage;
	
	@BeforeClass
	public void contactsSetUp(){
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToConcactsPage();
		
	}
	
	
	@Test(priority = 1)
	public void verifyContactsPageTitleTest(){
		
		String title = contactsPage.getContactPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyContactsPageHeaderTest(){
		String header = contactsPage.getContactsPageHeader();
		Assert.assertEquals(header, Constants.CONTACTS_PAGE_HEADER);
	}
	
	@Test(priority = 3)
	public void verifyContactsTextMessageTest(){
	    String text = contactsPage.getContactMessageText();
	    Assert.assertEquals( text, Constants.CONTACTS_PAGE_TEXT);
	}
	
	@Test(priority = 4)
	public void verifyErrorMessageTest(){
		String errorMessage =  contactsPage.getContactErrorMessage(); 
		Assert.assertEquals(errorMessage, Constants.CONTACTS_PAGE_ERROR_MESSAGE);
	}
	
	
	@DataProvider
	public Object[][] getContactsTestData(){
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}

	//DataProvider create mapping with @Test 
	@Test(priority = 2, dataProvider ="getContactsTestData")
	public void createContactTest(String email, String fistName, String lastName, String jobTilte ){
		
	}
	
	
	

}
