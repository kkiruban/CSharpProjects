package testcase1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import bsh.Capabilities;

public class abc {

	
	public static void main(String[] args) {
		
//		FirefoxProfile profile=new FirefoxProfile();
//		profile.setPreference("browser.download.folderList", 0 );
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
//		WebDriver driver=new FirefoxDriver(profile);
//		driver.get("http://docs.seleniumhq.org/download/");
//		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);
//		
//		driver.findElement(By.xpath("//a[@href='http://selenium.googlecode.com/files/selenium-java-2.33.0.zip']")).click();
//		
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderlist", 0);
		profile.setPreference("browser.helperapps.neverask.savetodisk", "application/zip");
		WebDriver driver=new FirefoxDriver(profile);
		driver.get("http://selenium.googlecode.com/files/selenium-java-2.33.0.zip");
		//to get the current url 
		driver.getCurrentUrl();
		//to get the title
		driver.getTitle();
		//to delete all cookies
		driver.manage().deleteAllCookies();
		///to refresh the page
		driver.navigate().refresh();
		//to click on forward and backward button
		driver.navigate().forward();
		driver.navigate().back();
		driver.manage().window().maximize();
		DesiredCapabilities cap= DesiredCapabilities.firefox();
		RemoteWebDriver driver1=new RemoteWebDriver(cap);
		Actions act=new Actions(driver);
		act.doubleClick();
	}

}
