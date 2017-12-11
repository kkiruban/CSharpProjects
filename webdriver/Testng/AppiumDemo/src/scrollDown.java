import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class scrollDown extends Sample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
        AndroidDriver<AndroidElement> driver=Capabilities();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("new uiscrollable(new uiselector()).scrollintoview(text(\"WebView\"))");

	}

}
