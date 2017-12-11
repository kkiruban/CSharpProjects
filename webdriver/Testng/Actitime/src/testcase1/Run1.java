package testcase1;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Com.Actitime.BussinessLib.Actitime;
import Com.Actitime.pagefactory.CommonElement;
import Com.Actitime.pagefactory.Login;
import Com.Actitme.GenricLib.Driver;
import Com.Actitme.GenricLib.ExcelLib;
import Com.Actitme.GenricLib.WebdriverCommonuitill;

public class Run1 {
	public String username;
	public String password;
	 public Login login;
	 public WebdriverCommonuitill wLib=new WebdriverCommonuitill();
	 public Actitime act=new Actitime();
 public	CommonElement commElement=PageFactory.initElements(Driver.driver,CommonElement.class);
  @Test
  public void kiru1() throws InvalidFormatException, IOException, Exception {
	  login=PageFactory.initElements(Driver.driver, Login.class);
	  
	  
	  ExcelLib exlib=new ExcelLib();
	  int s=exlib.getRowcount("sheet1");
	  System.out.println(s);
	  
	  
	  for(int  i=1;i<=s;i++){
		   username= exlib.getExeceldata("sheet1", i, 2);
		   password= exlib.getExeceldata("sheet1", i, 3);
		  act.logintoapp(username,password);
		  wLib.waitForPageToLoad(5000);
		   act.logoutFromApp();
		   
		   
		   
			 }
//	  com.getLogoutbtn().click();
		  
	  
	 
	 
	// Driver.driver.get("http://kiruba-vaio/login.do");	 
//      login.getUsernameedit().sendKeys(UserName);
//      login.getPasswordedit().sendKeys();
//      login.getLoginbtn().click();
//      Thread.sleep(5000);
      
	  }
   @Test
   public void ssl(){
	  
	   act.sslcerficateerror();
   }
}
