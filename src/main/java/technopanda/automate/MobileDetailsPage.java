package technopanda.automate;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobileDetailsPage extends BasePage {
	
	By ProductName = By.xpath("//*[@class='product-name']");
	By ProductPrice = By.xpath("//*[@class='price-box']");


	public MobileDetailsPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		// TODO Auto-generated constructor stub
	}
	
	public Map<String,String> getFindData(){
		return getDataWithMap(ProductName, ProductPrice);
	}
	
	public void clickToDetailsPage(String GetFindText) {
		By findText = By.linkText(GetFindText);
		clickAndWait(findText);
	}
	
	public String getPrice() {
		return getText(ProductPrice);
	}

}
