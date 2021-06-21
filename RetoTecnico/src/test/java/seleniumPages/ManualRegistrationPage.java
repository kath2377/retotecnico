package seleniumPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManualRegistrationPage extends PageBase{
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
	
	public void goToRegisterPage() {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Registrarse")));
		driver.findElement(By.partialLinkText("Registrarse")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
	}
	
	public void fillInvalidEmail(String email) {

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("registration-type__card")));
		driver.findElements(By.className("registration-type__card")).get(1).click();

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("registration-type__next-step")));
		driver.findElement(By.className("registration-type__next-step")).click();

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		driver.findElements(By.xpath("//input[@type='email']")).get(0).sendKeys(email);
		
	}
	
	public String getErrorMsg() {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		return driver.findElement(By.xpath("//div[@role='alert']")).getText();
		
	}
	
	public void fillData(String email, String firstName, String lastName, String countryName, String birthDate) throws InterruptedException {
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("registration-type__card")));
		driver.findElements(By.className("registration-type__card")).get(1).click();

		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className("registration-type__next-step")));
		driver.findElement(By.className("registration-type__next-step")).click();

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
		driver.findElements(By.xpath("//input[@type='email']")).get(0).sendKeys(email);
		driver.findElements(By.xpath("//input[@type='email']")).get(1).sendKeys(email);
		WebElement btnElement = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", btnElement);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("personal-info_firstName")));
		System.out.println("encontro campo nombre");
		Thread.sleep(2000);
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", driver.findElement(By.id("personal-info_firstName")));
		driver.findElement(By.id("personal-info_firstName")).clear();
		driver.findElement(By.id("personal-info_firstName")).sendKeys(firstName);
		driver.findElement(By.id("personal-info_lastName")).clear();
		driver.findElement(By.id("personal-info_lastName")).sendKeys(lastName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.id("birth-info_countryBirth")));
		Thread.sleep(1500);
		jsExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded();", driver.findElement(By.id("birth-info_countryBirth")));
		driver.findElement(By.id("birth-info_countryBirth")).sendKeys(countryName, Keys.RETURN);
		driver.findElement(By.id("birth-info_birthdate")).sendKeys(birthDate, Keys.RETURN);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='male']")));
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//input[@value='male']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		/*
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.xpath("//input[@value=8]")).click();
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(1500);
		 * driver.findElement(By.xpath("//input[@value=26]")).click();
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(1500);
		 * 
		 * driver.findElement(By.xpath("//input[@value=1]")).click();
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * Thread.sleep(1500);
		 * 
		 * driver.findElement(By.id("salary-info_salary")).sendKeys("3500");
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 * 
		 * Thread.sleep(1500); driver.findElement(By.id("cities-info_cityId")).
		 * sendKeys("Lima, Lima y Callao",Keys.RETURN);
		 * driver.findElement(By.xpath("//button[@type='submit']")).click();
		 */


	}
}
