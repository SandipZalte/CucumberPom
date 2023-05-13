package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

	private By subheading_selectbox = By.xpath("//select[@id='id_contact']");
	private By email = By.id("email");
	private By orderref = By.xpath("//select[@name='id_order'and@class='form-control']");
	private By sendbutt = By.id("submitMessage");
	private By message = By.id("message");
	private By successMessage=By.xpath("//div[@id='center_column']//p[text()]");
	private WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnSendButton() {
		driver.findElement(sendbutt).click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
	public String getSuccesMessageText() {
		return driver.findElement(successMessage).getText();
	}

	
	public void fillContactUsForm(String heading ,String Email_Id,String order,String msg ) {

		Select select=new Select(driver.findElement(subheading_selectbox));
		select.deselectByVisibleText(heading);
		driver.findElement(email).sendKeys(Email_Id);
		driver.findElement(orderref).sendKeys(order);
		driver.findElement(message).sendKeys(msg);
	}
	public void ClickOnSend() {
		driver.findElement(sendbutt).click();
		

	}

}
