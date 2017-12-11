package testcase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariRun1 {

	public static void main(String[] args) {
		
		WebDriver driver = new SafariDriver();
		driver.get("http://kiruba-vaio/login.do");
		System.out.println("done");
		

	}

}
