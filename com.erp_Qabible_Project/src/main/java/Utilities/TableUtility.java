package Utilities;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TableUtility {
	
	public static boolean isTextPresentinTable(List<WebElement>tableRows,String searchText) {
		for(WebElement row:tableRows) {
			String rowText=row.getText();
			if(rowText.contains(searchText)) {
				System.out.println("Found Row: "+rowText);
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
 
