package RedBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GetOptions {

	
	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
	     driver.findElement(By.name("pwd")).sendKeys("manager");
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	     WebElement wb=driver.findElement(By.name("customerProject.shownCustomer"));
         Select sel=new Select(wb);
         List<WebElement> lst=sel.getOptions();
         System.out.println(lst.size());
         for(int i=0;i<lst.size();i++){
         System.out.println(lst.get(i).getText());
            }
	}

}
