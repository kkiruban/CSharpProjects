package MyOwn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Run4 {

	
	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com/");
	List<WebElement>l=driver.findElements(By.xpath("//a"));
	String expectedstring="terms";
	boolean flag=false;
	System.out.println(l.size());
	
	for(int i=0;i<l.size()-1;i++){
		String actualstring=l.get(i).getText();
		System.out.println(actualstring);
		if(expectedstring.equalsIgnoreCase(actualstring)){
	     System.out.println("expected link is present");
	     flag=true;
	     break;
		}
	}
//	List<WebElement>l1=driver.findElements(By.xpath("//input"));
//	for(int i=0;i<l.size();i++){
//		//System.out.println("input-"+l1.get(i).getText());
//	}
//	System.out.println(l1.size());
	  }
	}

