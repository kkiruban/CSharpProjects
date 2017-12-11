package FrameworkWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Customertest {
  @Test
  public void test2() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//img[@alt='Logout']")).click();
  }
}
