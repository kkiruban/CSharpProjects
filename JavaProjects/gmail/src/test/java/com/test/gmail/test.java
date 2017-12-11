package com.test.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.gmail.pageobjects.loginpage;


public class test {

   	
	@Test
	public void f() throws InterruptedException{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://test.salesforce.com/");
		Thread.sleep(10000);
		
		loginpage loginpage = PageFactory.initElements(driver, loginpage.class);
		
		boolean flag = loginpage.login("dsintegration-admin@servicesource.com.sitnext", "srevds123!");
		Assert.assertTrue(flag, "Login Failed.");
		//driver.findElement(By.id("username")).sendKeys("dsintegration-admin@servicesource.com.sitnext");
		//driver.findElement(By.id("password")).sendKeys("srevds123!");
		//driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		driver.close();
	}
	

	@Test
	public void f1(){
		System.out.println("Test 2 Successful.");
		
	}
}
