package MyOwn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Run7 {

	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Projects & Customers")).click();
		driver.findElement(By.linkText("bdfb")).click();
		driver.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
		Alert a=driver.switchTo().alert();
		System.out.println("get alerttext="+a.getText());
		a.dismiss();
		//a.accept();
	}

}
