package MyOwn;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Run3 {

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Projects & Customers")));
		WebElement w=driver.findElement(By.linkText("Projects & Customers"));
		w.click();
		WebElement w1=driver.findElement(By.name("selectedCustomer"));
		Select s=new Select(w1);
		List<WebElement> l=s.getOptions();
		System.out.println("size of selectbox="+l.size());
		boolean flag=true;
		String expectedstring="yyyy";
		System.out.println("list of users in selectbox");
		for(int i=0;i<l.size();i++){
			
			String actualstring=l.get(i).getText();
			System.out.println(actualstring);
			if(expectedstring.equalsIgnoreCase(actualstring)){
				System.out.println("expected string is present");
				 flag=false;
				 break;
    			
		      }
			}
			
		}

	}


