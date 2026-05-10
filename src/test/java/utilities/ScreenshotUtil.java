package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String screenshotPath = "test-output/screenshots/" + testName + "_" + timeStamp + ".png";

		try {

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File dest = new File(screenshotPath);

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return screenshotPath;
	}
}