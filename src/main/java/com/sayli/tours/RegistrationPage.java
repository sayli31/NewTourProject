package com.sayli.tours;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	

	@FindBy(xpath ="//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")
	WebElement fName;
	
	@FindBy(xpath ="//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")
	WebElement lName;
	
	@FindBy(xpath ="//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")
	WebElement address;
	
	
	@FindBy(xpath ="//*[@id=\"eid\"]/input")
	WebElement emailAdd;
	
	
	@FindBy(xpath ="//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")
	WebElement mbNum;
	
	
	
	@FindBy(id="firstpassword")
	WebElement password;
	

	@FindBy(id="secondpassword")
	WebElement sendPass;
	
	@FindBy(id="submitbtn")
	WebElement submitBtn;
	
	
	public void fillData(String fname1,String lname1,String addr, String email, String mobile,String pass,String confPass) throws InterruptedException
	{
		fName.clear();
		lName.clear();
		address.clear();
		emailAdd.clear();
		mbNum.clear();
		password.clear();
		sendPass.clear();
		
		
		fName.sendKeys(fname1);
		Thread.sleep(1000);
		lName.sendKeys(lname1);
		Thread.sleep(1000);
		address.sendKeys(addr);
		Thread.sleep(1000);
		emailAdd.sendKeys(email);
		Thread.sleep(1000);
		mbNum.sendKeys(mobile);
		Thread.sleep(1000);
		password.sendKeys(pass);
		Thread.sleep(1000);
		sendPass.sendKeys(confPass);
		Thread.sleep(1000);
		submitBtn.click();
		
	}
}
