package com.avatics.businesslib;

import org.openqa.selenium.support.PageFactory;

import com.avatics.genericlib.Driver;
import com.avatics.genericlib.ExcelLib;
import com.avatics.pagefactory.AvaticsCommElementPgFact;
import com.avatics.pagefactory.adminLoginPageFactory;

public class Avatics1 {
	
	public void lunchBrowser(String url){
		Driver.driver.get(url);
	}
	
	public  ExcelLib elib=new ExcelLib();
	public adminLoginPageFactory aPgfact=PageFactory.initElements(Driver.driver, adminLoginPageFactory.class);
	public AvaticsCommElementPgFact acommele=PageFactory.initElements(Driver.driver, AvaticsCommElementPgFact.class);
	public void loginToApp(String username,String password){
		aPgfact.getUsernameEdt().sendKeys(username);
		aPgfact.getPasswordEdt().sendKeys(password);
		aPgfact.getSignINBtn().click();
		
	}
	
	public void logoutFromApp(){
		acommele.getSignOutLnk().click();
	}

}
