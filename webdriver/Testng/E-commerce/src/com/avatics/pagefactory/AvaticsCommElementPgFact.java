package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AvaticsCommElementPgFact {
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(linkText="Orders")
	private WebElement ordersLnk;

	public WebElement getOrdersLnk() {
		return ordersLnk;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

}
