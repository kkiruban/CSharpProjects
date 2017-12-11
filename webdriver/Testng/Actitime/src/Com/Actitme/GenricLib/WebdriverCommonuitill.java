package Com.Actitme.GenricLib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverCommonuitill {

	
	public static boolean flag=false;
	public void waitForPageToLoad(int miliseconds){
	
		Driver.driver.manage().timeouts().implicitlyWait(miliseconds, TimeUnit.SECONDS);
   	}
	public boolean verifytextpresent(String expectedtext){
		String actualtext=Driver.driver.getPageSource();
		if(actualtext.contains(expectedtext)){
			flag=true;
		}
		return flag;
	}
      public boolean getandverifytext(String elementxpath,String expectedtext){
		try{
			String actualtext=Driver.driver.findElement(By.xpath(elementxpath)).getText();
			if(actualtext.equals(expectedtext)){
				System.out.println(expectedtext+"is present in ui");
				flag=true;
			}
		}
			catch(Throwable e){
				System.out.println(expectedtext+"is not present in ui");
				
			}
			return flag;
	   }
      public  String[] getrowdata(String rowxpath){
    	  String rowdata[]=null;
    	  try{
    		  String entirerowdata=Driver.driver.findElement(By.xpath(rowxpath)).getText();
    		  rowdata = entirerowdata.split("");
    	  }
    	  catch(Throwable e){
    		  System.out.println("row data not found");
    	  }
		return rowdata;
    	  
      }
      public String[] clickandgetrowdata(String rowxpath,String clickableelement) throws InterruptedException{
    	  String rowdata[]=null;
    	  while(true){
    		  try{
    			  String entirerowdata=Driver.driver.findElement(By.xpath(rowxpath)).getText();
    			  rowdata=entirerowdata.split(" ");
    			  break;
    		  }catch(Throwable e){
    			  Driver.driver.findElement(By.xpath(clickableelement)).click();
    			  Thread.sleep(5000);
    		  }
    	  }
		return rowdata;
      }
      
      public void waitforlinkelement(String weblink){
    	  WebDriverWait wait=new WebDriverWait(Driver.driver, 10);
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText(weblink)));
      }
      public void waitforidelement(String elementid){
    	  WebDriverWait wait=new WebDriverWait(Driver.driver, 10);
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText(elementid)));
      }
      public void waitforxpathelement(String elementxpath){
    	  WebDriverWait wait=new WebDriverWait(Driver.driver, 10);
    	  wait.until(ExpectedConditions.elementToBeClickable(By.linkText(elementxpath)));
      }
      public HashMap<String, String> getwindowid(){
    	  Set<String> set=Driver.driver.getWindowHandles();
    	  HashMap<String, String> windowid=new HashMap<String,String>();
    	  Iterator<String> it=set.iterator();
    	  windowid.put("parentid", it.next());
    	  windowid.put("childid", it.next());
    	  return windowid;
      }
      public String acceptalert(){
    	  Alert alt= Driver.driver.switchTo().alert();
    	  alt.accept();
    	  return alt.getText();
      }
}

