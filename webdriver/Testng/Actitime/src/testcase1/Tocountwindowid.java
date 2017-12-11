package testcase1;

import java.sql.Time;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Tocountwindowid {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("Time-Track")).click();
	  Thread.sleep(3000);
	  WebElement wb1=driver.findElement(By.name("selectedUser"));
	  Select sel=new Select(wb1);
	  
	  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	  sel.selectByVisibleText("xxx, xxx (xxxx)");
	  //driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	  WebDriverWait wait=new WebDriverWait(driver, 50000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add tasks to the list')]")));
	  driver.findElement(By.xpath("//a[contains(text(),'Add tasks to the list')]")).click();
	  Set<String> set=driver.getWindowHandles();
	  Iterator<String> it = set.iterator();
	  String s1=it.next();
	  String s2=it.next();
	  driver.switchTo().window(s2);
	 String s3= driver.getTitle();
	 System.out.println(s3);
  }
}
