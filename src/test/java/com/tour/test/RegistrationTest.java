package com.tour.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RegistrationTest {
	
	static WebDriver driver = null;

	@Test	
	public void registrationTest() throws InterruptedException, IOException
	{
		

		/*driver = DriverInitialization.InitializeDriver();
		RegistrationPage regObj = PageFactory.initElements(driver, RegistrationPage.class);
		

		
		
		
		HashMap<String, String> data = excelSheet();
			
		regObj.fillData(data.get("fname"), data.get("lname"), data.get("Address"), data.get("Email"), data.get("mobileNo"), data.get("Pass"), data.get("ConfPass"));
		
		
		Thread.sleep(2000);
		driver.close();
*/
		

		
	}
	
	
	

	






	private static HashMap<String, String> excelSheet() throws IOException {


		String filename = "E:\\NewExcelFile.xlsx";

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
         
        HashMap<String,String> hm=new HashMap<String,String>(); 
        String[] array = new String[count];
        if (fname.equals("FirstName") || lname.equals("LastNamee") ||  adrss.equals("Address") ||  email.equals("Email") || mbNo.equals("MobileNo") ||  pass.equals("Password") || confPass.equals("ConformPass")  ) 
            {
        		array = usingArray(count,sheet);
        	}
    	    
       
           
            
        	


        
		return null;
	
		
	

        }











	private static String[] usingArray(int count,XSSFSheet sheet) {
		  
		
	
		
		
	      String[] dataArray = new String[count];
	       	 for(int i = 1;i<count-2;i++) 
	             {

	             	Row data = sheet.getRow(i); 
	             	
	          
	             	
	             	
	             	dataArray[i]= data.getCell(0).getStringCellValue();
	             	
	             	dataArray[i+1]= data.getCell(1).getStringCellValue();
	             
	             	
//	             	dataArray[i]= data.getCell(2).getStringCellValue();
//	             	dataArray[i]= data.getCell(3).getStringCellValue();
//	             	//dataArray[5]= data.getCell(4).getStringCellValue();
	             	
	             	System.out.println(dataArray[i]);
	             	System.out.println(dataArray[i+1]);
	             }
	        	 
	        		
	        
	        return dataArray;
	     	
		
	}


	private static void usingmap(int count,XSSFSheet sheet) {

		 HashMap<String,String> hm=new HashMap<String,String>(); 
	            for(int i = 1;i<count-2;i++) 
	            {

	            	Row data = sheet.getRow(i);            	
	            	                 
					hm.put("fname", data.getCell(0).getStringCellValue());
					hm.put("lname", data.getCell(1).getStringCellValue());
					hm.put("Address", data.getCell(2).getStringCellValue());
					hm.put("Email", data.getCell(3).getStringCellValue());
					long l = (long) data.getCell(4).getNumericCellValue();
					String mbStr = Long.toString(l);
					hm.put("mobileNo", mbStr);
					hm.put("Pass", data.getCell(5).getStringCellValue());
					hm.put("ConfPass", data.getCell(6).getStringCellValue());

					System.out.println(hm);
					
	               break;           	
	            	
	            }
	          }
	
	
	
	

}
