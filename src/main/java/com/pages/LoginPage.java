package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private WebDriver driver;

	// 1. By Locator or Object Repository
	private By emailid = By.id("email");
	private By password = By.id("passwd");
	private By loginbutton = By.id("SubmitLogin");
	
	//@FindBy 
	@FindBy(xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotpasswordlink;

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. Page Action
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExist() throws InterruptedException {
		Thread thread = new Thread();
		thread.wait(1000);
		return forgotpasswordlink.isDisplayed();
 }

	public void enterUsername(String username) {
		driver.findElement(emailid).sendKeys(username);
		
	}
	public void enterPassward(String pwd) {
		driver.findElement(password).sendKeys(pwd);
		
	}
	public void clickOnLogin() {
		driver.findElement(loginbutton).click();
		
	}
	public AccountPage doLogin(String un,String pwd) {
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
		return new AccountPage(driver); 

	}
	
}
