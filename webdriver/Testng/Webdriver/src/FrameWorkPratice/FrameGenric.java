package FrameWorkPratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FrameGenric {

	public String getexceldata(String sheetname,int rownum,int cellnum) throws InvalidFormatException, IOException{
		FileInputStream f=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet s=wb.getSheet(sheetname);
		Row r=s.getRow(rownum);
		String c=r.getCell(cellnum).getStringCellValue();
		
		return c;
	}
	public int getrowcount(String sheetname) throws InvalidFormatException, IOException{
		FileInputStream f=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet s=wb.getSheet(sheetname);
		int rowcount=s.getLastRowNum();
		return rowcount;
		
	}
	public void setrowdata(String sheetname,int rownum,int cellnum,String data) throws InvalidFormatException, IOException{
		FileInputStream f=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb=WorkbookFactory.create(f);
		Sheet s=wb.getSheet(sheetname);
		Row r=s.getRow(rownum);
		Cell c= r.getCell(cellnum);
		c.setCellType(c.CELL_TYPE_STRING);
		c.setCellValue(data);
		FileOutputStream fo= new FileOutputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		wb.write(fo);
		
		
	}

}
