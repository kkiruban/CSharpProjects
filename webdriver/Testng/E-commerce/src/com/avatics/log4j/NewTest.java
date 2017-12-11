package com.avatics.log4j;

import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;



public class NewTest {
  @Test
  public void f() {
	  Logger logger=Logger.getLogger(NewTest.class);
	  BasicConfigurator.configure();
	  logger.info("First statement");
	  logger.warn("fshjkjfgbilhkv");
	  logger.error("error page");
	  
  }
}  
