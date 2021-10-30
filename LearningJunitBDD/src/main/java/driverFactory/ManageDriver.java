package driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageDriver {

	static boolean runLocal = true;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static ThreadLocal<RemoteWebDriver> tlDriverRemDriver = new ThreadLocal<>();

	public WebDriver initDriver(String browserName) {
		System.out.println("Browser Name:::::" + browserName);

		if (runLocal) {

			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new FirefoxDriver());

			}

		}

		else {

			String hubVM = "http://192.168.43.175:4444/wd/hub";

			String hubLocalHost = "http://192.168.29.1:4444/wd/hub";
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			ChromeOptions option = new ChromeOptions();
			option.merge(cap);

			// ----- BrowseStack configuration ----

			final String AUTOMATE_USERNAME = "anandshrivastava_morcW0";
			final String AUTOMATE_ACCESS_KEY = "eph6uQ2WpyEzTGD82j2L";
			final String hubBS = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
					+ "@hub-cloud.browserstack.com/wd/hub";
			DesiredCapabilities capsBS = new DesiredCapabilities();
			capsBS.setCapability("browser_version", "93");
			capsBS.setCapability("os", "Windows");
			capsBS.setCapability("os_version", "10");

			System.out.println("Browser Name:::::" + browserName);
			if (browserName.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				try {
					tlDriverRemDriver.set(new RemoteWebDriver(new URL(hubLocalHost), option));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				// WebDriverManager.chromedriver().setup();
				// tlDriver.set(new FirefoxDriver());

			}

		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static WebDriver getDriver() {

		if (runLocal) 
		{
			return tlDriver.get();
		} else 
		{
			return tlDriverRemDriver.get();
		}

	}

}
