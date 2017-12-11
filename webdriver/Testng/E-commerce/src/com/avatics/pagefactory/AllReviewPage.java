package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllReviewPage {
	@FindBy(xpath="//div[@id='edit_80']")
	private WebElement editboxbut;

	public WebElement getEditboxbut() {
		return editboxbut;
	}

}
