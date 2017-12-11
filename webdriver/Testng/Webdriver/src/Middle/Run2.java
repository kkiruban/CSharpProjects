package Middle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Run2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://my.monsterindia.com/create_account.html?spl=G_NewCampaign&WT.Srch=1&WT.mc_n=olm_sk_google_paid");
		
		Thread.sleep(1000);
		
	WebElement wb=	driver.findElement(By.linkText("Career Center"));
		
		Actions a=new Actions(driver);
		Thread.sleep(1000);
		a.contextClick(wb).sendKeys(Keys.ARROW_UP,Keys.ARROW_UP,Keys.ARROW_UP).click().perform();
		//a.moveToElement(wb).perform();
		//driver.get("http://content.monsterindia.com/interview_center.html");
	}

}
