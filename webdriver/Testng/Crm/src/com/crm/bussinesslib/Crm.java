package com.crm.bussinesslib;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.crm.genriclib.Driver;
import com.crm.genriclib.ExcelLib;
import com.crm.genriclib.WebdriverCommonuitill;
import com.crm.pagefactory.Login;
import com.crm.pagefactory.Logout;
import com.crm.pagefactory.Marketing;

public class Crm {
	public WebdriverCommonuitill wecomlib=new WebdriverCommonuitill();
	public Login login=PageFactory.initElements(Driver.driver,Login.class);
	public ExcelLib excellib=new ExcelLib();
	public Marketing movetomarketing=PageFactory.initElements(Driver.driver, Marketing.class);
	public Logout logout=PageFactory.initElements(Driver.driver, Logout.class);
	 
	
	public void logintocrm() throws InvalidFormatException, IOException{
		String username=excellib.getExeceldata("sheet1", 2, 2);
		String password=excellib.getExeceldata("sheet1", 2, 3);
		
		Driver.driver.get("http://localhost:8888/");
		login.getUsernameedit().sendKeys(username);
		login.getPasswordedit().sendKeys(password);
		login.getSigninbtn().click();
   
	}
	public void campaignsinmarketing(){
		    WebElement wb=movetomarketing.getMarketinglink();
		    Actions alt=new Actions(Driver.driver);
		    alt.moveToElement(wb).perform();
		    wecomlib.waitForPageToLoad(5000);
		    movetomarketing.getCampaignslink().click();
		    
		
	}
	public void logoutfromapp(){
		logout.getLogoutlink().click();
	}
	
	

}
