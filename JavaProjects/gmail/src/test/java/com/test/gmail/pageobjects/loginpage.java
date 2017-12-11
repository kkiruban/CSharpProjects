package com.test.gmail.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginpage {
	
	
	@FindBy(id="username")
	private WebElement usernameTextBox;
	
	@FindBy(id="password")
	private WebElement passwordTextBox;
	
	
	@FindBy(id="Login")
	private WebElement loginbutton;
	
	
	public boolean login(String username, String password){
		
		try{
			usernameTextBox.sendKeys(username);
			
			passwordTextBox.sendKeys(password);
			
			loginbutton.click();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

}
