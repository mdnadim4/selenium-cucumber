package TestCases;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search extends Base {

    WebDriver driver;

    public Search() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void verifySearchWithValidProduct() {
        driver.findElement(By.name("search")).sendKeys("HP");
        driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();

        String productTitle = driver.findElement(By.linkText("HP LP3065")).getText();
        Assert.assertTrue(productTitle.contains("HP LP3065"), "Product title is not match");
    }

    @Test (priority = 2)
    public void verifySearchWithInvalidProduct() {
        driver.findElement(By.name("search")).sendKeys("Dell");
        driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();

        String actualMsg = driver.findElement(By.cssSelector("div#content > p:nth-of-type(2)")).getText();
        Assert.assertTrue(actualMsg.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

    @Test (priority = 3)
    public void verifySearchWithEmptyData() {
        driver.findElement(By.name("search")).sendKeys("");
        driver.findElement(By.cssSelector(".btn.btn-default.btn-lg")).click();

        String actualMsg = driver.findElement(By.cssSelector("div#content > p:nth-of-type(2)")).getText();
        Assert.assertTrue(actualMsg.contains("There is no product that matches the search criteria."), "Product search message is not display");
    }

}
