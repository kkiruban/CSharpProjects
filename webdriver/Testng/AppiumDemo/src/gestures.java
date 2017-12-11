import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class gestures extends Sample {

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
		
AndroidDriver<AndroidElement> driver=Capabilities();

       
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
//		driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
//		
//		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
		
		TouchAction t= new TouchAction(driver);
		
		t.tap(driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")")).perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")").click();
//		t.tap(driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")")).perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		t.press(driver.findElement(By.xpath("//android.widget.TextView[@index='0']"))).waitAction(3000).release().perform();
//		Sample action
//		driver.findElementByAndroidUIAutomator("text(\"Sample action\")").click();
//		driver.findElementByAndroidUIAutomator("text(\"People Names\")").click();
//		t.longPress(driver.findElementByAndroidUIAutomator("text(\"People Names\")")).
//		t.longPress(driver.findElementByAndroidUIAutomator("text(\"People Names\")"), 3000).release().perform();
//		t.press(driver.findElementByAndroidUIAutomator("text(\"People Names\")")).waitAction(5000).release().perform();
//		t.press(driver.findElement(By.xpath("//android.widget.TextView[@index='0']"))).waitAction(5000).release().perform();
//		t.longPress(driver.findElement(By.xpath("//android.widget.TextView[@index='0']")), 3000).release().perform();
//		System.out.println(driver.findElementById("android:id/title").getText());
	}

}
