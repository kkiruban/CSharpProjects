package testcase1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


	public class FileUpload {
	  @Test
	  public void f() throws InterruptedException {
		  WebDriver driver=new FirefoxDriver();
		  driver.get("http://cgi-lib.berkeley.edu/ex/fup.html");
		  Thread.sleep(3000);
		  String s1="E:\\resume\\Kiruba_Resume_4years.doc";
		  WebElement wbb =  driver.findElement(By.name("upfile"));
	     wbb.sendKeys(s1);	  
		  
		  
	  }
	}
