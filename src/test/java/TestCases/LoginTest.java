package TestCases;

import Base.Base;
import Pages.LoginPage;
import Utilities.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    WebDriver driver;
    LoginPage loginPage;
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        log.info("Browser & Url initialize");
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));

        log.info("Driver initialize");
        loginPage = new LoginPage(driver);

        log.info("Click on MyAccount");
        loginPage.clickOnMyAccount();

        log.info("Click on Login");
        loginPage.clickOnLogin();
    }

    @AfterMethod
    public void tearDown() {
        log.info("Browser close");
        driver.quit();
    }

    @Test (priority = 1, dataProvider = "validLoginData")
    public void verifyValidLogin(String email, String password) {
        log.info("Enter invalid email address");
        loginPage.setInputEmail(email);

        log.info("Enter invalid password");
        loginPage.setInputPassword(password);

        log.info("Click on Submit button");
        loginPage.clickOnSubmitBtn();

        String myAccount = loginPage.verifyEditAccountInfo();
        log.info("Verify My Account Title");
        Assert.assertTrue(myAccount.contains("Edit your account information"), "My account title content is not match");
    }

    @DataProvider(name = "validLoginData")
    public Object[][] supplyTestData() {
        Object[][] data = Utils.getTestDataFromExcel("Login");
        return data;
    }

    @Test (priority = 2)
    public void verifyInvalidLogin() {
        log.info("Enter invalid email address");
        loginPage.setInputEmail(Utils.generateEmail());

        log.info("Enter invalid password");
        loginPage.setInputPassword(dataProp.getProperty("invalidPassword"));

        log.info("Click on Submit button");
        loginPage.clickOnSubmitBtn();

        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        log.info("Verify Warning message visibility");
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        String warningMsg = loginPage.verifyWarningMsgText();
        log.info("Verify Warning message");
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority = 3)
    public void verifyInvalidEmailAndValidPassword() {
        log.info("Enter invalid email address");
        loginPage.setInputEmail(Utils.generateEmail());

        log.info("Enter valid password");
        loginPage.setInputPassword(dataProp.getProperty("validPassword"));

        log.info("Click on submit button");
        loginPage.clickOnSubmitBtn();

        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        log.info("Verify Warning message visibility");
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        String warningMsg = loginPage.verifyWarningMsgText();
        log.info("Verify Warning Message");
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");
    }

    @Test (priority =4)
    public void verifyValidEmailAndInvalidPassword() {
        log.info("Enter valid email address");
        loginPage.setInputEmail(dataProp.getProperty("validEmail"));

        log.info("Enter invalid password");
        loginPage.setInputPassword(dataProp.getProperty("invalidPassword"));

        log.info("Click on Submit button");
        loginPage.clickOnSubmitBtn();

        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        log.info("Verify Warning message visibility");
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        String warningMsg = loginPage.verifyWarningMsgText();
        log.info("Verify Warning Message");
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");
    }

    @Test (priority = 5)
    public void verifyEmptyEmailAndPassword() {
        log.info("Enter Empty Email Address");
        loginPage.setInputEmail("");

        log.info("Enter Empty Password");
        loginPage.setInputPassword("");

        log.info("Click on Submit Button");
        loginPage.clickOnSubmitBtn();

        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        log.info("Verify Warning message visibility");
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        log.info("Verify Warning Message");
        String warningMsg = loginPage.verifyWarningMsgText();
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");
    }

}
