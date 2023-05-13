package StepDefination;

import java.io.IOException;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.WebDriver;

import com.pages.AccountPage;
import com.pages.ContactUsPage;
import com.qa.Utils.ExcelReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ContactUsPageSteps {
	private DriverFactory driverfactory;
	private WebDriver driver;
	private AccountPage accountPage;
	private ContactUsPage contactUsPage;
	
	
	@Given("User Navigate to the contact us Page")
	public void user_navigate_to_the_contact_us_page() {
		contactUsPage=accountPage.ClickOnContactUs();
		
	}
	@When("User fill the form from given sheetname {string} and rowNum {int}")
	public void user_fill_the_form_from_given_sheetname_and_row_num(String sheetname, Integer rowNumber) throws InvalidFormatException, IOException {
	 ExcelReader excelReader =new ExcelReader();
	    java.util.List<Map<String, String>> testdata = excelReader.getData("src\\test\\resources\\data.xlsx", sheetname);
	    String heading= testdata.get(rowNumber).get("Subject Heading");
	    String  email=testdata.get(rowNumber).get("Email");
	    String ord=testdata.get(rowNumber).get("OrderRef");
	    String messages=testdata.get(rowNumber).get("Message");
	  contactUsPage.fillContactUsForm(heading, email, ord, messages);

	}

	@When("User click on Send button")
	public void user_click_on_send_button() {
		contactUsPage.clickOnSendButton();
	}

	@Then("SucessMessage should be genrate as {string}")
	public void sucess_message_should_be_genrate_as(String expSuccessMsg) {
		String actuScccessMsg=contactUsPage.getSuccesMessageText();
		Assert.assertEquals(expSuccessMsg, actuScccessMsg);
	}



}
