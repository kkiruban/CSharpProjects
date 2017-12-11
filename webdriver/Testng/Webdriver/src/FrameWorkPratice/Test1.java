package FrameWorkPratice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test1 {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		FileInputStream f=new FileInputStream("C:\\Users\\kiruba\\Desktop\\kiruba1.xlsx");
		Workbook wb= WorkbookFactory.create(f);
		Sheet s=wb.getSheet("sheet1");
		Row r=s.getRow(1);
		System.out.println(s.getLastRowNum());
		String username=r.getCell(2).getStringCellValue();
		String password=r.getCell(3).getStringCellValue();
		System.out.println("username="+username);
		System.out.println("password="+password);
		WebDriver driver= new FirefoxDriver();
		driver.get("http://kiruba-vaio/login.do");
		driver.findElement(By.name("username")).sendKeys(username);
	     driver.findElement(By.name("pwd")).sendKeys(password);
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//img[@alt='Logout']")).click();

	}

}
