package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Sample {
	
	@Given("^I should navigate to google site$")
	public void i_should_navigate_to_google_site() throws Throwable {
	    WebDriver driver = new FirefoxDriver();
	    driver.get("https://www.google.co.in/");
	    Thread.sleep(10);
		
//	    throw new PendingException();
	}


}
