package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySec {

	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		System.out.println(driver.getTitle());
	       driver.close();
		
	}
}
