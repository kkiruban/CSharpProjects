package RedBus;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class Test1 {
  @Test
  public void testCase1() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://www.redbus.in/?gclid=CMOP7OCt17cCFY9V4godiiIAFw");
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//input[@id='DDLSource']")).sendKeys("bangalore");
	  driver.findElement(By.xpath("//input[@id='DDLDestination']")).sendKeys("hyderbad");
	  driver.findElement(By.xpath("//img[@alt='Select your date of journey']")).click();
	  driver.findElement(By.xpath("//tbody/tr[5]/td[6]/a")).click();
	  //driver.findElement(By.xpath("//*[@id='rbcal_calendar']/div/div/table[1]/tbody/tr[5]/td[6]/a")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//img[@alt='Select your date of return']")).click();
	  //driver.findElement(By.xpath("//table[1]/tbody/tr[6]/td[1]/a")).click();
	  driver.findElement(By.xpath("//div[@id='rbcal_calendar1']/div/div/table[1]/tbody/tr[6]/td[1]")).click();
	  driver.findElement(By.id("searchBtn")).click();
	  driver.findElement(By.id("useBookImg4406188")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("4406188-K2")).click();
	  Select sel=new Select(driver.findElement(By.id("boardinPointList4406188")));
	  sel.selectByIndex(1);
	  driver.findElement(By.xpath("//a[@class='continueBtnimg']")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.id("srTxt")).click();
	  Thread.sleep(5000);
	  driver.findElement(By.name("PHONE")).sendKeys("9738685973");
	  driver.findElement(By.name("EMAILID")).sendKeys("kirubavit@gmail.com");
	  driver.findElement(By.name("PRIADDR")).sendKeys("salem");
	  driver.findElement(By.name("PRIADDR")).sendKeys("salem");
	  Select s=new Select(driver.findElement(By.id("TYPEID")));
	  s.selectByIndex(1);
	  Thread.sleep(2000);
	  Alert alt=driver.switchTo().alert();
	  alt.accept();
	  
	  driver.findElement(By.xpath("//input[@id='IDVALUE']")).sendKeys("9999");
  }
}
