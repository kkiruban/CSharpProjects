package Pratice;



import java.util.List;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class DyanamicWebtable {
	
	
	

	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		String actualcustomername=null;	
	 WebDriver driver=new FirefoxDriver();
	 driver.get("http://kiruba-vaio/login.do");
	 driver.findElement(By.name("username")).sendKeys("admin");
	 driver.findElement(By.name("pwd")).sendKeys("manager");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.linkText("Projects & Customers")).click();
	 Thread.sleep(5000);
	 String expectedcustomername="sridhar1";
	 List<WebElement> lst=driver.findElements(By.xpath("//tr[th[contains(text(),'Customer / Project')]]/following-sibling::tr/td[1]/a"));
	 System.out.println(lst.size());
	 for(int i=0;i<lst.size();i++){
		 actualcustomername=lst.get(i).getText();
		//Assert.assertEquals(expectedcustomername,actualcustomername,"pass");
		 //System.out.println();
		 System.out.println(actualcustomername);
		 
	 }
	 //driver.findElements(By.xpath("//tr[th[contains(text(),' Customer / Project')]]/following-sibling::tr/td[1]/a")).getText();
	 //System.out.println("Customername="+actualcustomername);
	 
	 

	}

}
