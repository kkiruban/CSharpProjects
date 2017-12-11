package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExportCustomerpage {
	@FindBy(xpath="//input[@id='infotag_ID']")
	private WebElement attributechkbox;

	public WebElement getAttributechkbox() {
		return attributechkbox;
	}
	@FindBy(xpath="//input[@id='infotag_AccountName']")
	private WebElement accountchkbox;

	public WebElement getAccountchkbox() {
		return accountchkbox;
	}
   @FindBy(xpath="//div[text()='Start']")
   private  WebElement startbut;

    public WebElement getStartbut() {
	 return startbut;
}
    public WebElement getCancelbut() {
		return cancelbut;
	}
	@FindBy(xpath="//div[@class='button button_small']")
    private WebElement cancelbut;
	@FindBy(xpath="//div[@id='DownloadCSVButton1']")
	private WebElement downloadbut;

	public WebElement getDownloadbut() {
		return downloadbut;
	}
}
