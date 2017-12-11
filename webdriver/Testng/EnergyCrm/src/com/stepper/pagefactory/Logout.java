package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout {
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	private WebElement logoutlinktxt;

	public WebElement getLogoutlinktxt() {
		return logoutlinktxt;
	}

}
