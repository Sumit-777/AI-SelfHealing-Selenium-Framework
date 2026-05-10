package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import testdataManagemenyt.TestData;

public class LoginPageTest extends BaseTest{
	LoginPage login;
	
	@BeforeMethod
	public void preReq() {
		login=new LoginPage(driver);
	}
	
	@Test(dataProvider = "login",dataProviderClass = TestData.class)
	public void loginExecutionTest(String col1,String col2) {
		Assert.assertTrue(login.doLogin(col1, col2),"User Is unable to Login or Post Login Page broken");
		
	}

}
