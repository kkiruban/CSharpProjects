package com.SFDC.tests.SalesforceAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sampletest {
  @Test
  public void test01() {
	  
	  System.out.println("test01 is successful");
  }
  
  @Test
  public void test02() {
	  Assert.assertTrue(false);
  }
}
