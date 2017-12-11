package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Sample3 {

	
	public static void main(String[] args) {
		
         
		WebDriver driver=new FirefoxDriver();
		
		
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2");
	    //wait implicitly statement
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		//to get the list of links in webpage
		java.util.List<WebElement> weblink=driver.findElements(By.xpath("//a"));
		System.out.println("size="+weblink.size());
		
		String expectedvalue="switch";
		boolean flag=false;
		for(int i=0;i<=weblink.size()-1;i++){
			System.out.println("link present in webpage="+weblink.get(i).getText());
			String w=weblink.get(i).getText();
			if(expectedvalue.equalsIgnoreCase(w)){
				System.out.println(expectedvalue + " is present");
				weblink.get(i).click();
				Actions act=new Actions(driver);
				act.sendKeys(Keys.BACK_SPACE).build().perform();
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 flag=true;
				break;
			}
			
				
			}
		}
		
	}


