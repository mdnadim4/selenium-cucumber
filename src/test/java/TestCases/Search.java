package TestCases;

import Base.Base;
import Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search extends Base {

    WebDriver driver;
    SearchPage searchPage;

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

    @Test (priority = 1)
    public void verifySearchWithValidProduct() {
        searchPage.setInputSearch(dataProp.getProperty("validProduct"));
        searchPage.clickOnSearchBtn();

        // Verify search result
        String searchResult = searchPage.verifySearchResultText();
        Assert.assertTrue(searchResult.contains("HP LP3065"), "Product title is not match");
    }

    @Test (priority = 2)
    public void verifySearchWithInvalidProduct() {
        searchPage.setInputSearch(dataProp.getProperty("invalidProduct"));
        searchPage.clickOnSearchBtn();

        // Verify no search result
        String noSearchResult = searchPage.verifyNoSearchResultText();
        Assert.assertTrue(noSearchResult.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

    @Test (priority = 3)
    public void verifySearchWithEmptyData() {
        searchPage.setInputSearch("");
        searchPage.clickOnSearchBtn();

        // Verify empty search result
        String noSearchResult = searchPage.verifyNoSearchResultText();
        Assert.assertTrue(noSearchResult.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

}
