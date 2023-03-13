package stepDefinitions;

import Base.Base;
import Pages.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Register extends Base {

    WebDriver driver;
    RegisterPage registerPage;

    public Register() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));

        registerPage = new RegisterPage(driver);

        registerPage.clickOnMyAccount();

        registerPage.clickOnRegister();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Given("User navigates to register page")
    public void user_navigates_to_register_page() {

    }
    @When("User enters the details into below fields")
    public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {

    }
    @And("User selects privacy policy checkbox")
    public void user_selects_privacy_policy_checkbox() {

    }
    @And("User clicks on Continue button")
    public void user_clicks_on_continue_button() {

    }
    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {

    }

}
