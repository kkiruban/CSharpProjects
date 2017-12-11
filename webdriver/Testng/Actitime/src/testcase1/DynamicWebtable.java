package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import bsh.Capabilities;

public class DynamicWebtable {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Projects & Customers")).click();
	  Actions act1=new Actions(driver);
	  
	  
//	  String url="http://"+192.168.0.1+":"+"4444"+"/wd/hub";
//	  http://192.168.0.1/
//	  192.168.0.1
//	  url clienturl=new url(url);
	  // DesiredCapabilities capability = DesiredCapabilities.firefox();
//	  RemoteWebDriver driver = new RemoteWebDriver(clienturl,capability );
//	  these 4 steps u have to write
	 
	  //RemoteWebDriver driver12=new RemoteWebDriver("url", );
	 // RemoteWebDriver driver12=new 
  }
}
