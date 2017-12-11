package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Marketing {
	@FindBy (xpath="//a[contains(text(),'Marketing')]")
	private WebElement marketinglinktxt;
	@FindBy (xpath="//div[@id='Marketing_sub']/table/tbody/tr[1]/td/a")
	private WebElement campainlinktxt;
	@FindBy(xpath="//div[@id='Marketing_sub']/table/tbody/tr[2]/td/a")
	private WebElement accountlinktxt;
	@FindBy (xpath="//div[@id='Marketing_sub']/table/tbody/tr[3]/td/a")
	private WebElement contactlinktxt;
	@FindBy(xpath="//div[@id='Marketing_sub']/table/tbody/tr[4]/td/a")
	private WebElement webmaillinktxt;
	@FindBy (xpath="//div[@id='Marketing_sub']/table/tbody/tr[5]/td/a")
	private WebElement leadslinktxt;
	@FindBy (xpath="//div[@id='Marketing_sub']/table/tbody/tr[6]/td/a")
	private WebElement calenderlinktxt;
	@FindBy(xpath="//div[@id='Marketing_sub']/table/tbody/tr[7]/td/a")
	private WebElement documentslinktxt;
	public WebElement getMarketinglinktxt() {
		return marketinglinktxt;
	}
	public WebElement getCampainlinktxt() {
		return campainlinktxt;
	}
	public WebElement getAccountlinktxt() {
		return accountlinktxt;
	}
	public WebElement getContactlinktxt() {
		return contactlinktxt;
	}
	public WebElement getWebmaillinktxt() {
		return webmaillinktxt;
	}
	public WebElement getLeadslinktxt() {
		return leadslinktxt;
	}
	public WebElement getCalenderlinktxt() {
		return calenderlinktxt;
	}
	public WebElement getDocumentslinktxt() {
		return documentslinktxt;
	}
	

}
