package com.pages;

import org.openqa.selenium.WebDriver;

public class AddMyFirstAddressPage {
	private WebDriver driver;

	/*
	 * user drifin constructor
	 */
	public AddMyFirstAddressPage(WebDriver driver) {
		this.driver=driver;
			
	}

	//By Locator

	
	//action or method
	
	public String getAddressPageTitle() {
		return driver.getTitle();
	}
	
	 
}
