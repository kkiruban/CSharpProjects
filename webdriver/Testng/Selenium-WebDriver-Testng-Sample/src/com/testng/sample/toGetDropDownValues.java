package com.testng.sample;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class toGetDropDownValues {

	public WebDriver driver=null;
	
	@Test
	public void loginsalesforceapp() throws InterruptedException{
		try{
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://test.salesforce.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("dsintegration-admin@servicesource.com.sitnxtelek");
		driver.findElement(By.id("password")).sendKeys("srevds123!");
		driver.findElement(By.id("Login")).click();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Contacts")));
		driver.get("https://cs70.salesforce.com/003/e?retURL=%2F003%2Fo");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("00N4100000UkImR")));
		
		WebElement dropdown = driver.findElement(By.id("00N4100000UkImR"));
		Select sel=new Select(dropdown);
		sel.selectByIndex(1);
		
		java.util.List<WebElement> listofdropdown = sel.getOptions();
		
//		String[] expectedvalue=null;
		java.util.List<String> expectedvalue = new ArrayList();

		  
		for(WebElement ls:listofdropdown){
			  
			expectedvalue.add(ls.getText());
		  }
		System.out.println(expectedvalue);
		
		java.util.List<String> actualvalues = new ArrayList();
		actualvalues.add("--None--");
		actualvalues.add("Account Payable");
		actualvalues.add("Decision Maker");

		System.out.println(actualvalues);
		if(expectedvalue.equals(actualvalues)){
            System.out.println("matching records is visible");			
		}else
		{
			System.out.println("matching records not visible");
		}		
		
		driver.findElement(By.xpath(".//*[@id='con4_lkwgt']/img")).click();
		
		 Set<String> s=driver.getWindowHandles();
		 System.out.println(s.size());
		
		 Iterator<String> it=s.iterator();
		 
		   String parentwindow=it.next();
		   String childwindow=it.next();

		   System.out.println(childwindow);
		
		   driver.switchTo().window(childwindow);
		   System.out.println(driver.getTitle());
		   
		   driver.switchTo().frame("searchFrame");
		   driver.findElement(By.id("lksrch")).sendKeys("smoke");
		   driver.switchTo().defaultContent();
		   driver.switchTo().window(parentwindow);
		   
		}catch (Exception e) {
			e.printStackTrace();
		}		
		 finally {
			driver.quit();
		}

	}	
	
}
