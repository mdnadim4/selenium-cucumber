package TestCases;

import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browserName = "chrome";

        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equals("safari")) {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']/span[.='My Account']")).click();
        driver.findElement(By.linkText("TestCases.Login")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyValidLogin() {

        driver.findElement(By.id("input-email")).sendKeys("test900@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String url = driver.getCurrentUrl();
        String myAccount = driver.findElement(By.xpath("//div[@id='content']/h2[.='My Account']")).getText();

        // URL Assertion
        Assert.assertTrue(url.contains("/account"), "Page url is not match");

        // Verify My Account Title
        Assert.assertTrue(myAccount.contains("My Account"), "My account title content is not match");

    }

    @Test (priority = 2)
    public void verifyInvalidLogin() {

        driver.findElement(By.id("input-email")).sendKeys("test900"+ Utils.generateTimeStamp() +"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test123456");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        boolean warningMsgElement = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
        String warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

        // Verify Warning message visibility
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority = 3)
    public void verifyInvalidEmailAndValidPassword() {

        driver.findElement(By.id("input-email")).sendKeys("test900"+ Utils.generateTimeStamp() +"@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        boolean warningMsgElement = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
        String warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

        // Verify Warning message visibility
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority =4)
    public void verifyValidEmailAndInvalidPassword() {

        driver.findElement(By.id("input-email")).sendKeys("test900@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test123456");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        boolean warningMsgElement = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
        String warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

        // Verify Warning message visibility
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority = 5)
    public void verifyEmptyEmailAndPassword() {

        driver.findElement(By.id("input-email")).sendKeys("");
        driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        boolean warningMsgElement = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).isDisplayed();
        String warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

        // Verify Warning message visibility
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

}
