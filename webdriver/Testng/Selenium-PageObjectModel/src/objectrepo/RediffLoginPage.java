package objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {
	
	
	WebDriver driver;
	
	public RediffLoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	By username= By.xpath("//*[@id='login1']");
	By password= By.xpath(".//*[@id='password']");
	By go= By.name("proceed");
	By home= By.linkText("Home");
	
	public WebElement EmailId(){
		return driver.findElement(username);
	}
	
	public WebElement Password(){
		return driver.findElement(password);
	}
	
	public WebElement Go(){
		return driver.findElement(go);
	}
	
	public WebElement HomeLink(){
		return driver.findElement(home);
	}
}
