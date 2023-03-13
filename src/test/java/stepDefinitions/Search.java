package stepDefinitions;

import Base.Base;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Search extends Base {

    WebDriver driver;
    SearchPage searchPage;
    Logger log = LogManager.getLogger(Search.class.getName());

    public Search() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));

        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Given("User navigates to home page")
    public void user_navigates_to_home_page() {

    }
    @When("User enters valid product {string} into search input field")
    public void user_enters_valid_product_into_search_input_field(String string) {

    }
    @And("User clicks on search button")
    public void user_clicks_on_search_button() {

    }
    @Then("User should get valid product displayed in search result")
    public void user_should_get_valid_product_displayed_in_search_result() {

    }
}
