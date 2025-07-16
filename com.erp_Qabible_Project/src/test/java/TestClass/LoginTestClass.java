package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import DataProvider.DataProviderTestClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import Utilities.ExcelreadUtility;

public class LoginTestClass extends BaseClass {
	LoginPageClass lp;
	DashBoardPageClass dp;

	@Test(priority = 1,groups = {"Group 1"})
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPageClass(driver);
		dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));

		//dp = new DashBoardPageClass(driver);
		String actualResult = dp.getTextofDashboard();
		System.out.println("Actual text : " + actualResult);
		Assert.assertEquals(actualResult, ExcelreadUtility.getStringData(0, 0, "DashBoard"));

	}

	@Test( priority = 2, dataProvider="unsuccessfullLogin",dataProviderClass = DataProviderTestClass.class)
	public void verifyUnsuccessfullLogin(String u,String p) throws IOException {
		lp = new LoginPageClass(driver);
		lp.signIn(u,p);
		String actualResult = lp.getTextOfUnsuccessfullText();
		System.out.println("Login unsuccessfull : " + actualResult);
		Assert.assertTrue(actualResult.contains(ExcelreadUtility.getStringData(6, 0, "LoginPage")));

	}

	@Test(priority = 3,groups = {"Group 1"})
	public void verifytheCurrentApplicationisloginWhileHitting() throws IOException {
		lp = new LoginPageClass(driver);
		String actualResult2 = lp.getcurrentUrlLogin();
		System.out.println("current url" + actualResult2);
		Assert.assertEquals(actualResult2, ExcelreadUtility.getStringData(8, 0, "LoginPage"), "Login page URL is not correct");

	}

	@Test(priority = 4)
	public void varifyRemembermeisCheckedOrnot() throws IOException {
		lp = new LoginPageClass(driver);
		//lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
		boolean actualResult = lp.remebermeIsSelected();
		System.out.println("Remember me chekbox is selected: " + actualResult);
		Assert.assertFalse(actualResult, "Remember me checkbox is selected by default ");
	}
	@Test(priority = 5,groups = {"Group2"})
	public void verifyAttributOfUsernameField() throws IOException {
		lp =new LoginPageClass(driver);
		String actualresult=lp.getAttributeofUsername();
		System.out.println("user name place holder is : "+actualresult);
		Assert.assertEquals(actualresult, ExcelreadUtility.getStringData(9, 0, "LoginPage"),"username placeholder not correct");
	}
	

}
