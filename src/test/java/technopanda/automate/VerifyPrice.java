package technopanda.automate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyPrice extends BaseWebTest {

	WelcomePage welcomePage = new WelcomePage(driver, explicitWait);
	MobileDetailsPage mobileDetails = new MobileDetailsPage(driver, explicitWait);

	String toFind = "Sony Xperia";
	

	@Test
	public void verify_price() {
		welcomePage.clickMobilePage();
		
		//get all mobile data and save to map
		Map<String,String> dataToCompare = mobileDetails.getFindData();
		
		//get data by title and get the value to save to a var
		String compareA = dataToCompare.get(toFind.toUpperCase());
		
		//click to data link text
		mobileDetails.clickToDetailsPage(toFind.toUpperCase());
		
		//get data price of details page
		String compareB = mobileDetails.getPrice();
		
		//assertion from the data on mobile page and mobile details page
		try {
			//assert title on mobile page
		  	Assert.assertEquals(compareA, compareB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
