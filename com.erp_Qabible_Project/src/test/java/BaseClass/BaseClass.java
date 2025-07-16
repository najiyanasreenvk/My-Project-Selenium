package BaseClass;

import org.testng.annotations.Test;

import Constant.ConstantClass;
import extentReport.ExtentManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public static WebDriver driver;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + ConstantClass.propertiesfilepath);
		property.load(fs);
	}

	@Parameters("browser")
	@BeforeMethod(groups = { "TearUp" })
	public void beforeMethod(String browserValue) throws IOException {
		readProperty();
		if (browserValue.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (browserValue.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			throw new IllegalArgumentException("invalid browser  " + browserValue);
		}

		driver.manage().window().maximize();
		driver.get(property.getProperty("Base_Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConstantClass.implicitwaittimeout));
	}

	@AfterMethod(groups = { "TearDown" })
	public void afterMethod() {
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void createReport() {
		ExtentManager.createInstance();
	}

}
