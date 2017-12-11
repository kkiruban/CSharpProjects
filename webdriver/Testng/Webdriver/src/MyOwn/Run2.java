package MyOwn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Run2 {


	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String gettext=driver.findElement(By.xpath("//h1")).getText();
		System.out.println("gettext="+gettext);
		
		String attributevalue=driver.findElement(By.xpath("//h1")).getAttribute("class");
		System.out.println("attributevalue="+attributevalue);		

	}

}
