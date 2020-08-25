/**
 * 
 */
package com.Project.Utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Munikrishnan
 *
 */
public class BrowserInvokation {

	public static WebDriver driver;
	
	public static String propertyData(String propertyName) throws IOException
	{
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\Project\\Resources\\PathFile.properties";
		FileInputStream fileInputStream = new FileInputStream(path);	
		Properties prop = new Properties();
		prop.load(fileInputStream);
		String data = (String) prop.get(propertyName);
		return data;
	}

		
	public static WebDriver openBrowser(WebDriver driver,String sBrowser) {
		try {
			if (sBrowser.equals("firefoxDriver")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ propertyData(sBrowser));
				DesiredCapabilities dc = new DesiredCapabilities();
				dc.setCapability("marionatte", false);
				FirefoxOptions opt = new FirefoxOptions();
				opt.merge(dc);
				driver =  new FirefoxDriver(opt);
			} else if (sBrowser.equals("chromeDriver")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ propertyData(sBrowser));
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				driver = new ChromeDriver();
			} else if (sBrowser.equals("ieDriver")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ propertyData(sBrowser));
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public static WebDriver navigateToUrl(WebDriver driver, String url) throws IOException
	{
		driver.navigate().to(propertyData(url));
		return driver;
	}

	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}


}
