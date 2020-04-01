package com.Emerge.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.Emerge.util.WebListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebListener webListener ;
	public static ExtentReports extent;
    public static ExtentTest logger;
	
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Emerge\\src\\com\\Emerge\\config\\config.properties");
	    prop.load(fis);
	}
	
	
	public void initialization() {
		 System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
		    e_driver = new EventFiringWebDriver(driver);
		    webListener = new WebListener();
		    e_driver.register(webListener);
		    driver = e_driver ;
		    driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  
		
	}

}
