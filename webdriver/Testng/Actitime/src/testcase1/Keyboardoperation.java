package testcase1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Keyboardoperation {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://my.naukri.com/manager/createacc2.php?othersrcp=5424&wExp=N&id=26993f348ec94e5d50489d60cfdab585ac0a8beabbcd794bfff78214f9cef3feff003c62a2e1a36431b890266d0ecd01|X|Y|X|E");
	  Thread.sleep(2000);
	  Actions act=new Actions(driver);
	  act.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("kirubavit@gmail.com",Keys.TAB);
	  String s1=driver.getTitle();
	  System.out.println(s1);
	  driver.findElement(By.xpath("//strong[contains(text(),'Forgot your Password?')]")).click();
	  
	  
//	  Set<String> set=driver.getWindowHandles();
//	  Iterator<String> it=set.iterator();
//	  String parentwindow=it.next();
//	  String childwindow=it.next();
//	  driver.switchTo().window(childwindow);
//	  driver.findElement(By.name("PASSWORD")).sendKeys("kiruba");
	  	  
  }
}
