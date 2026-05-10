package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SelfHealingDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// ============================Locators============================================

	private By userNameInput = By.id("username");

	private By passwordInput = By.id("password");

	private By submitBtn = By.id("submit");

	private By loginValidationMsg = By.xpath("//h1[@class='post-title']");

	// ===============================Global Variables=================================

	String loginValidationMsgText = "Logged In Successfully";

	// ================================================================================

	public boolean doLogin(String userName, String password) {

		boolean b = false;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			SelfHealingDriver.findElement(driver, userNameInput).sendKeys(userName);

			SelfHealingDriver.findElement(driver, passwordInput).sendKeys(password);

			SelfHealingDriver.findElement(driver, submitBtn).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(loginValidationMsg));

			String msg = SelfHealingDriver.findElement(driver, loginValidationMsg).getText();

			if (msg.equals(loginValidationMsgText)) {

				b = true;
			}

		} catch (Exception e) {

			b = false;

			e.printStackTrace();
		}

		return b;
	}
}