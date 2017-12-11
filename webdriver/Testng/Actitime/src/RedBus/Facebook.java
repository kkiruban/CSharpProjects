package RedBus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Facebook {
	public WebDriver driver=new FirefoxDriver();
	@BeforeMethod
	public void Case1(){
		
		  driver.get("https://www.facebook.com/");;
	}
  @Test
  public void f() {
	  
	  driver.findElement(By.name("email")).sendKeys("kiru_dawn@yahoo.co.in");
	  driver.findElement(By.name("pass")).sendKeys("dollar123");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	  
	  }
  @Test
  public void f1(){
  
  }
  @AfterMethod
  public void case2(){
	  driver.findElement(By.id("userNavigationLabel")).click();
	  driver.findElement(By.xpath("//input[@value='Log Out']")).click();
  }
}
