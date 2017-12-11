package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Campaign {
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createcampaignimglink;

	public WebElement getCreatecampaignimglink() {
		return createcampaignimglink;
	}

}
