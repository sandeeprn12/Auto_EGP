package com.egp.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath ="//input[@placeholder='Username']")
	WebElement txtUserName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPswd;
	
	
	@FindBy(className = "loginbtn")
	WebElement btnLogin;
	
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		txtPswd.sendKeys(pswd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	
	
	
	
	
	
}
