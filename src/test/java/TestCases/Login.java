package TestCases;

import Base.Base;
import Pages.LoginPage;
import Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test (priority = 1, dataProvider = "validLoginData")
    public void verifyValidLogin(String email, String password) {

        loginPage.setInputEmail(email);
        loginPage.setInputPassword(password);
        loginPage.clickOnSubmitBtn();

        // Verify My Account Title
        String myAccount = loginPage.verifyEditAccountInfo();
        Assert.assertTrue(myAccount.contains("Edit your account information"), "My account title content is not match");

    }

    @DataProvider(name = "validLoginData")
    public Object[][] supplyTestData() {
        Object[][] data = Utils.getTestDataFromExcel("Login");
        return data;
    }

    @Test (priority = 2)
    public void verifyInvalidLogin() {
        loginPage.setInputEmail(Utils.generateEmail());
        loginPage.setInputPassword(dataProp.getProperty("invalidPassword"));
        loginPage.clickOnSubmitBtn();

        // Verify Warning message visibility
        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        String warningMsg = loginPage.verifyWarningMsgText();
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority = 3)
    public void verifyInvalidEmailAndValidPassword() {
        loginPage.setInputEmail(Utils.generateEmail());
        loginPage.setInputPassword(dataProp.getProperty("validPassword"));
        loginPage.clickOnSubmitBtn();

        // Verify Warning message visibility
        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        String warningMsg = loginPage.verifyWarningMsgText();
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority =4)
    public void verifyValidEmailAndInvalidPassword() {
        loginPage.setInputEmail(dataProp.getProperty("validEmail"));
        loginPage.setInputPassword(dataProp.getProperty("invalidPassword"));
        loginPage.clickOnSubmitBtn();

        // Verify Warning message visibility
        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        String warningMsg = loginPage.verifyWarningMsgText();
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

    @Test (priority = 5)
    public void verifyEmptyEmailAndPassword() {
        loginPage.setInputEmail("");
        loginPage.setInputPassword("");
        loginPage.clickOnSubmitBtn();

        // Verify Warning message visibility
        boolean warningMsgElement = loginPage.verifyWarningMsgDisplay();
        Assert.assertTrue(warningMsgElement, "Warning message element is not displayed");

        // Verify Warning Message
        String warningMsg = loginPage.verifyWarningMsgText();
        Assert.assertTrue(warningMsg.contains("Warning: No match for E-Mail Address and/or Password."), "Expected Warning message is not correct");

    }

}
