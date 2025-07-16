package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import Utilities.ExcelreadUtility;

public class DashboardTestClass extends BaseClass {
	DashBoardPageClass dp;
	LoginPageClass lp;
 
	  
  
  
  @Test(priority = 1,groups = {"Group 1"})
  public void verifytheToolTipShowed () throws IOException {
	  lp= new LoginPageClass(driver);
	  dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  //dp=new DashBoardPageClass(driver);
	  
	  String actualResult=dp.getAttributeOfSearchIcon();
	  System.out.println("Tool tip is: "+actualResult);

	  Assert.assertEquals(actualResult, "Search","Tooltip not matching");
	  
	  
  }
  
  @Test(priority = 2)
  public void verifyLogoIsDisplayed() throws IOException {
	  lp= new LoginPageClass(driver);
	  dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  //dp= new DashBoardPageClass(driver);
	  boolean actual=dp.logoIsDisplayed();
	  Assert.assertTrue(actual, "Logo is not visible");
  }
  
  
  
}
