package com.stepper.businesscomponent;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.security.auth.login.LoginContext;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.stepper.genriccomponent.Driver;
import com.stepper.genriccomponent.ExcelLib;
import com.stepper.genriccomponent.WebdriverCommonuitill;
import com.stepper.pagefactory.Campaign;
import com.stepper.pagefactory.CreateCampaign;
import com.stepper.pagefactory.Login;
import com.stepper.pagefactory.Logout;
import com.stepper.pagefactory.Marketing;
import com.stepper.pagefactory.Project;

public class StepperReuse {
	  public Login plogin=PageFactory.initElements(Driver.driver, Login.class);
	  public ExcelLib exlib=new ExcelLib();
	  public Marketing marklink=PageFactory.initElements(Driver.driver, Marketing.class);
	  public Logout logout=PageFactory.initElements(Driver.driver, Logout.class);
	  public Campaign camp1=PageFactory.initElements(Driver.driver, Campaign.class);
	  public CreateCampaign createcustomer=PageFactory.initElements(Driver.driver, CreateCampaign.class);
	  public Project product1=PageFactory.initElements(Driver.driver, Project.class);
	  public WebdriverCommonuitill wdriverutil=new WebdriverCommonuitill();
	  
	 public void logintoapp(String username,String password) throws InvalidFormatException, IOException{
		   Driver.driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		    
		   plogin.getUsertxtedit().sendKeys(username);
		   plogin.getPasstxtedit().sendKeys(password);
		   plogin.getLoginbtn().click(); 
	 }
	 public void marketing(){
		 WebElement wmark=marklink.getMarketinglinktxt();
		 Actions act=new Actions(Driver.driver);
		 act.moveToElement(wmark).build().perform();
		 
	 }
	 public void campain(){
		 WebElement wmark=marklink.getMarketinglinktxt();
		 Actions act1=new Actions(Driver.driver);
		 act1.moveToElement(wmark).build().perform();
		 marklink.getCampainlinktxt().click();
	 }
	 public void createcampaign(String campaginname) throws InterruptedException{
		 camp1.getCreatecampaignimglink().click();
		 createcustomer.getCampaignnametxtbox().sendKeys(campaginname);
		 createcustomer.getAssigntyperadiobtn().click();
		 WebElement wbsel1=createcustomer.getCampaigntypeselbox();
		 Select sel=new Select(wbsel1);
		  sel.selectByIndex(4);
		  Thread.sleep(4000);
		  createcustomer.getProductselimglink().click();
	      Set<String> set=Driver.driver.getWindowHandles();
		  Iterator<String> it1=set.iterator();
		  String parentwindow=it1.next();
		  String childwindow=it1.next();
		  Driver.driver.switchTo().window(childwindow);
		  Driver.driver.manage().window().maximize();
      	  product1.getProjectnameintablelink().click();
          Driver.driver.switchTo().window(parentwindow);
		 
	 }
	 public void logout(){
		logout.getLogoutlinktxt().click();
	 }

}
