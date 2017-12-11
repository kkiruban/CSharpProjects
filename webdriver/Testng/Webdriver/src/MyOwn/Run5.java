package MyOwn;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Run5 {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		
		WebElement w=driver.findElement(By.linkText("Time-Track"));
		w.click();
	
		WebElement w1=driver.findElement(By.name("selectedUser"));
	Select s=new Select(w1);
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	List<WebElement> l=s.getOptions();
	System.out.println(l.size());
	s.selectByIndex(1);
	//s.selectByVisibleText("xxx, xxx (xxxx)");
	driver.findElement(By.xpath("//a[@href='javascript: openAddTasksPopup();']")).click();
	Set<String> s1=driver.getWindowHandles();
	System.out.println(s1);
	Iterator<String> it=s1.iterator();
	String parentwindow=it.next();
	String childwindow=it.next();
	System.out.println(parentwindow);
	System.out.println(childwindow);
	driver.switchTo().window(childwindow);
	
	WebElement w2=driver.findElement(By.name("customerProject.shownCustomer"));
	Select s2=new Select(w2);
	List<WebElement> l2=s2.getOptions();
	System.out.println(l2.size());
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	s2.selectByVisibleText("prabha1");
	WebElement w3=driver.findElement(By.name("customerProject.shownProject"));
	Select s3=new Select(w3);
	List<WebElement> l3=s3.getOptions();
	System.out.println(l3.size());
	s3.selectByIndex(1);
	String s5=driver.findElement(By.xpath("//input")).getAttribute("type");
	System.out.println(s5);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.switchTo().window(parentwindow);
	driver.findElement(By.linkText("Reports")).click();
		

	}

}
