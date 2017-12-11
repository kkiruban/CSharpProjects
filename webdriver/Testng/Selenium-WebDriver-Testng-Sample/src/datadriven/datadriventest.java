package datadriven;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class datadriventest {
  
//	@Test(dataProvider = "dp")
//  public void f(Integer n, String username, String password ) {
//		
//		WebDriver driver = new FirefoxDriver();
//		driver.get("https://test.salesforce.com/");
//		driver.findElement(By.name("username")).sendKeys(username);
//		driver.findElement(By.name("pw")).sendKeys(password);
//		driver.findElement(By.name("Login")).click();
//	    driver.quit();
//  }
//
//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "username","123" },
//      new Object[] { 2, "password" ,"123"},
//    };
//  }
  
  @Test
  @Parameters({"kiruba"})
  
  public void f(String Userid) {
	  System.out.println(Userid);
  }
}
