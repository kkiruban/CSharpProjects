package AvaticsTestcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avatics.businesslib.Avatics1;
import com.avatics.genericlib.Driver;
import com.avatics.genericlib.ExcelLib;
import com.avatics.genericlib.WebdriverCommonuitill;
import com.avatics.pagefactory.AllReviewPage;
import com.avatics.pagefactory.AvaticsCommElementPgFact;
import com.avatics.pagefactory.CustomerGrouppage;
import com.avatics.pagefactory.Customerpage;
import com.avatics.pagefactory.ExportCustomerpage;
import com.avatics.pagefactory.OrdersPageFactory;
import com.avatics.pagefactory.Reviewinformationpage;
import com.avatics.pagefactory.Reviewpage;

public class Testcase1 {
	
	public Avatics1 a1=new Avatics1();
	public ExcelLib elib=new ExcelLib();
	public WebdriverCommonuitill wLib=new WebdriverCommonuitill();
	public OrdersPageFactory opagef=PageFactory.initElements(Driver.driver, OrdersPageFactory.class);
	public AvaticsCommElementPgFact commPagef=PageFactory.initElements(Driver.driver, AvaticsCommElementPgFact.class);
    public Customerpage custpage=PageFactory.initElements(Driver.driver,Customerpage.class);
    public CustomerGrouppage custgrouppage=PageFactory.initElements(Driver.driver, CustomerGrouppage.class);
    public  Reviewpage reviewpage=PageFactory.initElements(Driver.driver, Reviewpage.class);
    public Reviewinformationpage informationpage=PageFactory.initElements(Driver.driver, Reviewinformationpage.class);
    public AllReviewPage allreviewpage=PageFactory.initElements(Driver.driver, AllReviewPage.class);
    public ExportCustomerpage exportpage=PageFactory.initElements(Driver.driver, ExportCustomerpage.class);
    @BeforeMethod
    public void com() throws InvalidFormatException, IOException{
    	a1.lunchBrowser("http://localhost/Avactis/avactis-system/admin/signin.php");
    	//a1.lunchBrowser("http://localhost/Avactis/avactis-system/admin/signin.php");
  	  String username=elib.getExeceldata("sheet1",1, 2);
  	  String password=elib.getExeceldata("sheet1",1, 3);
  	  a1.loginToApp(username, password);
  	  wLib.waitForPageToLoad(5000);
    }

    
    @Test
    public void test1()  {
	  
	  commPagef.getOrdersLnk().click();
	  System.out.println("execution starts");
	  String expectedtext="Orders";
	  String actualtext=opagef.getOrdersText().getText();
      //String actualtext=Driver.driver.findElement(By.xpath("//td[text()='Orders']")).getText();
	 System.out.println(actualtext);
	 wLib.waitForPageToLoad(5000);
	boolean result=wLib.getandverifytext("//td[text()='Orders']", expectedtext);
    System.out.println(result);
//	  if(result==true){
//		  System.out.println("Orders page is present.");
//	  }else{
//		  System.out.println("Orders page is not present.");
//	  }
  wLib.waitForPageToLoad(5000);
	  
	  
	  
  }
  @Test
  public void test2() {
	  
	  custpage.getCustomerlnk().click();
 }
  @Test
  public void test3() {
	  
  custpage.getCustomerlnk().click();
	  custpage.getUserlnk();
	  custpage.getSelaccountchkbox().click();
	  custpage.getDeletebut().click();
	   Alert alt=Driver.driver.switchTo().alert();
	  alt.dismiss();
	  
 }
  @Test
  public void test4(){
	  
	  custpage.getCustomerlnk().click();
	  custpage.getUserlnk();
	  custpage.getSelaccountchkbox().click();
	  custpage.getActivatebut().click();
	   Alert alt=Driver.driver.switchTo().alert();
	  alt.dismiss();
 }
  
  @Test
  public void test5(){
	  custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
	 String text=custpage.getUserlnk().getText();
	 System.out.println(text);
	  custpage.getSearchedit().sendKeys(text);
	  wLib.waitForPageToLoad(5000);
	  custpage.getSearchbut().click();
	  System.out.println("done");
  }
  
  @Test
  public void test6(){
	  custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
	  String getname=custpage.getGetcutomernametext().getText();
	  //String getname=Driver.driver.findElement(By.xpath("//tbody/tr[5]/td[3]")).getText();
	  System.out.println(getname);
	  custpage.getSearchedit().sendKeys(getname);
	  wLib.waitForPageToLoad(5000);
	  custpage.getSearchbut().click();
	  
	  
  }
  
  @Test
  public void test7(){
	  custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
	  custpage.getCustomergroupbut().click();
	  wLib.waitForPageToLoad(5000);
	  //wLib.getwindowid();
	  //wLib.switchtowindow("childwindow");
	  Set<String> set=Driver.driver.getWindowHandles();
	  Iterator<String> it=set.iterator();
	  String parentwindow=it.next();
	  String childwindow=it.next();
	  System.out.println(childwindow);
	  Driver.driver.switchTo().window(childwindow);
	  custgrouppage.getClickclosebut().click();
	  Driver.driver.switchTo().window(parentwindow);
  }
  
  @Test
  public void test8(){
	  custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
	  custpage.getSelaccountchkbox().click();
	  custpage.getResetpassbut().click();
	  Alert alt=Driver.driver.switchTo().alert();
	  alt.accept();
  }
  @Test
  public void test9() throws InterruptedException{
	  custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
	  custpage.getSelaccountchkbox().click();
	  custpage.getExportbut().click();
	  wLib.switchtochildwindow();
	  exportpage.getAttributechkbox().click();
	  exportpage.getAccountchkbox().click();
	  exportpage.getStartbut().click();
	  Thread.sleep(10000);
	  exportpage.getDownloadbut().click();
	  //exportpage.getCancelbut().click();
	  //Driver.driver.switchTo().window(parentwindow);
	  wLib.switchtoparentwindow();
   }
  @Test
  public void test10(){
	   custpage.getCustomerlnk().click();
	  wLib.waitForPageToLoad(5000);
      WebElement wb=custpage.getFilterbydropdown();
    Select s=new Select(wb);
      s.selectByIndex(1);
      
	  
  }
  
  @AfterMethod
  public void common(){
  	commPagef.getSignOutLnk().click();
  }
  @Test
  public void test11(){
	reviewpage.getReviewslink().click();
	reviewpage.getPenreviewslink().click();
	
  }
  @Test
  public void test12(){
	  reviewpage.getReviewslink().click();
	  reviewpage.getBadreviewslink().click();
  }
  @Test
  public void test13(){
	  reviewpage.getReviewslink().click();
	  reviewpage.getGoodreviewslink().click();
  }
  @Test
  public void test14(){
	  reviewpage.getReviewslink().click();
	  wLib.waitForPageToLoad(5000);
	  reviewpage.getAllreviewslink().click();
	  allreviewpage.getEditboxbut().click();
	  wLib.switchtochildwindow();
	  informationpage.getReviewinformationpage().sendKeys("i love india");
      informationpage.getSavebut().click();
      wLib.switchtoparentwindow();
	 }
  
}

