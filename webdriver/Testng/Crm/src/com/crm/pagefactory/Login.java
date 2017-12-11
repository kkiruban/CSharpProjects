package com.crm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(name="Login")
	private WebElement signinbtn;

	public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getSigninbtn() {
		return signinbtn;
	}
	
//	@FindBy(name="username")
//	private WebElement usernameedit;

}
