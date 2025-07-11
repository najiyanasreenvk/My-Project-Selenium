package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;




public class LoginPageClass {
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name =  "user_name") WebElement username;
	@FindBy(name = "password") WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-primary  btn-flat']")WebElement sign_in_button;
	@FindBy(xpath = "//div[@class='alert alert-danger']")WebElement unsuccessfull_Text;
	@FindBy(name = "remember" )WebElement remember_me;
	
	
	
	public void signIn(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		wu.waitForElementToBeClickableByXpathLocator_Utility(driver, "//button[@class='btn btn-primary  btn-flat']", 3);
		sign_in_button.click();
	}
	public String getcurrentUrlLogin() {
		return gu.getCurrentURL(driver);
		
	}
	
	public String getTextOfUnsuccessfullText() {
		wu.visibilityOf(driver, unsuccessfull_Text, 3);
		return gu.getTextofElement(unsuccessfull_Text);
		
	}
	
	
	public boolean remebermeIsSelected() {
		wu.presenceOfElementLocate(driver, "//span[@class='fa fa-check']", 3);
		return gu.isElementSelected(remember_me);
	}
	
	public String getAttributeofUsername() {
		return gu.getAttributeofElement(username, "placeholder");
	}
	
	

		
	


}
