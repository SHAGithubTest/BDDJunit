package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import webActions.ActionBrowserOperation;
import webActions.ActionClick;

public class StepDefBrowser {
	
	WebDriver driver;
	
	
	@Given("user launches {string}")
	public void user_launches_chrome(String browserNname) throws Throwable {
		Assert.assertTrue(ActionBrowserOperation.launchBrowser(browserNname));
	}
	
	@Given("user navigate to url {string}")
	public void user_navigate_to_url(String url) {
	 Assert.assertTrue(ActionBrowserOperation.navigateToUrl(url));    
	}


}
