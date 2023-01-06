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
	String expectedTitleWelcome = "This is demo site for   ";
	
	  
	  @Test
	  public void verify_welcome_title() {
		  	String actualTitle = welcomePage.getTitle();
		  	//assert title on mobile page
		  	Assert.assertTrue(actualTitle.contains(expectedTitleWelcome.toUpperCase()));
	  }
	  
	  
	  @Test
	  public void verify_mobile_title() {
		  	welcomePage.clickMobilePage();
		  	String actualTitle = mobileListPage.getTitle();
		  	
		  	//assert title on mobile page
		  	Assert.assertTrue(actualTitle.contains(expectedTitleMobile));
		  	
	  }
	
  @Test
  public void verify_item_sorted_by_name(){
  	welcomePage.clickMobilePage();

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
