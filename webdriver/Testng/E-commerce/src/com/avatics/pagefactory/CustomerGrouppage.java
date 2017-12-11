package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerGrouppage {
	@FindBy(xpath="//div[@class='button button_small']")
	private WebElement clickclosebut;

	public WebElement getClickclosebut() {
		return clickclosebut;
	}

}
