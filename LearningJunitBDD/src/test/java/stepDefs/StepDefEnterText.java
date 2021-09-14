package stepDefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import webActions.ActionClick;
import webActions.ActionEnterText;

public class StepDefEnterText {
	
	
	@And("user enters {string} into {string}")
	public void user_enters_into(String textValue, String locator) throws Throwable {
	  
	    Assert.assertTrue(ActionEnterText.enterText(textValue, locator));

	}

}
