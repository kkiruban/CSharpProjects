package com.SFDC.tests.SalesforceAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SFDC.pageobjects.createaccountpage;
import com.SFDC.pageobjects.createcontactpage;
import com.SFDC.pageobjects.loginpage;

public class sdfc {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://test.salesforce.com/");
		Thread.sleep(30000);
		driver.manage().window().maximize();
		loginpage salesforceloginpage=PageFactory.initElements(driver, loginpage.class);
		salesforceloginpage.loginsalesforcesite("dsintegration-admin@servicesource.com.sitnext", "srevds123!");
		Thread.sleep(30000);
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Account_Tab']/a")));
	}

	@Test
	public void createaccount() throws InterruptedException {
		createaccountpage createrandomaccount=PageFactory.initElements(driver, createaccountpage.class);
		boolean flag = createrandomaccount.createaccount("smoke-test-account-1234");
        Assert.assertTrue(flag, "Accounts not created");
        String expectedtitle="Account: smoke-test-account-1234 ~ Salesforce - Performance Edition";
        
        Assert.assertEquals(driver.getTitle(), expectedtitle);
	}
	
	@Test
	public void createcontact() throws InterruptedException {
		createcontactpage createrandomcontact=PageFactory.initElements(driver, createcontactpage.class);
		boolean flag = createrandomcontact.createcontact("smoke-test-contact-123", "smoke-test-account");
		Assert.assertTrue(flag, "contacts not created");
		
       String expectedtitle="Contact: smoke-test-contact-123 ~ Salesforce - Performance Edition";
       Assert.assertEquals(driver.getTitle(), expectedtitle);
	}
	
	@AfterMethod
	public void quitbrowser() {
		  driver.quit();		
	}

}
