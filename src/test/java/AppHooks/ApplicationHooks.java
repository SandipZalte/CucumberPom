package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.configReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private configReader configReader;
	Properties prop;
	 String screenshotName;
	
	
	@Before(order =0)
	public void getProperty() {
		configReader= new configReader();
		prop=configReader.init_prop();

	}
	@Before(order=1)
	public void LaunchBrowser() {
		String browserName=prop.getProperty("browser");
		DriverFactory driverFactory= new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		
	}
	@After(order=0)
	public void quitBrowser() {
	driver.quit();
	}

	@After(order=1)
	public void teardown(Scenario scenario) {
	
		if(scenario.isFailed()) {
			//take Screnshot:
			
		 screenshotName = scenario.getName().replaceAll(" ", "_");
		 byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		 scenario.attach(sourcePath, "image/png", screenshotName);
		
		}
	}
 
}
