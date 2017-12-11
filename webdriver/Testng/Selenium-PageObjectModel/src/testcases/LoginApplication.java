package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import objectrepo.RediffHomePage;
import objectrepo.RediffLoginPage;
import objectrepo.RediffLoginPagePF;

public class LoginApplication {
	
	@Test
	  public void Login(){
		
		WebDriver driver =new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		RediffLoginPage rdlogin= new RediffLoginPage(driver);
		RediffLoginPagePF rdlogin = new RediffLoginPagePF(driver);
//		rdlogin.EmailId().sendKeys("123");
		rdlogin.EmailId().sendKeys("kirubanand");
		rdlogin.Password().sendKeys("123");
		rdlogin.Go().click();
		rdlogin.HomeLink().click();
		RediffHomePage rdhomepage =new RediffHomePage(driver);
		rdhomepage.SearchBox().sendKeys("kiruba");
		
	}

}
