package seleniumPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public WebDriverWait waitVar;
	public JavascriptExecutor jsExecutor;
	
	public void launch() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver");
		driver = new ChromeDriver();
		waitVar = new WebDriverWait(driver, 180);
		driver.manage().window().maximize();
		jsExecutor = (JavascriptExecutor) driver;
		
	}
	public String getPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.quit();
	}
}
