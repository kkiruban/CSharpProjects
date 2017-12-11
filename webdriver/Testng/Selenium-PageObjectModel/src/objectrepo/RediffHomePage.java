package objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
	
	
    WebDriver driver;
	
	public RediffHomePage(WebDriver driver){
		
		this.driver=driver;
	}
	
	By search= By.id("srchinputcopy");
	
	
	public WebElement  SearchBox(){
		return driver.findElement(search);
	}

}
