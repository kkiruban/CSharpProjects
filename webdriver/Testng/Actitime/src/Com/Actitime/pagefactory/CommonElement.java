package Com.Actitime.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonElement {
	public WebElement getLogoutbtn() {
		return logoutbtn;
	}
	@FindBy(xpath="//img[@alt='Logout']")
	private WebElement logoutbtn;

}
