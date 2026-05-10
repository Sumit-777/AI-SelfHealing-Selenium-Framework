package testdataManagemenyt;

import org.testng.annotations.DataProvider;

import utilities.ConfigReader;
import utilities.ExcelUtils;

public class TestData {
	@DataProvider(name="login")
	public static Object[][] logindata() {
		String path=ConfigReader.readConfig("testdatapath");
		String sheetname=ConfigReader.readConfig("testdatasheet");
		return ExcelUtils.readExcel(path, sheetname);
	}

}
