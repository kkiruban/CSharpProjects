package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(name="user_name")
	private WebElement usertxtedit;
	@FindBy(name="user_password")
	private WebElement passtxtedit;
	@FindBy (name="Login")
	private WebElement loginbtn;
	public WebElement getUsertxtedit() {
		return usertxtedit;
	}
	public WebElement getPasstxtedit() {
		return passtxtedit;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
