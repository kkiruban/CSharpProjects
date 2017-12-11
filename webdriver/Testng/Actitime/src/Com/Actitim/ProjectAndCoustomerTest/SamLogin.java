package Com.Actitim.ProjectAndCoustomerTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.Actitime.pagefactory.CommonElement;
import Com.Actitime.pagefactory.Login;
import Com.Actitme.GenricLib.Driver;

public class SamLogin {
	public Login loginpage=PageFactory.initElements(Driver.driver, Login.class);
	public CommonElement com=PageFactory.initElements(Driver.driver, CommonElement.class);
  @Test
  public void Sampletest() throws InterruptedException {
	  Driver.driver.get("http://kiruba-vaio/login.do");
	  loginpage.getUsernameedit().sendKeys("admin");
	  loginpage.getPasswordedit().sendKeys("manager");
	  loginpage.getLoginbtn().click();
	  Thread.sleep(2000);
	  //loginpage.getLogoutbtn().click();
	  com.getLogoutbtn().click();
  }
}
