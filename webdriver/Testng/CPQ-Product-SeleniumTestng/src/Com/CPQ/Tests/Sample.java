package Com.CPQ.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Com.CPQ.Tests.ListenerTest.class)

public class Sample {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
  @BeforeMethod
  public void launchingbrowser(){
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
	  driver =new ChromeDriver();
	  driver.get("https://responsecpq.positiveedge.net/login.aspx");
	//implicit wait
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //to maximize window
	  driver.manage().window().maximize();
	  System.out.println("successfully launched browser");
  }
  
	
	
	@Test(dataProvider="loginusercredentials")
  public void logintest(String username,String password) throws InterruptedException {
	  	  	  
	  //explicit wait
	  wait = new WebDriverWait(driver, 60);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("md-input-0")));
	  
	  driver.findElement(By.id("md-input-0")).sendKeys(username);
	  driver.findElement(By.id("md-input-1")).sendKeys(password);
	  Thread.sleep(20000);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(20000);
	  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  
	  String expected =driver.getTitle();
	  System.out.println(expected);
	  String actual ="ResponseCPQ";	  
	  
	  Assert.assertEquals(actual, expected);		  
  }
	
	
	@DataProvider(name="loginusercredentials")
	public Object[][] getdata(){
//	return new Object[][]	{
//		{ "test1", "test2" },
//        { "test2", "test2" },
//        { "salesonemanager@positiveedgedemo01.onmicrosoft.com", "pass@word1" }
//	   };
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="kirubanand";
		data[0][1]="ramasamy";
		data[1][0]="kirutest";
		data[1][1]="ramatest";
		data[2][0]="salesonemanager@positiveedgedemo01.onmicrosoft.com";
		data[2][1]="pass@word1";
		return data;
	}
	
	@AfterMethod
	  public void quitbrowser(){
		driver.quit();
		System.out.println("close the browser");
	  }
}
