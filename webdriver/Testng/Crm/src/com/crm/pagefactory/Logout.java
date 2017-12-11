package com.crm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutlink;

	public WebElement getLogoutlink() {
		return logoutlink;
	}

}
