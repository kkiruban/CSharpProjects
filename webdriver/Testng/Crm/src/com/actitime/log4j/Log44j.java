package com.actitime.log4j;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class Log44j {
 @Test
  public void f() 
  {
	  Logger logger=Logger.getLogger(Log4j.class);
	  BasicConfigurator.configure();
	  logger.info("First statement");
	  logger.warn("fshjkjfgbilhkv");
	  logger.error("error page");
	  
  }
}
