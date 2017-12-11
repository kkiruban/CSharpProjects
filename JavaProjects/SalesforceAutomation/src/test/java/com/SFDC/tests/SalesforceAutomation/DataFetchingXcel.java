package com.SFDC.tests.SalesforceAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.Test;

public class DataFetchingXcel {

	
	@Test
	public void test1() throws IOException{
		FileInputStream fis = new FileInputStream(new File("Test-Data.xls"));
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		String s = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(s);
		
	 Cell c =	sheet.getRow(0).createCell(1);
	 c.setCellType(HSSFCell.CELL_TYPE_STRING);
	 c.setCellValue("pass");
		
	}
}
