package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;


public class DashBoardPageClass {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	

	public DashBoardPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='text-muted']")WebElement dashboard_Text;
	@FindBy(xpath = "//span[contains(text(),'Opportunities')]") WebElement oppertunity_buttn;
	@FindBy(id = "goal_report_btn")WebElement search_icon;
	@FindBy(xpath = "//a[@title='Client']")WebElement client_label;
	@FindBy(xpath = "//img[@src='https://erp.qabible.in/uploads/SurviCamLogoHighResTransparent.png']")WebElement logo_image;
	
	
	public String getTextofDashboard() {
		return gu.getTextofElement(dashboard_Text);
	}
	
	public boolean logoIsDisplayed() {
		return gu.iselementDisplayed(logo_image);
	}
	
	
	
	
	public void clickOnOpportunitybutton() {
		
		oppertunity_buttn.click();
	}
	
	public void clickClientTab() {
		//wu.waitForElementToBeClickableBylocator(driver, "//a[@title='Client']", 6);
		client_label.click();
		
	}
	public String getAttributeOfSearchIcon() {
       //Actions act= new Actions(driver);
		//act.moveToElement(search_icon).perform();
		return gu.getAttributeofElement(search_icon, "data-original-title");
	}
	
	
	
	
	
	
	
	

}
