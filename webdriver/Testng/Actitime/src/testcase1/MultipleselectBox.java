package testcase1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class MultipleselectBox {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://kiruba-vaio/login.do");
	  driver.findElement(By.name("username")).sendKeys("admin");
	  driver.findElement(By.name("pwd")).sendKeys("manager");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  Thread.sleep(3000);
	  String s1=driver.getTitle();
	  System.out.println(s1);
	  driver.findElement(By.linkText("Projects & Customers")).click();
	  String s2= driver.getTitle();
	  System.out.println(s2);
	  String s3=driver.getCurrentUrl();
	  System.out.println(s3);
	  String wb1=driver.getPageSource();
	  //System.out.println(wb1);
	  // dyanamic select box
	  WebElement wb=driver.findElement(By.name("selectedCustomer"));
	  Select sel= new Select(wb);
	  List<WebElement> lst=sel.getOptions();
	  System.out.println(lst.size());
	  String expectedvalue="kasi";
	  Boolean flag=false;
	  
	  for(int i=0;i<lst.size()-1;i++){
		  String Actualvalue=lst.get(i).getText();
		  System.out.println(Actualvalue);
		  if(expectedvalue.equals(Actualvalue)){
			  sel.selectByVisibleText(Actualvalue);
			  flag=true;
			  break;
		  }
	  }
	  if(flag){
		  System.out.println("given value is present");
	  }else
	  {
		  System.out.println("given value is not present");
	  }
	  
  }
}
