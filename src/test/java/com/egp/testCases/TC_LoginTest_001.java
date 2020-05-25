package com.egp.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.egp.pageObject.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	
	
	@Test 
	public void loginTest() throws InterruptedException, IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		
		Thread.sleep(7000);
		lp.setUserName(AdminUsername);
		logger .info("Entered UserName");
		
		lp.setPassword(AdminPassword);
		logger .info("Entered Password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Home - Group Enrollment")) {
			
			Assert.assertTrue(true);
			logger .info("Login Test Passes");
		
		} else {
			
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger .info("Login Test Failed");
			
		}
		
	} 	
	
}
