package TestCases;

import Base.Base;
import Pages.SearchPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends Base {

    WebDriver driver;
    SearchPage searchPage;
    Logger log = LogManager.getLogger(SearchTest.class.getName());

    public SearchTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        log.info("Browser & Url initialize");
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));
        log.info("Driver initialize");
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Browser close");
        driver.quit();
    }

    @Test (priority = 1)
    public void verifySearchWithValidProduct() {
        log.info("Enter valid product");
        searchPage.setInputSearch(dataProp.getProperty("validProduct"));
        log.info("Click on Search button");
        searchPage.clickOnSearchBtn();

        String searchResult = searchPage.verifySearchResultText();
        log.info("Verify the search result");
        Assert.assertTrue(searchResult.contains("HP LP3065"), "Product title is not match");
    }

    @Test (priority = 2)
    public void verifySearchWithInvalidProduct() {
        log.info("Enter invalid product");
        searchPage.setInputSearch(dataProp.getProperty("invalidProduct"));
        log.info("Click on Search button");
        searchPage.clickOnSearchBtn();

        String noSearchResult = searchPage.verifyNoSearchResultText();
        log.info("Verify no search result");
        Assert.assertTrue(noSearchResult.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

    @Test (priority = 3)
    public void verifySearchWithEmptyData() {
        log.info("Search empty product");
        searchPage.setInputSearch("");
        log.info("Click on Search button");
        searchPage.clickOnSearchBtn();

        String noSearchResult = searchPage.verifyNoSearchResultText();
        log.info("Verify empty search result");
        Assert.assertTrue(noSearchResult.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

}
