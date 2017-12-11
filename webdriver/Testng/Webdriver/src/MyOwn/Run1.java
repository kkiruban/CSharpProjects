package MyOwn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Run1 {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement w=driver.findElement(By.linkText("Projects & Customers"));
		w.click();
		WebElement w1=driver.findElement(By.name("selectedCustomer"));
		Select s=new Select(w1);
		s.selectByVisibleText("kasi");
		String expectedstring="kiruba";
		driver.findElement(By.linkText(expectedstring)).click();
		String actualstring=driver.findElement(By.xpath("//td[contains(text(),'You have selected project:')]/following-sibling::td/span")).getText();
		if(expectedstring.equalsIgnoreCase(actualstring)){
			System.out.println("string is present");
		}else{
			System.out.println("string is not present");
		}
		driver.findElement(By.xpath("//input[@value='Delete This Project']")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		
	}

}
