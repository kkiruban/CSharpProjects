package Com.Actitme.GenricLib;

import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;



public class Log4j {

	
	public Logger loggermethod(){
		
		Logger log1=Logger.getLogger("Log4j.class");
		Properties properties = new Properties();
		properties.put("log4j.rootLogger", "INFO,Console");
		properties.put("log4j.appender.Console", "org.apache.log4j.ConsoleAppender");
		properties.put("log4j.appender.Console.layout", "org.apache.log4j.PatternLayout");
		properties.put("log4j.appender.Console.layout.ConversionPattern", "%-4r [%d] %-5p %c %x - %m%n");
		PropertyConfigurator.configure(properties);		
		BasicConfigurator.configure();
		return log1;
		
		

	}
	public static void main(String[] args){
		Log4j log=new Log4j();
		log.loggermethod().info("kiruba is great");
		
	}

}
