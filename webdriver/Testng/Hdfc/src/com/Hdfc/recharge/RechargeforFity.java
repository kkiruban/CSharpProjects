package com.Hdfc.recharge;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RechargeforFity {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://www.hdfcbank.com/");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//a[contains(text(),'Recharge your Mobile')]")).click();
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	  driver.findElement(By.xpath("//a[contains(text(),'Click here to recharge now')]")).click();
	  Set<String> set=driver.getWindowHandles();
	  Iterator<String> it=set.iterator();
	  String parentwindow=it.next();
	  String childwindow=it.next();
	  driver.switchTo().window(childwindow);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.findElement(By.name("btnModify")).click();
	  driver.findElement(By.xpath("//input[@value='Continue']")).click();
	  WebElement wb=driver.findElement(By.name("ddlOperators"));
	  Select sel=new Select(wb);
	  sel.selectByVisibleText("Idea");
	  Thread.sleep(3000);
	  WebElement wb1=driver.findElement(By.name("ddlSubOperators"));
	  Select sel1=new Select(wb1);
	  sel1.selectByVisibleText("Idea - Mumbai");
	  Thread.sleep(2000);
	  driver.findElement(By.name("txtMoblieNo")).sendKeys("8693010853");
	  driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
	  driver.findElement(By.name("txtAmount")).sendKeys("50");
	  driver.findElement(By.name("btnRefill")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.name("btnConfirm")).click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
   List<WebElement> urllist=driver.findElements(By.tagName("frame"));
   System.out.println(urllist.size());
   System.out.println("list of frame id");
   for(int k=0;k<=urllist.size()-1;k++){
	   System.out.println(urllist.get(k).getAttribute("name"));
   }
   driver.switchTo().frame("bottom_frame");
   Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@class='input_password']")).sendKeys("41085535");
  
	  	  String url=driver.getCurrentUrl();
    System.out.println(url);
    driver.findElement(By.xpath("//img[@alt='continue']")).click();
    driver.findElement(By.name("fldPassword")).sendKeys("kiruba123!");
    driver.findElement(By.name("chkrsastu")).click();
    driver.findElement(By.xpath("//img[@alt='Log In']")).click();
    driver.switchTo().defaultContent();
    Select sel6=new Select(driver.findElement(By.name("selAcct")));
    sel6.selectByIndex(3);
    driver.switchTo().defaultContent();
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    driver.findElement(By.xpath("//*[contains(text(),'continue')]")).click();
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    driver.findElement(By.xpath("//img[@alt='Confirm']")).click();
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    driver.findElement(By.name("fldAnswer")).sendKeys("26");
    driver.findElement(By.name("fldAnswer")).sendKeys("26");
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    driver.findElement(By.xpath("//img[@alt='continue']")).click();
    driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    System.out.println("recharged  successfully");
     
  }
}
