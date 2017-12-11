package FrameworkSample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestBase {
  
	public WebDriver driver = null;
	
	@Test
  public void Login() throws IOException {
		
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream("D:\\webdriver\\Testng\\Selenium-WebDriver-Testng-Sample\\src\\FrameworkSample\\datadriven.properties");
	
		pro.load(fis);
   
		 if (pro.getProperty("browser").equals("firefox")){
		    driver = new FirefoxDriver();
		 }
		 else if (pro.getProperty("browser").equals("chrome")) {
			 driver = new ChromeDriver();	
		}
		 else {
			 driver = new InternetExplorerDriver();
		}
		 
		 driver.get(pro.getProperty("URL"));
		
  }
}
