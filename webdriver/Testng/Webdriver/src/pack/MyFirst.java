package pack;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;



 class MyFirst {

	public static void main(String[] args){
		
		WebDriver d=new FirefoxDriver();
		
		d.get("http://kiruba-vaio/login.do");
		
		WebElement wb=d.findElement(By.name("username"));
		wb.sendKeys("admin");
		WebElement wb1=d.findElement(By.name("pwd"));
				wb1.sendKeys("manager");
		WebElement wb2=d.findElement(By.xpath("//input[@type='submit']"));
		wb2.click();
		
	}

}
