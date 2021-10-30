package driverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.net.URL;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserStack {
	public static final String AUTOMATE_USERNAME = "anandshrivastava_morcW0";
	public static final String AUTOMATE_ACCESS_KEY = "eph6uQ2WpyEzTGD82j2L";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser_version", "latest");
		caps.setCapability("os", "Windows"); 
		caps.setCapability("os_version", "10");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();
	}
}