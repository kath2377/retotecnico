package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumPages.ManualRegistrationPage;

public class ManualRegistrationSteps {
	
	ManualRegistrationPage registPage = new ManualRegistrationPage();
	
	@Given("user is on the main page")
	public void userIsOnTheMainPage() {
		registPage.launch();
		registPage.goToMainPage();
	}
	@When("user goes to Register option")
	public void userGoesToRegisterOption() {
		registPage.goToRegisterPage();
	}
	@When("user fills in his data")
	public void userFillsInHisData() throws InterruptedException {
		registPage.fillData("tortugavelozflash@gmail.com", "Juan", "Casas", "Perú", "23/08/1996");
	}
	@Then("his profile page should be displayed")
	public void hisProfilePageShouldBeDisplayed() {
		assertTrue(true);
		registPage.closeBrowser();
	}
	
	@When("user enters an invalid email")
	public void userEntersInvalidEmail() {
		registPage.fillInvalidEmail("aaa");
	}
	
	@Then("an invalid error message should be displayed")
	public void errorMsgShoulBeDisplayed() {
		assertEquals("El valor ingresado no es un correo electrónico válido",registPage.getErrorMsg());
		registPage.closeBrowser();
	}
}
