package pack;

import java.util.concurrent.LinkedTransferQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Samole1 {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\studies\\selenium drivers and jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		//WebDriver driver=new FirefoxDriver();
		//driver.get("http://kiruba-vaio/login.do");
		//driver.findElement(By.name("username")).sendKeys("admin");
		
	//	driver.findElement(By.name("pwd")).sendKeys("manager");
		
		//driver.findElement(By.xpath("//input[@ type='submit']")).click();
		//driver.findElement()
		
		
		
		
		

	}

}
