package objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {
	
	
	WebDriver driver;
	
	public RediffLoginPagePF(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//*[@id='login1']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement password;
	
	@FindBy(name="proceed")
	WebElement go;
	
	@FindBy(linkText="Home")
	WebElement home;
	
	public WebElement EmailId(){
		return username;
	}
	
	public WebElement Password(){
		return password;
	}
	
	public WebElement Go(){
		return go;
	}
	
	public WebElement HomeLink(){
		return home;
	}
}
