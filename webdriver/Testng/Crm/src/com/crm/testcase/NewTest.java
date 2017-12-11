package com.crm.testcase;


import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.bussinesslib.Crm;
import com.crm.genriclib.Driver;



public class NewTest {
	
	  
	  public Crm buslib=new Crm();
	  

  @Test
  public void f() throws InvalidFormatException, IOException {
	  buslib.logintocrm();
	WebElement wb=  Driver.driver.findElement(By.xpath("//a[contains(text(),'Marketing')]"));
	Actions act=new Actions(Driver.driver);
	act.moveToElement(wb).perform();
	//Driver.driver.findElement(By.xpath("//div[@id='Marketing_sub']/table/tbody/tr[1]/td/a")).click();
	List<WebElement> lst=Driver.driver.findElements(By.xpath("//div[@id='Marketing_sub']/table/tbody/tr"));
	int len=lst.size();
	System.out.println(len);
	for(int i=0;i<len;i++){
		System.out.println(lst.get(i).getText());
	}
	  
  }
}
