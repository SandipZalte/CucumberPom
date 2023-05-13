package com.qa.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	Properties prop= new Properties();
	
	/*
	 * This Method return is used to init the threadLocal driver and on th basis of given browser
	 */

	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser value is:"+ browser);
		
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("edge")) {
			tlDriver.set(new EdgeDriver());
		} else {
			System.out.println("Please Pass the Correct Browser value :- "+ browser);
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/**
	 * this is used to get the driver with thread local
	 * @return
	 * its return the current thread drive instant
	 */ 
	public static synchronized WebDriver getDriver() {		// public static synchronized webdriver getDriver(){
		return tlDriver.get();
		
		
		
		
	}

}
