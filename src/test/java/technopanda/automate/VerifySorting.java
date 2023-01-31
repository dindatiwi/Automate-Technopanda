package technopanda.automate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifySorting extends BaseWebTest{
	
	WelcomePage welcomePage = new WelcomePage(driver, explicitWait);
	MobileListPage mobileListPage = new MobileListPage(driver, explicitWait);
	
	//String
	String sortBy = "Name";
	String expectedTitleMobile = "MOBILE";
	String expectedTitleWelcome = "THIS IS DEMO SITE FOR   ";
	
	
  @Test
  public void verify_item_sorted_by_name(){
	 String actualTitleWelcome = welcomePage.getTitle();
	 try {
		  	//assert title on mobile page
			Assert.assertEquals(actualTitleWelcome, expectedTitleWelcome);
	} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
  	welcomePage.clickMobilePage();
  	
  	String actualTitleMobile = mobileListPage.getTitle();
  	
  	try {
		//assert title on mobile page
		Assert.assertTrue(actualTitleMobile.contains(expectedTitleMobile));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  	//get data before filter
  	List<String> beforeFilterList = mobileListPage.getListData();
	System.out.println(beforeFilterList);
  	mobileListPage.sort(sortBy);
  	
  	//get data after filter
  	List<String> afterFilterList = mobileListPage.getListData();
	System.out.println(afterFilterList);
  
	//before filter list sorted first
  	Collections.sort(beforeFilterList);

  	//assertion values mobile list
  	Assert.assertEquals(beforeFilterList, afterFilterList);
  	
  }

}
