package Com.Actitime.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	

	@FindBy(name="username")
	private WebElement usernameedit;

	@FindBy(name="pwd")
	private WebElement passwordedit;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginbtn;
	
	
	
}
