package technopanda.automate;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseWebTest {
	 
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver.set(new ChromeDriver());
	  explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
	  driver.get().get("http://live.techpanda.org/index.php/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.get().quit();
  }

}
