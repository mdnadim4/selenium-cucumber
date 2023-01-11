package TestCases;

import Base.Base;
import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Register extends Base {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl("edge");
        driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']/span[.='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyRegisterWithRequiredFields() {
        driver.findElement(By.id("input-firstname")).sendKeys("William");
        driver.findElement(By.id("input-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("test"+Utils.generateTimeStamp()+"@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9085380500");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.id("input-confirm")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("http://tutorialsninja.com/demo/index.php?route=account/success"), "Success url is incorrect");

        String heading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertTrue(heading.contains("Your Account Has Been Created!"), "Title heading is not match");
    }

    @Test (priority = 2)
    public void verifyRegisterWithAllFields() {
        driver.findElement(By.id("input-firstname")).sendKeys("William");
        driver.findElement(By.id("input-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("test"+Utils.generateTimeStamp()+"@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9085380500");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.id("input-confirm")).sendKeys("test12345");
        driver.findElement(By.cssSelector("label:nth-of-type(1) > input[name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("http://tutorialsninja.com/demo/index.php?route=account/success"), "Success url is incorrect");

        String heading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertTrue(heading.contains("Your Account Has Been Created!"), "Title heading is not match");
    }

    @Test (priority = 3)
    public void verifyRegWithExistingEmailAddress() {
        driver.findElement(By.id("input-firstname")).sendKeys("William");
        driver.findElement(By.id("input-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("test12345@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9085380500");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.id("input-confirm")).sendKeys("test12345");
        driver.findElement(By.cssSelector("label:nth-of-type(1) > input[name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String warningMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(warningMsg.contains("Warning: E-Mail Address is already registered!"), "Warning message is not displaying");
    }

    @Test (priority = 4)
    public void verifyRegisterWithEmptyData() {
        driver.findElement(By.id("input-firstname")).sendKeys("");
        driver.findElement(By.id("input-lastname")).sendKeys("");
        driver.findElement(By.id("input-email")).sendKeys("");
        driver.findElement(By.id("input-telephone")).sendKeys("");
        driver.findElement(By.id("input-password")).sendKeys("");
        driver.findElement(By.id("input-confirm")).sendKeys("");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String privacyWarningMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
        Assert.assertTrue(privacyWarningMsg.contains("Warning: You must agree to the Privacy Policy!"), "Privacy warning message is not displaying");

        String firstnameWarningMsg = driver.findElement(By.cssSelector("div:nth-of-type(2) > .col-sm-10 > .text-danger")).getText();
        Assert.assertTrue(firstnameWarningMsg.contains("First Name must be between 1 and 32 characters!"), "First name warning message is not displaying");

        String lastnameWarningMsg = driver.findElement(By.cssSelector("div:nth-of-type(3) .text-danger")).getText();
        Assert.assertTrue(lastnameWarningMsg.contains("Last Name must be between 1 and 32 characters!"), "Last name warning message is not displaying");

        String emailWarningMsg = driver.findElement(By.cssSelector("div:nth-of-type(4) .text-danger")).getText();
        Assert.assertTrue(emailWarningMsg.contains("E-Mail Address does not appear to be valid!"), "Email address warning message is not displaying");

        String telephoneWarningMsg = driver.findElement(By.cssSelector("div:nth-of-type(5) .text-danger")).getText();
        Assert.assertTrue(telephoneWarningMsg.contains("Telephone must be between 3 and 32 characters!"), "Telephone warning message is not displaying");

        String passwordWarningMsg = driver.findElement(By.cssSelector("fieldset:nth-of-type(2) .text-danger")).getText();
        Assert.assertTrue(passwordWarningMsg.contains("Password must be between 4 and 20 characters!"), "Password warning message is not displaying");
    }

}
