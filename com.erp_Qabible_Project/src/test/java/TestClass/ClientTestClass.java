package TestClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PageClasses.ClientPageClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import Utilities.ExcelreadUtility;
import Utilities.RandomDataUtility;

public class ClientTestClass extends BaseClass {
	LoginPageClass lp;
	DashBoardPageClass dp;
	ClientPageClass cp;
  @Test
  public void verifyCreateNewClient() throws IOException {
	 lp =new  LoginPageClass(driver);
	 dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	 //dp=new DashBoardPageClass(driver);
	 dp.clickClientTab();
	 cp=new ClientPageClass(driver);
	 cp.clickNewClientButton();
	 String name=RandomDataUtility.getName();
	 String email=RandomDataUtility.getEmail();
	 cp.fillClientForm(name,email);
	 
	 String actual=cp.getTextofsuccessMessage();
	 
	 Assert.assertTrue(actual.contains(ExcelreadUtility.getStringData(0, 0, "Client")));
	
	  
  }
  @Test
  public void verifySearchClientfunctionality() throws IOException {
	  lp=new LoginPageClass(driver);
	  dp=lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  //dp=new DashBoardPageClass(driver);
	  dp.clickClientTab();
	  
	  cp= new ClientPageClass(driver);
	  String name=RandomDataUtility.getName();
	  String email=RandomDataUtility.getEmail();
	  cp.clickNewClientButton();
	  cp.fillClientForm(name, email);
	  dp.clickClientTab();
	  cp.searchNewClient(name);
	  String actualResult=cp.getResultOfRaw(name);
	  System.out.println("Raw result is : "+actualResult);
	  Assert.assertTrue(actualResult.contains(name),"result not matching");
	
	  
  }
  
  
  @Test
  public void verifyNewClientButtonisVisible() throws IOException {
	  lp= new LoginPageClass(driver);
	  lp.signIn(ExcelreadUtility.getStringData(0, 0, "LoginPage"),ExcelreadUtility.getIntData(0, 1, "LoginPage"));
	  dp= new DashBoardPageClass(driver);
	  dp.clickClientTab();
	  cp= new ClientPageClass(driver);
	  boolean actual=cp.visibilityOfNeqwClientTab();
	  Assert.assertTrue(actual, "New Client tab not visible");
  }
  
}
