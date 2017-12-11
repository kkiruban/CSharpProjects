package com.seleniumtesting.automationtesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Login {
	
	
	
  @Test
  public void f() throws InterruptedException {
   
	  System.setProperty("webdriver.ie.driver", "D:\\selenium-jars\\ie\\IEDriverServer.exe");
	   WebDriver driver=new InternetExplorerDriver();
	   driver.get("https://responsecpq.positiveedge.net/Login.aspx#/");
	   Thread.sleep(20000);
	   
	  
  }
  
  
}
