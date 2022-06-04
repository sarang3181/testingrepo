package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility 
{
	
 public static void capturescreenshot (WebDriver driver, String screenshotName) throws IOException
 {
	 TakesScreenshot ts=(TakesScreenshot)driver;
     
	 File source=ts.getScreenshotAs(OutputType.FILE);
	 
	 Calendar cal=Calendar.getInstance();
	 
	 Date time=cal.getTime();
	 
	 SimpleDateFormat ac=new SimpleDateFormat("dd_MM_YYYY_hh mm ss");
	 
	 String timestamp =ac.format(cal.getTime());
	 
	 File destination =new File("test-output\\Screenshot\\image"+"-"+screenshotName+"-"+timestamp+".png");
	 
	 FileHandler.copy(source, destination);
	 	 
 }
 
 public static String getDataFromExcelsheet(String sheetname,int row,int column) throws IOException
 {
	 
	 String data=null;
	 
	 String path="C:\\Users\\HP\\Desktop\\Flipkart.xlsx";
	 
	 FileInputStream file=new FileInputStream(path);
	 
	 Workbook book = WorkbookFactory.create(file);
	 
	 try
	 {
		 
		 data=book.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		 
	 }
	 
	 catch(IllegalStateException e)
	 {
		 
		 double value = book.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		 data = Double.toString(value);
		 
		 
	 }
	return data;
	 
	 
	 
	 
	 
	 
	 
 }
}


