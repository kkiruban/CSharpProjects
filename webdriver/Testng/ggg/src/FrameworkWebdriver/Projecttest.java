package FrameworkWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Projecttest {
  @Test
  public void test1() {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.findElement(By.xpath("//img[@alt='Logout']")).click();
	  
  }
}
