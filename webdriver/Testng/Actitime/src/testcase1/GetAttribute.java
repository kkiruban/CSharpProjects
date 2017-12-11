package testcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetAttribute {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver = new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  String value=driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("type");
	  System.out.println(value);
//	  
//	  Thread.sleep(2000);
//	  driver.findElement(By.xpath("//input[@value='Add New Tasks']")).click();
	  
  }
}
