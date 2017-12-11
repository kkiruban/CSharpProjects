package com.SFDC.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createaccountpage {
	
	
	@FindBy(xpath="//*[@id='Account_Tab']/a")
	private WebElement accounttablink;

	@FindBy(xpath="//input[@title='New']")
	private WebElement newbutton;
	
	@FindBy(id="acc2")
	private WebElement accountnametextbox;

	
	@FindBy(xpath="//*[@id='topButtonRow']/input[@title='Save']")
	private WebElement savebutton;
	
	
	
	public boolean createaccount(String accountname){
		accounttablink.click();
		newbutton.click();
		accountnametextbox.sendKeys(accountname);
		savebutton.click();
		return true;
	}
}
