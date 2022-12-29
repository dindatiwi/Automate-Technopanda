package technopanda.automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends BasePage{
	
	//Locator
	By mobileBtn = By.xpath("(//a[normalize-space()='Mobile'])[1]");

	public WelcomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	//Function
	public void clickMobilePage() {
		clickAndWait(mobileBtn);
	}
	
}
