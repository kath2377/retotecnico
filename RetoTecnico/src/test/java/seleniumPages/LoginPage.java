package seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBase {
	private String mainUrl = "https://www.choucairtesting.com/empleos-testing/";

	public LoginPage() {
		super();
	}

	public void goToLogin() {
		driver.get(mainUrl);
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ir al portal de empleos")));
		WebElement btnElement = driver.findElement(By.partialLinkText("Ir al portal de empleos"));
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", btnElement);
		driver.findElement(By.partialLinkText("Ir al portal de empleos")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("CONTINUAR")));
		driver.findElement(By.partialLinkText("CONTINUAR")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ingresar")));
		driver.findElement(By.partialLinkText("Ingresar")).click();

	}

	public void enterEmail(String email) {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailSignIn")));
		driver.findElement(By.id("emailSignIn")).sendKeys(email);

	}

	public void enterPassword(String password) {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailSignInConfirm")));
		driver.findElement(By.id("emailSignInConfirm")).sendKeys(password);

	}
	
	public void enterPasswordAfterWrongEmail() throws InterruptedException {
		driver.findElement(By.id("emailSignIn")).sendKeys(Keys.TAB);

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("messageValidateexistEmail")));

		Thread.sleep(1000);
	}

	public String getEmailValidationMsg() {
		
		return driver.findElement(By.id("messageValidateexistEmail")).getText();
	}

	public void submit() {
		driver.findElement(By.id("btnSubmitLogin")).click();
		waitVar.until(ExpectedConditions.titleContains("Magneto"));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.quit();
	}
}
