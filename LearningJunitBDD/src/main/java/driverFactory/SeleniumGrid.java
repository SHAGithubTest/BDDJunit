package driverFactory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {
	
	
	public static void main(String a[]) throws MalformedURLException {
		WebDriver driver;
		String hub = "http://192.168.43.175:4444/wd/hub";
		String Node = "http://10.112.66.52:5555/wd/hub";

		// DesiredCapabilities cap = DesiredCapabilities.chrome();

		//System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		ChromeOptions option = new ChromeOptions();
		option.merge(cap);

		driver = new RemoteWebDriver(new URL(hub), option);

		driver.navigate().to("https://www.google.com");
		driver.manage().window().maximize();
		driver.close();
		
		
	 }

		
}
		
		
		
		
		
		
		
		
		
		
		
		

