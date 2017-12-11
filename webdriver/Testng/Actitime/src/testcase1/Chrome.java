package testcase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Chrome {

	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("start");
//		WebDriver driver= new InternetExplorerDriver();
		WebDriver driver1= new ChromeDriver();
		System.out.println("middle");
		Thread.sleep(4000);
		System.out.println("mid");
//		driver.get("http://kiruba-vaio/login.do");
		driver1.get("http://kiruba-vaio/login.do");
		System.out.println("end");


	}

}
