package com.egp.testCases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.egp.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	// Admin Login Details 
	public String AdminURL = readconfig.getApplicationURL();
	public String AdminUsername = readconfig.getAdminUserName();
	public String AdminPassword = readconfig.getAdminPassword();
	
	// HR login Details 
	public String HRLoginURL = "https://1dgrouptest.info/login";
	public String HRUsername = "sandeep.12august@gmail.com";
	public String HRPassword = "Alveo@123";
	
	// Broker Login Details
	public String BrokerLoginURL = "https://1dgrouptest.info/login";
	public String BrokerUsername = "sandeep01";
	public String BrokerPassword = "Alveo@123";
	
	//WebSite URL
	public String RetailWebURL = "https://subagent.1dgrouptest.info";
	public String GroupWebURL = "https://testetsf.1dgrouptest.info";
	
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		 logger = Logger.getLogger("EGP 1Dental");
		 PropertyConfigurator.configure("log4j.properties");
		    
		if(br.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			System.setProperty("webDriver.gecko.driver", readconfig.getfirefox());
			driver = new FirefoxDriver();
		}
		if(br.equals("ie")) {
			System.setProperty("WebDriver.ie.driver", readconfig.getIEbrowser());
			driver = new InternetExplorerDriver();
		}
	   
			driver.get(AdminURL);
			logger .info("URL is opened");
	} 
	
	
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
	

}
