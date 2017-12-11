package BasicWebdriverCommands;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakingScreenShot {
  
	@Test
  public void f() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Ruby22-x64\\bin\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		  driver.get("https://test.salesforce.com/");
		
		//take screenshot and strore as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("D:/screenshot/error.png"));
		Thread.sleep(5000);
		driver.quit();
		
		
  }


}
