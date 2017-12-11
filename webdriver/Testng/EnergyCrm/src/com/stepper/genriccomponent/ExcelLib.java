package com.stepper.genriccomponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public String getExeceldata(String sheetname,int rownum,int cellnum) throws InvalidFormatException, IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook  wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row r=sh.getRow(rownum);
		String data=r.getCell(cellnum).getStringCellValue();
		return data;
  	}

	public int getRowcount(String sheetname) throws InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		return  rowcount;
	}
	public void setRowdata(String sheetname,int rownum,int cellnum,String data) throws InvalidFormatException, IOException{
		FileInputStream fis=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		Row r=sh.getRow(cellnum);
		Cell c=r.getCell(cellnum);
		c.setCellType(c.CELL_TYPE_STRING);
		c.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		wb.write(fos);
	}
}
