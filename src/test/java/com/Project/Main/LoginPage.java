package com.Project.Main;

import org.testng.annotations.Test;

import com.Project.PageObject.LoginPageObject;
import com.Project.Utility.BrowserInvokation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class LoginPage {

	public static WebDriver driver = null;
	LoginPageObject login = null;

	@BeforeClass
	public void beforeClass() throws IOException {
		driver = BrowserInvokation.openBrowser(driver, "chromeDriver");
		login = new LoginPageObject();
	}

	@BeforeMethod
	public void browser() throws IOException {
		driver = BrowserInvokation.navigateToUrl(driver, "ecommerceUrl");		
	}

	@DataProvider
	public Object[][] data() throws IOException {
		return new Object[][]{
			{"admin","admin"},
			{"demo","demo"},
			{"devqa","devqa"}
				};
	}

	@Test
	public void signUp() {
		PageFactory.initElements(driver, login);
		login.signup("demo","demo");
	}

	@Test(dataProvider = "data")
	public void login(String username, String password) throws IOException {
		PageFactory.initElements(driver, login);
		login.login(username, password);
	}


	@AfterClass
	public void afterClass() {
		BrowserInvokation.closeBrowser(driver);

	}

}
