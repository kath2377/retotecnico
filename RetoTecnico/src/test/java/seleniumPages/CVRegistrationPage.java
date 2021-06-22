package seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CVRegistrationPage extends PageBase {

	private String mainUrl = "https://www.choucairtesting.com/empleos-testing/";

	public void goToMainPage() {
		driver.get(mainUrl);
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ir al portal de empleos")));
		WebElement btnElement = driver.findElement(By.partialLinkText("Ir al portal de empleos"));
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", btnElement);
		driver.findElement(By.partialLinkText("Ir al portal de empleos")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("CONTINUAR")));
		driver.findElement(By.partialLinkText("CONTINUAR")).click();

	}

	public void fillCVRegistration(String firstName, String lastName, String email, String phone) {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("candidate_first_name")));
		WebElement inputElement = driver.findElement(By.id("candidate_first_name"));
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", inputElement);
		inputElement.sendKeys(firstName);
		driver.findElement(By.id("candidate_last_name")).sendKeys(lastName);
		driver.findElement(By.id("candidate_email")).sendKeys(email);
		driver.findElement(By.id("candidate_phone")).sendKeys(phone);
	}

	public void submit() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public String getEmailValidationMsg() {
		WebElement emailField = driver.findElement(By.id("candidate_email"));
		return (String)jsExecutor.executeScript("return arguments[0].validationMessage;", emailField);
	}
}
