package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	WebDriverWait wait;
	
    //element clickableByxpath
	public void waitForElementToBeClickableByXpathLocator_Utility(WebDriver driver, String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}
	
	
   //element clickableByid
	public void waitForElementToBeClickableBylocator(WebDriver driver, String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}
	
	
      //Alert Present
	public void waitForAlertPresent(WebDriver driver, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
   //clickabelByElement
	public void waitForElementToBeClickableByWebElement(WebDriver driver, WebElement element, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	   //visibilityOf
	public void visibilityOf(WebDriver driver,WebElement element, int timeout) {
		wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	//visibilityOfElementLocated
	public void visibilityOfElementLocatd(WebDriver driver,String locaterValue, int timeout) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locaterValue)));
	}
	
	//presenceOfElementLocate
	public void presenceOfElementLocate(WebDriver driver, String locaterValue,int timeout) {
		wait= new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locaterValue)));
	}
	
     //fluentWait
	public void fluentWaitForElementtoBeClickableByIdLocator_Utility(WebDriver driver, String locatorValue,
			int totalTimeOut, int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}


}
