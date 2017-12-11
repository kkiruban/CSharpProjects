package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPageFactory {
	@FindBy(xpath="//td[text()='Orders']")
	private WebElement ordersText;

	public WebElement getOrdersText() {
		return ordersText;
	}
}
