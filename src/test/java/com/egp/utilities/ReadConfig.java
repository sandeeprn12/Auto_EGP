package com.egp.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
			String url = pro.getProperty("AdminURL");
			return url;
	}
	
	public String getAdminUserName() {
		String AdminUsername = pro.getProperty("AdminUsername");
		return AdminUsername; 
	}
	public String getAdminPassword() {
		String APassword = pro.getProperty("AdminPassword");
		return APassword;
    }
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
    }
	public String getIEbrowser() {
		String iepath = pro.getProperty("iepath");
		return iepath;
	}
	
	public String getfirefox() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath; 
    }
	
	

}
 