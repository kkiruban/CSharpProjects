package com.selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SampleWebdriver {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://test.salesforce.com/");
		 System.out.println(driver.getCurrentUrl());  		 
		
	  driver.findElement(By.name("username")).sendKeys("dsintegration-admin@servicesource.com.sitmcafee");
	  driver.findElement(By.name("pw")).sendKeys("srevds123!");
	  driver.findElement(By.name("Login")).click();
	  driver.close();
	}

}