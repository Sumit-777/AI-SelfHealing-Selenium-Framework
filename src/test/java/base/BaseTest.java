package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	@BeforeMethod
	public void setup() throws Exception {
		String url=ConfigReader.readConfig("url");
		driver=DriverFactory.initDriver();
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Browser Successfully launched with: "+url);
		
	}
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
