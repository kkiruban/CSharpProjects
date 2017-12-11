package com.testng.sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Sample1 {

	@BeforeTest
	public void beforeTest() {
    System.out.println("delete cookies");
	}
	
	@BeforeMethod
	public void beforemethod(){
		System.out.println("before method");
	}

	@Test(groups={"SmokeTest"})
	public void login() {
     System.out.println("login into application");
		 
	}

	@Test
	public void loginprod() {
     System.out.println("loginprod");
		 
	}
	
	@AfterMethod
	public void aftermethod(){
		System.out.println("after method");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}

}
