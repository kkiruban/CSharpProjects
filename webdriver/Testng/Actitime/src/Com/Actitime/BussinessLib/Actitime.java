package Com.Actitime.BussinessLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

import Com.Actitime.pagefactory.CommonElement;
import Com.Actitime.pagefactory.Login;
import Com.Actitme.GenricLib.Driver;

public class Actitime {
	public	CommonElement commElement=PageFactory.initElements(Driver.driver,CommonElement.class);
	public Login login=PageFactory.initElements(Driver.driver, Login.class);
	public  void logintoapp(String username,String password) {
		Driver.driver.get("http://kiruba-vaio/login.do");
		/*Driver.driver.findElement(By.name("username")).sendKeys(username);
		Driver.driver.findElement(By.name("pwd")).sendKeys(password);
		Driver.driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		login.getUsernameedit().sendKeys(username);
		   login.getPasswordedit().sendKeys(password);
		   login.getLoginbtn().click();
		
	}
    public void logoutFromApp(){
    	//Driver.driver.findElement(By.xpath("//img[@alt='logout'")).click();
    	commElement.getLogoutbtn().click();
    }
    public void sslcerficateerror(){
    	FirefoxProfile profile= new FirefoxProfile();
  	  profile.setAssumeUntrustedCertificateIssuer(false);
  	  WebDriver driver= new FirefoxDriver(profile);
  	  driver.get("https://ess5-white.echo360.com:8443/ess");
    }
}

