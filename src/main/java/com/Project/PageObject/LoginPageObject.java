package com.Project.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObject {
	
	@FindBy(how = How.XPATH, using = "//a[@id='signin2']" )WebElement signup ;
	
	@FindBy(how = How.XPATH, using = "//input[@id='sign-username']") WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@id='sign-password']") WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary' and text()='Sign up']") WebElement signupbtn;
	
	@FindBy(how = How.XPATH, using = "//a[@id = 'login2']") WebElement login;

	@FindBy(how = How.XPATH, using = "//input[@id='loginusername']") WebElement login_username;
	
	@FindBy(how = How.XPATH, using = "//input[@id='loginpassword']") WebElement login_password;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary' and text()='Log in']") WebElement loginbtn;
	
	public void signup(String uname,String pwd)
	{
		signup.click();
		username.sendKeys(uname);
		password.sendKeys(pwd);
		signupbtn.click();		
	}
	
	public void login(String uname,String pwd)
	{
		login.click();
		login_username.sendKeys(uname);
		login_password.sendKeys(pwd);
		loginbtn.click();
	}
	

}
