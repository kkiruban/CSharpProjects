package com.crm.testcase;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.bussinesslib.Crm;
import com.crm.genriclib.Driver;
import com.crm.genriclib.ScreenShot;
import com.crm.pagefactory.Login;
import com.crm.pagefactory.Marketing;

public class FristTest {
	public Crm blib=new Crm();
	public ScreenShot pic=new ScreenShot();
	
	
	@BeforeMethod
	public void login() throws InvalidFormatException, IOException{
		blib.logintocrm();
	}
  
  @Test
  public void firsttest() throws IOException   {

	  blib.campaignsinmarketing();
	  pic.screenshot("F:\\selenium\\");
	  
	  
	  
  }
//  @AfterMethod
//  public void logout(){
//	  blib.logoutfromapp();
//  }
 }
