package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {

		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter(
					"test-output/AutomationReport.html");

			spark.config().setReportName("BPS Regression Automation Test Results");

			spark.config().setDocumentTitle("Automation Execution Report");

			spark.config().setTheme(Theme.STANDARD);

			spark.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss a");

			spark.config().setCss(
					".brand-logo { width: 400px !important; height: auto !important; object-fit: contain !important; }"
							+ ".row .col-md-6:last-child { display: none !important; }"
							+ ".row .col-md-6:first-child { width: 100% !important; flex: 0 0 100% !important; max-width: 100% !important; }"
							+ ".row { display: flex; flex-wrap: wrap; gap: 0; }"
							+ ".card-title { font-size: 24px !important; font-weight: 600 !important; color: #002244 !important; }"
							+ ".card-footer { font-size: 18px !important; font-weight: 500 !important; color: #222 !important; }"
							+ "table { border-collapse: collapse !important; width: 100%; border: 1px solid #ccc !important; }"
							+ "table th, table td { border: 1px solid #ccc !important; padding: 4px 8px !important; }"
							+ "table th { background-color: #00468b !important; color: white !important; font-weight: bold !important; }"
							+ ".card-body h6 { font-size: 28px !important; font-weight: 600 !important; color: #003366 !important; }"
							+ "h2 { font-size: 22px !important; font-weight: 600 !important; color: #222 !important; }"
							+ ".dropdown-menu, .dropdown-menu.show, .select-dropdown {max-height: 300px !important;overflow-y: auto !important;}");

			extent = new ExtentReports();

			extent.attachReporter(spark);

			extent.setSystemInfo("Tester", "Sumit");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Browser", "Chrome");
			extent.setSystemInfo("Framework", "Selenium + TestNG");
			extent.setSystemInfo("OS", System.getProperty("os.name"));

		}

		return extent;
	}
}