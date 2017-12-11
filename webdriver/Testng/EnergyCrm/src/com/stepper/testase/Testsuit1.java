package com.stepper.testase;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.stepper.businesscomponent.StepperReuse;
import com.stepper.genriccomponent.Driver;
import com.stepper.genriccomponent.ExcelLib;
import com.stepper.genriccomponent.WebdriverCommonuitill;

public class Testsuit1 {
	public StepperReuse bslib=new StepperReuse();
	public WebdriverCommonuitill ewlib= new WebdriverCommonuitill();
	public ExcelLib exlib=new ExcelLib();
	@BeforeClass
	public void bcmethod(){
		Driver.driver.manage();
	}
	@BeforeMethod
	public void bmethod() throws InvalidFormatException, IOException{
		String username=exlib.getExeceldata("sheet1", 2, 2);
	    String password=exlib.getExeceldata("sheet1", 2, 3);
		bslib.logintoapp(username, password);
	    ewlib.waitForPageToLoad(2000);
		
	}
  @Test
  public void test1() throws InterruptedException {
	  bslib.campain();
	  bslib.createcampaign("powergenrators");
//	  Driver.driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//	  Driver.driver.findElement(By.name("campaignname")).sendKeys("powergenrators");
//	  Driver.driver.findElement(By.name("assigntype")).click();
//	  WebElement wbsel1=Driver.driver.findElement(By.name("campaigntype"));
//	  Select sel=new Select(wbsel1);
//	  sel.selectByIndex(4);
//	  Thread.sleep(4000);
//	  Driver.driver.findElement(By.xpath("//img[@alt='Select']")).click();
//	  Thread.sleep(4000);
//	  Set<String> set=Driver.driver.getWindowHandles();
//	  Iterator<String> it1=set.iterator();
//	  String parentwindow=it1.next();
//	  String childwindow=it1.next();
//	  Driver.driver.switchTo().window(childwindow);
//	  Driver.driver.findElement(By.xpath("//a[contains(text(),'stepper motor 19v')]")).click();
//	  Driver.driver.switchTo().window(parentwindow);
	  
	  
	  //maximize window
  }
  
//  @Test
//  public void test2(){
//	  
//  }
  @AfterMethod
  public void amethod() throws InterruptedException{
	  bslib.logout();
	  Thread.sleep(4000);
  }
  @AfterClass
  public void acmethod(){
	  Driver.driver.close();
  }
}
