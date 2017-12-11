package Middle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Run1 {

	
	public static void main(String[] args) throws InterruptedException {

      WebDriver driver = new FirefoxDriver();
      driver.get("http://my.monsterindia.com/create_account.html?spl=G_NewCampaign&WT.Srch=1&WT.mc_n=olm_sk_google_paid");
      Thread.sleep(5000);
      WebElement wb =driver.findElement(By.linkText("Career Services"));
      Thread.sleep(5000);
      Actions a=new Actions(driver);
      a.moveToElement(wb).perform();
      driver.findElement(By.linkText("- Career Booster")).click();
      
   	  }

}
