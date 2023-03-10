package technopanda.automate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
	public BasePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		this.driver= driver;
		this.explicitWait = explicitWait;
	}
	
	public void clickAndWait(By locator) {
		driver.get().findElement(locator).click();
	}
	
	public void setText(By locator, String text) {
		driver.get().findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		return driver.get().findElement(locator).getText();
	}
	
	public void dropdown(By locator, String Text) {
		Select dropdown = new Select(driver.get().findElement(locator));
		dropdown.selectByVisibleText(Text);
	}
	
	public List<String> getData(By locator) {
	  	List<WebElement> filterData = driver.get().findElements(locator);
	  	List<String> FilterList = new ArrayList<>();
	  	for(WebElement p : filterData) {
	  		FilterList.add(p.getText());
	  	}
	  	return FilterList;
	}
	
	public Map<String, String> getDataWithMap(By locatorA,By locatorB){
	  	List<WebElement> filterData = driver.get().findElements(locatorA);
	  	List<WebElement> filterzData = driver.get().findElements(locatorB);
	  	Map<String,String> testData = new HashMap<>();
	  	for(int i = 0;i< filterData.size();i++) {
	  		testData.put(filterData.get(i).getText(), filterzData.get(i).getText());
	  	}
		
		return testData;
	}

}
