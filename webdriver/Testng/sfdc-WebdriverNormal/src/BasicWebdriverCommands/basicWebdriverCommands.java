package BasicWebdriverCommands;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class basicWebdriverCommands {

	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		// to launch a firefox browser
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		driver = new ChromeDriver();

		// naviagte to salesforce url
		driver.get("https://test.salesforce.com/");

		// implicit wait method
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// selenium command to maximize the browser
		driver.manage().window().maximize();

		// to pass username in text box
		driver.findElement(By.id("username")).sendKeys("dsintegration-admin@servicesource.com.sitnxtqlik");

		// to pass username in text box
		driver.findElement(By.id("password")).sendKeys("srevds123!");

		// to perform click action on login button
		driver.findElement(By.name("Login")).click();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void createaccount() {

		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@title='Accounts Tab']")).click();
		// get title
		 String actualtitle=driver.getTitle();
		 String expectedtitle="Accounts: Home ~ Salesforce - Performance Edition";

		 if(actualtitle.equalsIgnoreCase(expectedtitle)){
			 System.out.println("title has expected");
		 }else{
			 System.out.println("title has not expected");
		 }
			 
		 
		// explict wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new")));

		driver.findElement(By.name("new")).click();
		Random rand = new Random();

		int randint = rand.nextInt(1000);

		String randomaccount = "smoke-test-account-" + String.valueOf(randint);

		driver.findElement(By.id("acc2")).sendKeys(randomaccount);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='acc3_lkwgt']/img")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// handling frames and windows

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();

		driver.switchTo().window(childwindow);

		driver.switchTo().frame("searchFrame");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lksrch")));
		driver.findElement(By.xpath(".//*[@id='lksrch']")).sendKeys("smoke-test");
		driver.findElement(By.name("go")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.linkText("smoke-test-account-123")).click();
		// driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().window(parentwindow);
		driver.findElement(By.id("acc5")).sendKeys("112");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("save")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void createContact() {
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@title='Contacts Tab']")).click();
		
		// get title
		String actualtitle=driver.getTitle();
		String expectedtitle="Contacts: Home ~ Salesforce - Performance Edition";

		 Assert.assertEquals(actualtitle, expectedtitle);
		 
		// explict wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new")));

		driver.findElement(By.name("new")).click();
		Random rand = new Random();
		int randint = rand.nextInt(1000);
		String randomcontact = "smoke-test-contact-" + String.valueOf(randint);

		driver.findElement(By.id("name_lastcon2")).sendKeys(randomcontact);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='con4_lkwgt']/img")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// handling frames and windows
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();

		driver.switchTo().window(childwindow);
		driver.switchTo().frame("searchFrame");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lksrch")));
		driver.findElement(By.xpath(".//*[@id='lksrch']")).sendKeys("smoke-test");
		driver.findElement(By.name("go")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.linkText("smoke-test-account-123")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().window(parentwindow);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("save")).click();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}