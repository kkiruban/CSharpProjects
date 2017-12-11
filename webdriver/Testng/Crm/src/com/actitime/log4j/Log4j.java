package com.actitime.log4j;

import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.BasicConfigurator;
import org.testng.log4testng.Logger;

public class Log4j {

	
	public static void main(String[] args) {
		
Logger logger=Logger.getLogger(Log4j.class);
BasicConfigurator.configure();
String str="Login To app";
logger.info("str");
logger.warn("str");
logger.fatal("str");
logger.debug("str");
System.out.println(logger.getClass());
	}

}
