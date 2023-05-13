package Parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

/**
 * this for Using TestNg we can run Mulptple tread at a time using the this we
 * can perform the parallel testing
 * 
 * @author Admin
 *
 */
//@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Parallel" },
glue = { "Parallel" },
plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }

)

public class TestNg_ParallelTestingTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();

	}

}
