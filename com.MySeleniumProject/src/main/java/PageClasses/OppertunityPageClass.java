package PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;

public class OppertunityPageClass {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	
	public OppertunityPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Opportunities']")WebElement oppertunity_title;
	@FindBy(xpath = "//input[@class='form-control input-sm']")WebElement search_box;
	@FindBy(xpath = "//table[@id='DataTables']/tbody/tr")List<WebElement> tableRow;
	
	public boolean oppertunityTitleIsDispalyed() {
		return gu.iselementDisplayed(oppertunity_title);
	}
	public void searchKeyword(String keyword) {
		search_box.clear();
		search_box.sendKeys(keyword);
	}
	
	public String getMatchedrawText(String keyword) {
		for(WebElement row :tableRow) {
			String rowText =row.getText();
			if(rowText.contains(keyword));{
				return rowText;
			}
			
		}
		return "no match found";
	}

}
