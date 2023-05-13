package StepDefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
	@Given("User is already logged in the application")
	public void user_is_already_logged_in_the_application(DataTable dataTable) {
		List<Map<String,String>>credlist=dataTable.asMaps();
		String un=credlist.get(0).get("username");
		String pwd=credlist.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.pl/index.php?controller=authentication&back=my-account");
		accountPage=loginPage.doLogin(un, pwd);
	}

	@Given("User is on account page")
	public void user_is_on_account_page() {
		accountPage.getAccountPageTitle();
	}

	@Then("User get the account section List")
	public void user_get_the_account_section_list(DataTable sectTable) {
		List<String> expSectList = sectTable .asList();
		System.out.println("Expected Account Section List--> "+expSectList);
		
		List<String>actuSectList=accountPage.getAccountSectionList();
		System.out.println("Actual Account Section List--> "+actuSectList);
		
		Assert.assertTrue(actuSectList.containsAll(expSectList));
		
		
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectcount) {
		int actualsectcount=accountPage.getAccounSectionCount();
		Assert.assertTrue(actualsectcount==expectedSectcount);
	}
	
}
