package Pratice;
//log4j



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;








public class NewTest {
	Logger log=Logger.getLogger(NewTest.class);
  @Test
  public void f() {
	  BasicConfigurator.configure();
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  log.info("entered username");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  log.info("entered password");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
		
		log.warn("earn");
		log.info("information.");
		log.debug("debug");
		log.error("hajkf");
  }
  public void executequery(String query) throws SQLException{
	  
	  Connection con=DriverManager.getConnection("jdbc.mysql:womcat","username","password");
	  Statement state=con.createStatement();
	  Result rs= (Result) state.executeQuery(query);
	  
  }
}
