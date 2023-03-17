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

    @Given("^User navigates to login page$")
    public void user_navigates_to_login_page() {
        System.out.println("User navigates to login page");
    }
    @When("^User enters valid email address (.+)$")
    public void user_enters_valid_email_address(String validEmail) {
        System.out.println("User enters valid email address");
    }
    @And("^User enters valid password (.+)$")
    public void user_enters_valid_password(String validPass) {
        System.out.println("User enters valid password");
    }
    @And("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        System.out.println("User clicks on Login button");
    }
    @Then("^User should get successfully login$")
    public void user_should_get_successfully_login() {
        System.out.println("User should get successfully login");
    }
    @When("^User enters invalid email address (.+)$")
    public void user_enters_invalid_email_address(String invalidEmail) {
        System.out.println("User enters invalid email address");
    }
    @And("^User enters invalid password (.+)$")
    public void user_enters_invalid_password(String invalidPass) {
        System.out.println("User enters invalid password");
    }
    @Then("^User should get proper warning message (.+)$")
    public void user_should_get_proper_warning_message(String warningMsg) {
        System.out.println("User should get proper warning message");
    }

    @When("^User dont enters any credentials$")
    public void user_dont_enters_any_credentials() {
        System.out.println("User dont enters any credentials");
    }

}
