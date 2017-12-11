package com.crm.genriclib;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import org.apache.commons.io.FileUtils;

public class ScreenShot {
	public void screenshot(String destPath ) throws IOException{
//EventFiringWebDriver efwDriver=new EventFiringWebDriver(Driver.driver);
//	
//File srcPath=efwDriver.getScreenshotAs(OutputType.FILE);
//File desPath1=new File(desPath);
//FileUtils.copyFileToDirectory(srcPath, desPath1);
		EventFiringWebDriver screen=new EventFiringWebDriver(Driver.driver);
		File srcpath=screen.getScreenshotAs(OutputType.FILE);
		File destpath1=new File(destPath);
		FileUtils.copyFileToDirectory(srcpath, destpath1);
	}
}
