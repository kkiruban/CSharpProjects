package FrameWorkPratice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		FrameGenric fg=new FrameGenric();
		String username=fg.getexceldata("sheet1", 1, 2);
		String password=fg.getexceldata("sheet1",1, 3);
		WebDriver driver= new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys(username);
	     driver.findElement(By.name("pwd")).sendKeys(password);
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//img[@alt='Logout']")).click();

	}

}
