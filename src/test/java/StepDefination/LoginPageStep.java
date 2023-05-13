package StepDefination;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStep {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("^User is on login Page$")
	public void userIsOnLoginPage() {
		DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
	}

	@When("Title of the page should be {string}")
	public void userGetsTheTitleOfThePage(String title)  {
		 title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is : " + title);
	}

	/*
	 * in Then Always write Assertion in @Then
	 */

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("Forgot password link should display")
	public void forgot_password_link_should_display() throws InterruptedException {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
		
	}

	@When("User enter the username {string}")
	public void user_enter_the_username(String username) {
		loginPage.enterUsername(username);
	}

	@When("User enter the password {string}")
	public void user_enter_the_password(String passward) {
		loginPage.enterPassward(passward);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {
		loginPage.clickOnLogin();
	}
	
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		 title = loginPage.getLoginPageTitle();
		System.out.println("Login Page title is : " + title);
		
	}





		


}
