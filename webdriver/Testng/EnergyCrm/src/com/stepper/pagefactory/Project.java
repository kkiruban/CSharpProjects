package com.stepper.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Project {
	@FindBy(xpath="//a[contains(text(),'stepper motor 19v')]")
	private WebElement projectnameintablelink;

	public WebElement getProjectnameintablelink() {
		return projectnameintablelink;
	}

}
