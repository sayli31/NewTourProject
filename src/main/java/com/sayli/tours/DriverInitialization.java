package com.sayli.tours;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverInitialization {
	
	
	
	
	

	public static final String System_Proprty_chrome = "E:\\SELENIUM\\78\\chromedriver_win32\\chromedriver.exe";
	public static final String url = "http://demo.automationtesting.in/Register.html";
	public static WebDriver driver = null;

	public static WebDriver InitializeDriver() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System_Proprty_chrome);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		return driver;

	}

	public static void main(String[] args) throws InterruptedException, IOException
	{
	
		driver= InitializeDriver();
		System.out.println(driver.getPageSource());
	
		
		
		
		
		
		
		////////////
		
		//excelSheet();
		
		
	}
	
	
	
	

	private static void excelSheet() throws IOException {


		File tempFile = new File("E:\\NewExcelFile.xlsx");
		boolean exists = tempFile.exists();
		System.out.println(exists);
		 File temp;
		 String filename;
		 
		if (exists == false)
		{
			temp = File.createTempFile("NewExcelFile", ".xlsx");
			System.out.println("Temp file exists : " + temp.exists());
			filename = "E:\\NewExcelFile.xlsx";
			createData(filename);

		} else {
			
			filename = "E:\\NewExcelFile.xlsx";

			FileInputStream fis = new FileInputStream("E:\\NewExcelFile.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> Itr = sheet.iterator();
			while (Itr.hasNext()) {
				Row row = Itr.next();
				Iterator<Cell> cell1 = row.iterator();
				
				while (cell1.hasNext()) 
				{

					 Cell  cell = cell1.next();
					 System.out.println(cell.getStringCellValue());
					 
				}
				System.out.println("\n");
			}
		}
		
	}

	private static void createData(String filename) throws IOException {

	     
        
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("FirstSheet");  

	         XSSFRow rowhead = sheet.createRow((short)0);
	         rowhead.createCell(0).setCellValue("No.");
	         rowhead.createCell(1).setCellValue("Name");
	         rowhead.createCell(2).setCellValue("Address");
	         rowhead.createCell(3).setCellValue("Email");

	         XSSFRow row = sheet.createRow((short)1);
	         row.createCell(0).setCellValue("1");
	         row.createCell(1).setCellValue("Sayli");
	         row.createCell(2).setCellValue("India");
	         row.createCell(3).setCellValue("sayliK@gmail.com");

	         FileOutputStream fileOut = new FileOutputStream(filename);
	         workbook.write(fileOut);
	         fileOut.close();
	         System.out.println("Your excel file has been generated!");
	         
	}

	
	
	
}
