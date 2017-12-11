package testcase1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class NakuriFileload {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver=new FirefoxDriver();
	  driver.get("http://my.naukri.com/manager/createacc2.php?othersrcp=5424&wExp=N&id=26993f348ec94e5d50489d60cfdab585ac0a8beabbcd794bfff78214f9cef3feff003c62a2e1a36431b890266d0ecd01|X|Y|X|E");
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//	  System.out.println("hai");
//	  driver.switchTo().frame("iframe#frmupload");
//	  //iframe#frmupload
//	  
//	  driver.findElement(By.id("browsecv")).click();
	  List<WebElement> lst=driver.findElements(By.tagName("iframe"));
	  for(int i=0;i<=lst.size()-1;i++){
		  System.out.println(lst.get(i).getAttribute("id"));
	  }
	  driver.switchTo().frame("frmUpload");
	  WebElement wb=driver.findElement(By.id("browsecv"));
	  String s1="E:\\resume\\Kiruba_Resume_4years.doc";
	  wb.sendKeys(s1); 
  }
}
