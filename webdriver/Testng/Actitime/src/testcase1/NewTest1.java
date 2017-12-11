package testcase1;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Actitme.GenricLib.ExcelLib;

  public class NewTest1 {
	WebDriver driver;
	ExcelLib elib=new ExcelLib();
	@BeforeMethod
	public void driver1(){
		driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
	}
	@AfterMethod
	public void logout() throws InterruptedException{
		Thread.sleep(2000);
		driver.close();
		//driver.findElement(By.xpath("//img[@alt='Logout']")).click();
	}
	
	@Test(dataProvider="getdata")
	  public void f(String cust,String pass) throws InterruptedException {
		// System.out.println("username:"+cust+"password:"+ pass);
		driver.findElement(By.name("username")).sendKeys(cust);
		driver.findElement(By.name("pwd")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='Logout']")).click();
	  }
	@DataProvider
	public Object[][] getdata() throws InvalidFormatException, IOException{
		int row=elib.getRowcount("sheet1");
		Object[][] data=new Object[row][2];
		 for(int i=0;i<row;i++){
			data[i][0]=elib.getExeceldata("sheet1", i+1, 2);
			data[i][1]=elib.getExeceldata("sheet1", i+1, 3);
		}
		return data;
	}
  
 }
