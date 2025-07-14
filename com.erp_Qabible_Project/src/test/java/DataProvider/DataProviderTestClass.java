package DataProvider;

import org.testng.annotations.Test;

import Utilities.ExcelreadUtility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderTestClass {
  

  @DataProvider(name="unsuccessfullLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] {ExcelreadUtility.getStringData(2, 0, "LoginPage"),ExcelreadUtility.getIntData(2, 1, "LoginPage")},
      new Object[] {ExcelreadUtility.getStringData(3, 0, "LoginPage"),ExcelreadUtility.getIntData(3, 1, "LoginPage") },
      new Object[] {ExcelreadUtility.getStringData(4, 0, "LoginPage"),ExcelreadUtility.getStringData(4, 1, "LoginPage")}
    };
  }
}
