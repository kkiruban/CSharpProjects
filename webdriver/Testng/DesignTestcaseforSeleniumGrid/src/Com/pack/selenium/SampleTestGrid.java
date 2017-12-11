package Com.pack.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestGrid {
	WebDriver driver;
	String baseurl,nodeurl;
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  baseurl="http://www.hdfcbank.com/";
	  nodeurl="http://192.168.0.105:5566/wd/hub";
	 // nodeurl="http://127.0.0.1:7055/wd/hub";
	  DesiredCapabilities capability=DesiredCapabilities.firefox();
	  capability.setBrowserName("firefox");
	  capability.setPlatform(Platform.VISTA);
	  driver=new RemoteWebDriver(new URL(nodeurl),capability);
	 Thread.sleep(5000);
	  driver.get("http://www.hdfcbank.com/");
	  Assert.assertEquals("HDFC BANK", driver.getTitle());
	  driver.quit();
	  
			  
	  
	  
  }
}
