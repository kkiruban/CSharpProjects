package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reviewinformationpage {
	@FindBy(name="review_data[review]")
	private WebElement reviewinformationpage;

	public WebElement getReviewinformationpage() {
		return reviewinformationpage;
	}
  @FindBy(xpath="//div[@id='UpdateButton2']")
   private WebElement savebut;

public WebElement getSavebut() {
	return savebut;
}
}
