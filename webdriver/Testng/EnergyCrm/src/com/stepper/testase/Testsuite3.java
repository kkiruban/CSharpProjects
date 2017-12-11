package com.stepper.testase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testsuite3 {
  @BeforeClass
  public void testcase0(){
	  System.out.println("what to do");
  }
  @AfterClass
  public void testcase4(){
	  System.out.println("over");
  }
	@Test
	public void testcase1(){
		System.out.println("hi");
	}
	@Test
	public  void testcase12(){
		System.out.println("hi hi");
	}
	@BeforeMethod
	public void testcase2(){
		System.out.println("baby");
	}
  @AfterMethod
  public void testcase3(){
	  System.out.println("fuck ");
  }
}
