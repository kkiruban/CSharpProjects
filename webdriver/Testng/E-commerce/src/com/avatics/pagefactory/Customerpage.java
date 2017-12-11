package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Customerpage {
	
	@FindBy(linkText="Customers")
	private WebElement customerlnk;

	public WebElement getCustomerlnk() {
		return customerlnk;
	}
	@FindBy(linkText="steve@avactis-demo.com")
	private WebElement userlnk;

	public WebElement getUserlnk() {
		return userlnk;
	}
	@FindBy(xpath="//*[@id='customer_1']")
	private WebElement selaccountchkbox;

	public WebElement getSelaccountchkbox() {
		return selaccountchkbox;
	}
	@FindBy(xpath="//*[@id='DeleteButton2']")
	private WebElement deletebut;

	public WebElement getDeletebut() {
		return deletebut;
	}
	@FindBy(xpath="//*[@id='ActivateButton2']")
	private WebElement activatebut;

	public WebElement getActivatebut() {
		return activatebut;
	}
	@FindBy(name="search_string")
	private WebElement searchedit;

	public WebElement getSearchedit() {
		return searchedit;
	}
	@FindBy(xpath="//tbody/tr/td[3]/div[text()='Search']")
	private WebElement searchbut;

	public WebElement getSearchbut() {
		return searchbut;
	}
	@FindBy(xpath="//tbody/tr[5]/td[3]")
	private WebElement getcutomernametext;

	public WebElement getGetcutomernametext() {
		return getcutomernametext;
	}
	@FindBy(xpath="//div[@id='CustomerGroupsButton2']")
    private WebElement customergroupbut;

	public WebElement getCustomergroupbut() {
		return customergroupbut;
	}
	@FindBy(xpath="//div[text()='Reset passwords']")
	private WebElement resetpassbut;

	public WebElement getResetpassbut() {
		return resetpassbut;
	}
	@FindBy(xpath="//div[text()='Export']")
	private WebElement exportbut;

	public WebElement getExportbut() {
		return exportbut;
	}
	@FindBy(name="letter_filter_by")
	private WebElement filterbydropdown;

	public WebElement getFilterbydropdown() {
		return filterbydropdown;
	}
}
