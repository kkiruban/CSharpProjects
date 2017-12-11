package NewThinga;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlDrive {

	
	public static void main(String[] args) {
		
		WebDriver driver= new HtmlUnitDriver();
		
		driver.get("http://www.google.co.in/");
		System.out.println("finished");
	}

}
