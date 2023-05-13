package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	private WebDriver driver;

	// By LocatorOr @FindBy Annotaion
	private By headertaboption=By.xpath("//header//nav//div[@class]"); 
	
	private By accounSection = By.cssSelector("div[id='center_column'] span");
	private By addMyFirstAddress = By.partialLinkText("Add my first address");
	private By orderHistoryAndDetails = By.partialLinkText("ORDER HISTORY AND DETAILS");
	private By myCreditSlip = By.partialLinkText("MY CREDIT SLIPS");
	private By myAddress = By.partialLinkText("MY ADDRESSES");
	private By personalinformation = By.partialLinkText("MY PERSONAL INFORMATION");
private By contactus=By.xpath("//div[@id='contact-link']");
	/**
	 * Constrctor
	 * 
	 * @param driver
	 */
	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * user action And Method
	 * 
	 * @return
	 */
	public int getAccounSectionCount() {

		return driver.findElements(accounSection).size();

	}

	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accountHeaderList = driver.findElements(accounSection);

		for (WebElement e : accountHeaderList) {
			String text = e.getText();

			accountList.add(text);
		}
		return accountList;
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}

	public AddMyFirstAddressPage clickAndGetAddMyFirstAddress() {
		driver.findElement(addMyFirstAddress).click();
		return new AddMyFirstAddressPage(driver);

	}

	public OrderHistoryAndDetailsPage clickAndGetOrderHistoryAndDetials() {
		driver.findElement(orderHistoryAndDetails).click();
		return new OrderHistoryAndDetailsPage(driver);

	}

	public MyCreditSlipPage clcikAndGetMyCreditSlip() {
		driver.findElement(myCreditSlip).click();
		return new MyCreditSlipPage(driver);
	}

	public MyAddressPage clickAndGetMyAddress() {
		driver.findElement(myAddress).click();
		return new MyAddressPage(driver);
	}

	public MyPersonalInformationPage clickAndGetMyPersonalInformation() {
		driver.findElement(personalinformation).click();
		return new MyPersonalInformationPage(driver);

	}
	public ContactUsPage ClickOnContactUs() {
		driver.findElement(contactus).click();
		return new ContactUsPage(driver);
		
	}

}
