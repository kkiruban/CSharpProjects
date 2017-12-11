package Middle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Facebook {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kiru_dawn@yahoo.co.in");
		driver.findElement(By.name("pass")).sendKeys("dollar123");
		driver.findElement(By.id("u_0_b")).click();
		driver.findElement(By.id("profile_pic_header_1265465841")).click();

	}

}
