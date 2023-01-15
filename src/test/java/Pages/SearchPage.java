package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class SearchPage {

    WebDriver driver;

    @FindBy(name = "search")
    private WebElement inputSearch;

    @FindBy(css = "button[class*='btn-default']")
    private WebElement searchBtn;

    @FindBy(linkText = "HP LP3065")
    private WebElement searchResult;

    @FindBy(xpath = "//*[text() = 'There is no product that matches the search criteria.']")
    public WebElement noSearchResult;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setInputSearch(String searchKeyword) {
        this.inputSearch.sendKeys(searchKeyword);
    }

    public void clickOnSearchBtn() {
        this.searchBtn.click();
    }

    public String verifySearchResultText() {
        String searchResultText = this.searchResult.getText();
        return searchResultText;
    }

    public String verifyNoSearchResultText() {
        String noSarchResultText = this.noSearchResult.getText();
        return noSarchResultText;
    }
}