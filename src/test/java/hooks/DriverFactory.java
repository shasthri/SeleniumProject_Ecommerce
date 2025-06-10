package hooks;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.PicoTestContainer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class DriverFactory {
	
	private WebDriver driver;
	
	public DriverFactory(PicoTestContainer pico)
	{
		driver = pico.getBrowserfactory().launchBrowser();
	}
	
	@After(value = "@Smoke")
	public void afterEachScenario1() 
	{
		driver.quit();
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "FailedScreen");
		}
	}
}