package com.test.sample.tests;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.sample.BaseTest;
import com.test.sample.Config;
import com.test.sample.BrowserType;
import com.test.sample.utils.BrowserFactory;

public class test1 extends BaseTest{
	
	
	
	public test1() {
		logger = Logger.getLogger(this.getClass());
	}
	
	@Test
	public void test1() {
		altID = 1;
		logger.info("test completed :"+Config.getValue("URL"));
//		BrowserFactory.getBrowser(BrowserType.FIREFOX);
		
		try {
			googleSearchNavigator.validateHomePage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		isSuccess = true;
	}
	@Test
	public void test2() {
		altID = 2;
		logger.info("test completed :"+Config.getValue("URL"));
		Assert.assertTrue(false);
		isSuccess = false;
	}
	
	@AfterMethod 
	public void aftermethod() {
		baseAfterMethod();
	}
	@BeforeMethod
	public void beforeMethod() {
		isSuccess = false;
	}
}
