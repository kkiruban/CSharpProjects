package com.Hdfc.recharge;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Nakurifileupload {
  @Test
  public void f() throws IOException {
	  
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://my.naukri.com/manager/createacc2.php?othersrcp=7304&adnetwork=%22google%22&account=%22naukri%20search%22&campaign=%22Brand%22&adgroup=%22naukri_exact%22&keyword=%22naukri%22&match=%22exact%22&lmd=%2216-may-2012%22&gclid=CJjZpamhiLsCFWsF4godA3cAdw");
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  List<WebElement> list=driver.findElements(By.tagName("iframe"));
	  for(int i=0;i<=list.size()-1;i++){
		  System.out.println(list.get(i).getAttribute("id"));
	  }

	  driver.switchTo().frame("frmUpload");
	  driver.findElement(By.name("BROWSECV")).click();
	  driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
	  Runtime.getRuntime().exec("C:\\Users\\kiruba\\Desktop\\New AutoIt v3 Script.exe");
  }
}
