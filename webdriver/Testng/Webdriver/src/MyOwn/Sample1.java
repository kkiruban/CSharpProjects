package MyOwn;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample1 {

	
	public static void main(String[] args) throws InterruptedException {
	   
		WebDriver driver=new FirefoxDriver();
		driver.get("http://timesofindia.indiatimes.com/");
		Thread.sleep(5000);
		List<WebElement> l=driver.findElements(By.tagName("iframe"));
		System.out.println("size="+l.size());
		System.out.println("list of frame id");
		for(int i=0;i<=l.size()-1;i++){
			System.out.println(""+l.get(i).getAttribute("id"));
		}
		driver.switchTo().frame("iplfls");
		driver.findElement(By.xpath("//a[@title='Recent']")).click();
		driver.findElement(By.xpath("//a[@style='text-decoration:none;color: #FFFFFF;padding:5px;font-weight:bold;font-size:11px']")).click();
       // driver.findElement(By.linkText("FULL SCORECARD")).click();
		//		Set<String> s=driver.getWindowHandles();
//		Iterator<String> it=s.iterator();
//		String parentwindow=it.next();
//		String childwindow=it.next();
//		driver.switchTo().window(childwindow);
		
		

	}

}
