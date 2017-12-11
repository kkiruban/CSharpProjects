package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminLoginPageFactory {
	
	@FindBy(name="AdminEmail")
	private WebElement usernameEdt;
	
	@FindBy(name="Password")
	private WebElement passwordEdt;
	
	
	@FindBy(xpath="//div[@class='button button_8em']")
	private WebElement signINBtn;
	
	@FindBy(linkText="I forgot My Password")
	private WebElement forgotPwdLnk;
	
	@FindBy(name="RememberEmail")
	private WebElement rememberChk;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSignINBtn() {
		return signINBtn;
	}

	public WebElement getForgotPwdLnk() {
		return forgotPwdLnk;
	}

	public WebElement getRememberChk() {
		return rememberChk;
	}
	

}
