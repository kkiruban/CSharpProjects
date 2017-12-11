package pack;

import java.awt.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample2 {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
	    //wait implicitly statement
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//to get the list of links in webpage
		java.util.List<WebElement> weblink=driver.findElements(By.xpath("//a"));
		System.out.println("size="+weblink.size());
		java.util.List<WebElement> weblink1=driver.findElements(By.xpath("//INPUT"));
		System.out.println("size="+weblink1.size());
		System.out.println("=====link========");
		for(int i=0;i<=weblink.size()-1;i++){
			System.out.println("link present in webpage="+weblink.get(i).getText());
		}
		// to find the webelement
		
		driver.findElement(By.name("Email")).sendKeys("kirubavit");
		
		
		driver.findElement(By.name("Passwd")).sendKeys("information");
		
		//to get the text from gui
		String kiru=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("text="+kiru);
		String kiru1=driver.findElement(By.xpath("//h4")).getText();
		System.out.println("text="+kiru1);
		//wait explicitly
				//we want to create object in explicitly statement
				WebDriverWait wait=new WebDriverWait(driver,1000);
				
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='signIn']")));
		
		
		driver.findElement(By.name("signIn")).click();
		driver.findElement(By.id("gbg4")).click();
		driver.findElement(By.id("gb_71")).click();
		
	     }

	}


