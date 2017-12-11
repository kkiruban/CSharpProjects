package com.avatics.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Reviewpage {
	@FindBy(linkText="Reviews")
	private WebElement reviewslink;

	public WebElement getReviewslink() {
		return reviewslink;
	}
	@FindBy(xpath="//a[text()='Pending Reviews']")
	private WebElement penreviewslink;

	public WebElement getPenreviewslink() {
		return penreviewslink;
	}
   @FindBy(xpath="//a[text()='Bad Reviews (2 stars and below)']")
   private WebElement badreviewslink;

    public WebElement getBadreviewslink() {
	return badreviewslink;
   }
    @FindBy(xpath="//a[text()='Good Reviews (4 stars and above)']")
    private WebElement goodreviewslink;

	public WebElement getGoodreviewslink() {
		return goodreviewslink;
	}
	@FindBy(xpath="//a[text()='All Reviews']")
	private WebElement allreviewslink;

	public WebElement getAllreviewslink() {
		return allreviewslink;
	}
	
}
