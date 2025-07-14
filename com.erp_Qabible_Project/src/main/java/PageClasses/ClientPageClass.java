package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;

public class ClientPageClass {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ClientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/client/create_client']")
	WebElement create_newclient;
	@FindBy(xpath = "//input[@name='name']")
	WebElement company_name;
	@FindBy(xpath = "//input[@type='email']")
	WebElement company_email;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save_buttn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement search_box;
	@FindBy(xpath = "//table[@id='DataTables']/tbody/tr")
	List<WebElement> table_row;
	@FindBy(xpath = "//div[contains(text(),'Client updated successfully!')]")
	WebElement create_successfull;

	public void clickNewClientButton() {
		// wu.waitForElementToBeClickableBylocator(driver, "//a[text()='New Client']",
		// 1);
		create_newclient.click();
	}

	public void fillClientForm(String name, String email) {
		company_name.sendKeys(name);
		company_email.sendKeys(email);
		save_buttn.click();

	}

	public void searchNewClient(String clientName) {
		search_box.clear();
		search_box.sendKeys(clientName);

	}

	public String getTextofsuccessMessage() {
		return gu.getTextofElement(create_successfull);
	}
	
	

	public String getResultOfRaw(String clientName) {
		for (WebElement row : table_row) {
			String rowText = row.getText();
			if (rowText.contains(clientName))
				
			{
				return rowText;
			}
		}
		return "no match found";
	}

	public boolean visibilityOfNeqwClientTab() {
		return gu.iselementDisplayed(create_newclient);
	}

}
