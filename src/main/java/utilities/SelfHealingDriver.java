package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelfHealingDriver {

	public static WebElement findElement(WebDriver driver, By locator) {

		WebElement element = null;

		try {

			element = driver.findElement(locator);

		} catch (Exception e) {

			System.out.println("Original locator failed: " + locator);

			try {

				String failedXpath = locator.toString().replace("By.xpath: ", "");

				String outerHTML = driver.findElement(By.tagName("body"))
						.getText();

				String healedXpath = AIEngine.getHealingXpath(failedXpath, outerHTML);

				System.out.println("Trying healed xpath: " + healedXpath);

				element = driver.findElement(By.xpath(healedXpath));

				System.out.println("AI Self-Healing Successful");

			} catch (Exception ex) {

				System.out.println("AI Self-Healing Failed");

				ex.printStackTrace();
			}
		}

		return element;
	}
}