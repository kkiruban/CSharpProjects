package com.crm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Marketing {
	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketinglink;

	public WebElement getMarketinglink() {
		return marketinglink;
	}
	@FindBy(linkText="Campaigns")
	private WebElement campaignslink;

	public WebElement getCampaignslink() {
		return campaignslink;
	}

}
