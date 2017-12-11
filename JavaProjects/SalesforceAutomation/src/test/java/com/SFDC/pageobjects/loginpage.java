package com.SFDC.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage {
	
	
	
	@FindBy(id="username")
	private WebElement usernametextbox;

	@FindBy(id="password")
	private WebElement passwordtextbox;


	@FindBy(id="Login")
	private WebElement loginbutton;

	
	public boolean loginsalesforcesite(String username,String password) throws InterruptedException{
		usernametextbox.sendKeys(username);
		passwordtextbox.sendKeys(password);
		loginbutton.click();
		Thread.sleep(20000);
		return true;
	}
}
