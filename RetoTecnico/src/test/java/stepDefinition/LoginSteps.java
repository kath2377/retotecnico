package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumPages.LoginPage;

public class LoginSteps {

	LoginPage loginPage = new LoginPage();

	@Given("user is on the Login page")
	public void userIsOnTheLoginPage() {
		loginPage.launch();
		loginPage.goToLogin();
	}

	@When("user fills in email with {string}")
	public void userFillsInEmailWith(String email) {
		loginPage.enterEmail(email);
	}

	@When("user fills in password with {string}")
	public void userFillsInPasswordWith(String password) {
		loginPage.enterPassword(password);
	}

	@When("user presses Submit")
	public void userPressesSubmit() {
		loginPage.submit();
	}

	@Then("user should be on his profile page")
	public void userShouldBeOnHisProfilePage() {
		assertTrue(loginPage.getPageTitle().contains("Perfil"));
	}

	@When("user tries to fill in password")
	public void userTriesToFillInPassword() throws InterruptedException {
		loginPage.enterPasswordAfterWrongEmail();
	}

	@Then("an error message should be displayed")
	public void anErrorMessageShouldBeDisplayed() {
		assertEquals("No se encontró cuenta asociada al correo.",loginPage.getEmailValidationMsg());
	}

}
