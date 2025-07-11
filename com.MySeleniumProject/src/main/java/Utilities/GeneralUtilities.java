package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	// re-usable utility methods

		// getText();(static or non-static method)//calling inside of page class.
		public String getTextofElement(WebElement element) {

			return element.getText();

		}

		// isDisplayed()
		public boolean iselementDisplayed(WebElement element) {

			return element.isDisplayed();
		}
		
		//isSelected()
		public boolean isElementSelected(WebElement element) {
			return element.isSelected();
		}
		
		//isEnabled()
		public boolean isElementEnabled(WebElement element) {
			return element.isEnabled();
		}
		
		
		// getAttribute()
		public String getAttributeofElement(WebElement element, String attribute) {

			return element.getAttribute(attribute);
		}

		// getTitle
		public String getpageTittle(WebDriver driver) {
			return driver.getTitle();

		}

		// getCurrentURL
		public String getCurrentURL(WebDriver driver) {
			return driver.getCurrentUrl();

		}

		// JavaScript Click

		public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		// JavaScript scroll

		public void scrollUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		}

		// JavaScript scrollBy

		public void scrollUsingJavaScriptExecutor_ScrollBy(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
		}

		// MouseHovering

		public void mouseHoverElement_Utility(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}

		// MouseHovering Click

		public void mouseHoverandClick(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
		}

		// FileUploading
		public void fileUploading(WebElement element, String filepath) {
			element.sendKeys(filepath);

		}

		// DropDown IsMultiSelect
		public boolean isMultiSelectDropdown_Utility(WebElement element) {
			Select select = new Select(element);
			return select.isMultiple();
		}

		// DropDown SelectByIndex

		public void selectDropdownValueByIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		//selectByVisibleText
		public void selectDropdownValueByVisibleText(WebElement element,String text) {
			Select select=new Select(element);
			select.selectByVisibleText(text);
		}
		
		//deselctAll
		public void deSelectAll(WebElement element) {
			Select select=new Select(element);
			select.deselectAll();
		}
		
		//deSelectByindex
		public void deSelectByIndex(WebElement element,int index) {
			Select select = new Select(element);
			select.deselectByIndex(index);
		}
		
		//deSelectByVisibleText
		public void deSelectByVisibleText(WebElement element,String text) {
			Select select=new Select(element);
			select.deselectByVisibleText(text);
		}
		
	    // DropDown getallOptions
		public List<String> getAllDropDownOptions_Utility(WebElement element) {
			Select select = new Select(element);
			return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
		}
		//getOptions
		public List<String>getOptions(WebElement element){
			Select select =new Select(element);
			List<WebElement> allOptions=select.getOptions();
			List<String> optionText=new ArrayList<String>();
			for (WebElement webElement: allOptions) {
				    optionText.add(webElement.getText());
			}
			return optionText;
		}
		
		//DropDown getAllSelectedOptions()
		public List<String> getAllSelectedOption(WebElement element) {
			Select select = new Select(element);
			return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
		}
		
		//Drag and Drop()
		public void dragAndDrop_utility(WebElement source,WebElement target,WebDriver driver) {
			Actions act=new Actions(driver);
			act.dragAndDrop(source, target).perform();
		}
		
		
		//doubleClick()
		public void doubleClick_utility(WebDriver driver) {
			Actions act=new Actions(driver);
			act.doubleClick().perform();
		}
			
		
		
		//Alert accept()
		public void alertAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		
		//Alert dismiss()
		public void alertDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		
		
		//getText of Alert()
		public String getTextofAlertMessage(WebDriver driver) {
			return driver.switchTo().alert().getText();
		}
		//frame
		public void switchToFrameByNameOrID_Utility(WebDriver driver, String NameOrID) {
			driver.switchTo().frame(NameOrID);
		}
		
		
		//defaultContent()
		public void switchToDefaultContent(WebDriver driver) {
			driver.switchTo().defaultContent();
		}
		
		
		//Thread.Sleep
		
		public void addSleep(long timeOut) throws InterruptedException {
			Thread.sleep(timeOut);
		}


	}



