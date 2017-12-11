package Middle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Run3 {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//input[@class='gbqfif']")).sendKeys("co");
		driver.findElement(By.xpath("//span/b[text()='medk']")).click();
	//Actions a=new Actions(driver);
	//a.doubleClick(wb).perform();
		
		
	}

}
