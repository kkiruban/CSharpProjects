import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomator extends Sample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
//        driver.findElementByAndroidUIAutomator("attribute("value"))"		

		//validate 	clickable feature for all options
//		driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		
//		touch Actions in appium
		
		
		
		
		
	}

}
