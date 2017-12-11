package com.SFDC.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.SFDC.tests.SalesforceAutomation.sdfc;

public class createcontactpage extends sdfc {



	public createcontactpage(WebDriver driver){
		
		this.driver=driver;
		
	}
	
	@FindBy(xpath=".//*[@id='Contact_Tab']/a")
	private WebElement contacttab;
	
	@FindBy(xpath="//input[@title='New']")
	private WebElement newbutton;
	
	@FindBy(id="name_lastcon2")
	private WebElement lastnametextbox;
	
	@FindBy(id="con4")
	private WebElement accountnametextbox;
	
	@FindBy(xpath="//*[@id='con4_lkwgt']/img")
	private WebElement lookupfield;

	@FindBy(xpath="//*[@id='topButtonRow']/input[@title='Save']")
	private WebElement savebutton;
	
	@FindBy(id="lksrch")
	private WebElement searchbox;

	@FindBy(xpath="//input[@title='Go!']")
	private WebElement gobutton;

	
	public boolean createcontact(String contactname,String accountname) throws InterruptedException{
		contacttab.click();
		newbutton.click();
		lastnametextbox.sendKeys(contactname);
		lookupfield.click();
		
		Set<String> set=driver.getWindowHandles();
		Iterator<String> I1= set.iterator();
		String parentwindow=I1.next();
		String childwindow=I1.next();
		driver.switchTo().window(childwindow);
		driver.switchTo().frame("searchFrame");
		Thread.sleep(20000);
		searchbox.sendKeys("smoke-test-account-");
		Thread.sleep(20000);
		gobutton.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.linkText("smoke-test-account-121")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentwindow);
		savebutton.click();
		Thread.sleep(20000);
		return true;
	}
	
}
