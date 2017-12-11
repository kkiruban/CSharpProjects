package MyOwn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Run8 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://timesofindia.indiatimes.com/");
		Thread.sleep(3000);
		List<WebElement> l=driver.findElements(By.tagName("iframe"));
		System.out.println("size"+l.size());
		System.out.println("list of frame");
		for(int i=0;i<=l.size()-1;i++){
			System.out.println(l.get(i).getAttribute("id"));
			driver.switchTo().frame("mailroifrm12");
			driver.findElement(By.id("mathuserans2")).sendKeys("9");
			//driver.findElement(By.xpath("//div[@class='homesprite vot']")).click();
		}
		
	}

}
//*[@id='mathuserans2']
