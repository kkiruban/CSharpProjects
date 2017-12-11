package com.avactis.ReportLib;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.avatics.genericlib.Driver;
import org.apache.commons.io.FileUtils;

public class ScreenShot {
	public void scrrenshot(String desPath ) throws IOException{
EventFiringWebDriver efwDriver=new EventFiringWebDriver(Driver.driver);
	
File srcPath=efwDriver.getScreenshotAs(OutputType.FILE);
File desPath1=new File(desPath);
FileUtils.copyFileToDirectory(srcPath, desPath1);
	}
}
