package BasicWebdriverCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class HandleSSLCertification {
 
	private WebDriver driver;
	
	@Test
  public void tohandlesslcerfication() {
		//to handle ssl certificate in firefox browser
		FirefoxProfile profile=new FirefoxProfile();
		
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		driver=new FirefoxDriver(profile);
		driver.get("https://test.salesforce.com/");
		
		//to handle untrusted certificate in chrome
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		driver=new ChromeDriver(cap);		
  }
}
