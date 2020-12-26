package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.Constants;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	
	private WebDriver driver;
	
	//Constuctor
	 public ContactsPage(WebDriver driver){
		 this.driver = driver;
		 elementUtil = new ElementUtil(this.driver);
	 }
	
	//OR
	 By contractLink = By.xpath("//a[text()='Contact us']");
	 By header = By.xpath("//h1[@class='page-heading bottom-indent']");
	 By messageText  = By.xpath("//h3[@class='page-subheading']");
	 
	 By sendButton = By.id("submitMessage");
	 By errorMessage = By.xpath("//div[@class='alert alert-danger']/ol");
	 
	 //page action
	 
	 public String getContactPageTitle(){
		 return elementUtil.waitForTitleToBePresent(Constants.CONTACTS_PAGE_TITLE, 10);
	 }
	 
	  public String getContactsPageHeader(){
		  elementUtil.waitForElementToBeVisible(header, 10);
		  return elementUtil.doGetText(header);
 	  }
	 
	  public String getContactMessageText(){
		  if(elementUtil.doIsDisplayed(messageText)){
		 return elementUtil.doGetText(messageText);
		  }
		  return null;
	  }
	
	  public String getContactErrorMessage(){ 
		     elementUtil.clickWhenReady(sendButton, 10);
		     elementUtil.waitForElementToBeVisible(errorMessage, 10);
			 return elementUtil.doGetText(errorMessage);
		  }
	  
	   
	  
	  
	  
		  
	  }
	 
	 
	 
	 
	 
	 


