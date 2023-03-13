package stepDefinitions;

import Base.Base;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Login extends Base {

    WebDriver driver;
    LoginPage loginPage;

    public Login() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));

        loginPage = new LoginPage(driver);
        loginPage.clickOnMyAccount();
        loginPage.clickOnLogin();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {

    }
    @When("User enters valid email address {string}")
    public void user_enters_valid_email_address(String validEmail) {

    }
    @And("User enters valid password {string}")
    public void user_enters_valid_password(String validPass) {

    }
    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {

    }
    @Then("User should get successfully login")
    public void user_should_get_successfully_login() {

    }
    @When("User enters invalid email address {string}")
    public void user_enters_invalid_email_address(String invalidEmail) {

    }
    @And("User enters invalid password {string}")
    public void user_enters_invalid_password(String invalidPass) {

    }
    @Then("User should get proper warning message {string}")
    public void user_should_get_proper_warning_message(String warningMsg) {

    }



}
