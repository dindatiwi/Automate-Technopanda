package technopanda.automate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileListPage extends BasePage{
	
	//Locator
	By productName = By.xpath("(//h2[@class='product-name'])");
	By selectName = By.xpath("(//select[@title='Sort By'])[1]");
	By title = By.tagName("h1");

	public MobileListPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	//Function
	
	public String getTitle() {
		return getText(title);
	}
	
	public void sort(String sortBy) {
		dropdown(selectName, sortBy);
	}
	
	public List<String> getListData(){
		return getData(productName);
	}

}
