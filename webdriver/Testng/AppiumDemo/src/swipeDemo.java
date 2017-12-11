import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class swipeDemo extends Sample {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		
AndroidDriver<AndroidElement> driver=Capabilities();
       
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@content-desc='9']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction t=new TouchAction(driver);
		t.press(driver.findElementByXPath("//*[@content-desc='15']")).waitAction(2000).moveTo(driver.findElementByXPath("//*[@content-desc='45']")).release().perform();

	}

}
