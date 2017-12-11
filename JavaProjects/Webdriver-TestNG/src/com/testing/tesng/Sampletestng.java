package com.testing.tesng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Sampletestng {
	
//	RemoteWebDriver webDriver = driver.getWebDriver();
	public WebDriver driver = new FirefoxDriver();
	
	@BeforeSuite
	  public void beforeSuite() {
		driver.get("https://test.salesforce.com/");
		System.out.println("before suite");
	}
	
	 @AfterSuite
	  public void afterSuite() {
		 System.out.println("After suite");
		 driver.quit();
	  }
	
	@Test(dataProvider="getData")
	public void setData(String username, String password)
	{
		System.out.println("you have provided username as::"+username);
		System.out.println("you have provided password as::"+password);
	}

	
	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="dsintegration-admin@servicesource.com.sitf5";
	data[0][1] = "srevds123!";

	// 2nd row
	data[1][0] ="1pf5.opsmgr@servicesource.com.sitf5";
	data[1][1] = "testf5123!";
	
	// 3rd row
	data[2][0] ="1pf5.opsrep@servicesource.com.sitf5";
	data[2][1] = "testf5123!";

	return data;
	}
	
	@BeforeClass
	  public void beforeClass() {
		System.out.println("beforeClass");    
	}
	

	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest");
  }

  
  
  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod");
  }


  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass");
  }


  @AfterTest
  public void afterTest() {
	  
	  System.out.println("afterTest");
  }

}


