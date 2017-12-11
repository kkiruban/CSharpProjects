package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaign {
	@FindBy(name="campaignname")
	private WebElement campaignnametxtbox;
	@FindBy(name="assigntype")
	private WebElement assigntyperadiobtn;
	@FindBy(name="campaigntype")
	private WebElement campaigntypeselbox;
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement productselimglink;
	public WebElement getCampaignnametxtbox() {
		return campaignnametxtbox;
	}
	public WebElement getAssigntyperadiobtn() {
		return assigntyperadiobtn;
	}
	public WebElement getCampaigntypeselbox() {
		return campaigntypeselbox;
	}
	public WebElement getProductselimglink() {
		return productselimglink;
	}
	

}
