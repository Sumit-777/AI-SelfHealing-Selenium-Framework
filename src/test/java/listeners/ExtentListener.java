package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentManager;

public class ExtentListener implements ITestListener {

	ExtentReports extent = ExtentManager.getReportInstance();

	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Execution Started");
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		ExtentTest extentTest = extent.createTest(testName);

		extentTest.assignCategory(result.getTestClass().getRealClass().getSimpleName());

		test.set(extentTest);

		System.out.println("Test Started: " + testName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.get().log(Status.PASS, "Test passed");

		System.out.println("Test Passed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		if (test.get() == null) {

			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

			test.set(extentTest);
		}

		test.get().log(Status.FAIL, result.getThrowable());

		System.out.println("Test Failed: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		if (test.get() == null) {

			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

			test.set(extentTest);
		}

		test.get().log(Status.SKIP, "Test skipped");

		System.out.println("Test Skipped: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

		System.out.println("Execution Completed");
	}
}