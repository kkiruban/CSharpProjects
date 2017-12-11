package com.SFDCsample.tests.SDFCSample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SampleTest {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void launchingbrowser() {
		// set property and path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		// create a browser instance
		driver = new ChromeDriver();
		// navigate to url
		driver.get(
				"https://whatfix.com/quickolabs.com/#!flows/how-to-import-google-analytics-solution-of-whatfix/8174f470-9df9-11e3-8178-386077c653fe/");
		// command to window maximize
		driver.manage().window().maximize();
	}

	@Test
	public void test01() throws InterruptedException {
		// explicit wait
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Self Help']")));

		// to click on link text
		driver.findElement(By.xpath("//a[text()='Self Help']")).click();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		// switching and handling frames
		WebElement parentframe = driver.findElement(By.xpath("//iframe[@class='WFEMES WFEMBT WFEMFV WFEMDV WFEMJM WFEMCT']"));
		driver.switchTo().frame(parentframe);
		// to click on link text by xpath locator
		driver.findElement(By.xpath("//a[text()='How to embed flows in my website or application?']")).click();
		// switching back from that frame
		driver.switchTo().defaultContent();
		// noraml wait
		Thread.sleep(10000);
		// click on embed link
		driver.findElement(By.xpath("//a[@class='WFMAAB WFMACFB WFMAOK']")).click();
		// click on slideshow
		driver.findElement(By.linkText("slideshow")).click();
		Thread.sleep(1000);
		// command to handle alert
		// driver.switchTo().alert();
		// click on next button
		// driver.findElement(By.xpath("//span[contains(text(),
		// 'Next')]")).click();
		// driver.switchTo().defaultContent();

		// click on close link
		driver.findElement(By.xpath("//a[text()='close']")).click();

	}

	@AfterMethod
	public void closebrowser() {
		// command to close the browser
		driver.close();
	}

}
