package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utilities.ConfigReader;

public class DriverFactory {
	static WebDriver driver;

	public static WebDriver initDriver() throws Exception {
		String browsername = ConfigReader.readConfig("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new Exception("No supported browser found");
		}
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
	}

}
