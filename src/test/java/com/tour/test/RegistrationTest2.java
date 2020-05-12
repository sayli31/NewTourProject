package com.tour.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sayli.tours.DriverInitialization;
import com.sayli.tours.RegistrationPage;

public class RegistrationTest2 {
	
	static WebDriver driver = null;

	@Test	
	public void registrationTest() throws InterruptedException, IOException
	{
		

		driver = DriverInitialization.InitializeDriver();
		RegistrationPage regObj = PageFactory.initElements(driver, RegistrationPage.class);
		

        methodCall(regObj);
		
		
		

		
		Thread.sleep(2000);
		driver.close();
		
	}
	
	
	
	public void methodCall(RegistrationPage regObj) throws IOException, InterruptedException{

		String filename = "E:\\NewExcelFile.xlsx";

//		 List<WebElement> gender = driver.findElements(By.xpath("//div//input[@type=\"radio\"]"));
//		 System.out.println("Gender : "+gender.get(0).getAttribute("value"));



		FileInputStream fis = new FileInputStream("E:\\NewExcelFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		 Row header = sheet.getRow(0);        
		 int count = header.getLastCellNum();
       
         
        String fname = header.getCell(0).getStringCellValue();
        String lname = header.getCell(1).getStringCellValue();
        String adrss = header.getCell(2).getStringCellValue();
        String email = header.getCell(3).getStringCellValue();
        String mbNo = header.getCell(4).getStringCellValue();
        String pass = header.getCell(5).getStringCellValue();
        String confPass = header.getCell(6).getStringCellValue();
      
        if (fname.equals("FirstName") || lname.equals("LastNamee") ||  adrss.equals("Address") ||  email.equals("Email") || mbNo.equals("MobileNo") ||  pass.equals("Password") || confPass.equals("ConformPass")  ) 
        {
	            for(int i = 1;i<count-2;i++) 
	            {

	            	Row data = sheet.getRow(i);            	
	            						
	            	long l = (long) data.getCell(4).getNumericCellValue();
					String mbStr = Long.toString(l);
	            	
	        		regObj.fillData(data.getCell(0).getStringCellValue(), 
	        				data.getCell(1).getStringCellValue(),
	        				data.getCell(2).getStringCellValue(),
	        				data.getCell(3).getStringCellValue(), 
	        				mbStr, 
	        				data.getCell(5).getStringCellValue(), 
	        				data.getCell(6).getStringCellValue()); 
	        		Thread.sleep(4000);
	            }
	          }

        
        
	}
	
}






	













