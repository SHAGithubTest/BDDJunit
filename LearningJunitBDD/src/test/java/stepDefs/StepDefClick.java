package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import webActions.ActionClick;

public class StepDefClick {
	
	WebDriver driver;
	
	@When("user clicks on {string}")
	public void user_clicks_on(String arg1) throws Throwable {
	    Assert.assertTrue(ActionClick.click(arg1));
	}

}
