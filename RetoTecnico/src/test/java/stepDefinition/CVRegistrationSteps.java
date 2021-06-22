package stepDefinition;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumPages.CVRegistrationPage;

public class CVRegistrationSteps {
	
	CVRegistrationPage cvRegPage = new CVRegistrationPage();
	
	@Given("the user is on the main page")
	public void userIsOnTheMainPage() {
		cvRegPage.launch();
		cvRegPage.goToMainPage();
	}
	@When("the user goes to the section to register CV")
	public void userGoesToTheSectionToRegisterCV() {
	}
	
	@When("fills in {string}, {string}, {string} and {string}")
	public void fillsIn(String firstName, String lastName, String email, String phone) {
		cvRegPage.fillCVRegistration(firstName, lastName, email, phone);
	}

	@When("submits")
	public void submits() {
		cvRegPage.submit();
	}
	
	@Then("the manual registration page is displayed")
	public void theManualRegistrationPageIsDisplayed() {
		assertTrue(cvRegPage.getPageTitle().contains("Registro"));
		cvRegPage.closeBrowser();
	}
	
	@Then("an error alert should be dispayed")
	public void errorAlertDisplayed() {
		assertTrue(cvRegPage.getEmailValidationMsg().contains("Incluye un signo \"@\" en la dirección de correo electrónico"));
		cvRegPage.closeBrowser();
	}

}
