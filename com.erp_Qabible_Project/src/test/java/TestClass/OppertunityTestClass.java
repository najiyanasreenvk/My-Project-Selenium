package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import PageClasses.OppertunityPageClass;
import Utilities.ExcelreadUtility;

public class OppertunityTestClass extends BaseClass {
	
	LoginPageClass lp;
	DashBoardPageClass dp;
	OppertunityPageClass op;
	
  @Test(priority = 1)
  public void verifyoppertunityTitleIsvisible() throws IOException {
	  lp= new LoginPageClass(driver);
	  dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  //dp =new DashBoardPageClass(driver);
	  dp.clickOnOpportunitybutton();
	  op=new OppertunityPageClass(driver);
	  
	  Assert.assertTrue(op.oppertunityTitleIsDispalyed(),"Oppertunity title is not displayed");
	  
  }
  @Test(priority =2 )
  public void verifySearchResultContainsTester() throws IOException {
	  lp=new LoginPageClass(driver);
	  dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  //dp= new DashBoardPageClass(driver);
	  dp.clickOnOpportunitybutton();
	  op=new OppertunityPageClass(driver);
	  op.searchKeyword("TESTER");
	  String actualResult=op.getMatchedrawText("TESTER");
	  System.out.println("Match row : "+actualResult);
	  Assert.assertTrue(actualResult.contains("TESTER"),"result not matching");
  }

  
  
  
  
}
