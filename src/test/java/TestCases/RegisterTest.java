package TestCases;

import Base.Base;
import Pages.RegisterPage;
import Utilities.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterTest extends Base {

    WebDriver driver;
    RegisterPage registerPage;

    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    public RegisterTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        log.info("Browser & Url initialize");
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));

        log.info("Driver initialize");
        registerPage = new RegisterPage(driver);

        log.info("Click on MyAccount");
        registerPage.clickOnMyAccount();

        log.info("Click on Register");
        registerPage.clickOnRegister();
    }

    @AfterMethod
    public void tearDown() {
        log.info("Browser close");
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyRegisterWithRequiredFields() {
        log.info("Enter the firstname");
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));

        log.info("Enter the lastname");
        registerPage.setInputLastname(dataProp.getProperty("lastName"));

        log.info("Enter the email");
        registerPage.setInputEmail(Utils.generateEmail());

        log.info("Enter the telephone");
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));

        log.info("Enter valid password");
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));

        log.info("Enter valid confirm password");
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));

        log.info("Click on Agree Checkbox");
        registerPage.clickOnAgreeCheckbox();

        log.info("Click on continue button");
        registerPage.clickOnContinueBtn();

        String registerSuccessMsg = registerPage.getRegisterSuccessMsg();
        log.info("Assert title heading");
        Assert.assertTrue(registerSuccessMsg.contains("Your Account Has Been Created!"), "Register success message is not match");
    }

    @Test (priority = 2)
    public void verifyRegisterWithAllFields() throws InterruptedException {
        log.info("Enter the firstname");
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));

        log.info("Enter the lastname");
        registerPage.setInputLastname(dataProp.getProperty("lastName"));

        log.info("Enter the email");
        registerPage.setInputEmail(Utils.generateEmail());

        log.info("Enter the telephone");
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));

        log.info("Enter the valid password");
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));

        log.info("Enter the valid confirm password");
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));

        log.info("Click on Newsletter");
        registerPage.clickOnNewsletter();

        log.info("Click on Agree Checkbox");
        registerPage.clickOnAgreeCheckbox();

        log.info("Click on continue button");
        registerPage.clickOnContinueBtn();

        String registerSuccessMsg = registerPage.getRegisterSuccessMsg();
        log.info("Assert title heading");
        Assert.assertTrue(registerSuccessMsg.contains("Your Account Has Been Created!"), "Register success message is not match");
    }

    @Test (priority = 3)
    public void verifyRegWithExistingEmailAddress() {
        log.info("Enter the firstname");
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));

        log.info("Enter the lastname");
        registerPage.setInputLastname(dataProp.getProperty("lastName"));

        log.info("Enter the duplicate email");
        registerPage.setInputEmail(dataProp.getProperty("existingEmail"));

        log.info("Enter the telephone");
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));

        log.info("Enter the valid password");
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));

        log.info("Enter the valid confirm password");
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));

        log.info("Enter the Newsletter");
        registerPage.clickOnNewsletter();

        log.info("Enter the Agree Checkbox");
        registerPage.clickOnAgreeCheckbox();

        log.info("Click on continue button");
        registerPage.clickOnContinueBtn();

        String warningMsg = registerPage.getWarningMsg();
        log.info("Assert warning message");
        Assert.assertTrue(warningMsg.contains("Warning: E-Mail Address is already registered!"), "Warning message is not displaying");
    }

    @Test (priority = 4)
    public void verifyRegisterWithEmptyData() {
        log.info("Enter empty data on firstname");
        registerPage.setInputFirstname("");

        log.info("Enter empty data on lastname");
        registerPage.setInputLastname("");

        log.info("Enter empty data on email");
        registerPage.setInputEmail("");

        log.info("Enter empty data on telephone");
        registerPage.setInputTelephone("");

        log.info("Enter empty data on password");
        registerPage.setInputPassword("");

        log.info("Enter empty data on confirm password");
        registerPage.setInputConfirm("");

        log.info("Click on continue button");
        registerPage.clickOnContinueBtn();

        String privacyWarningMsg = registerPage.getPrivacyAlertMsg();
        log.info("Assert privacy warning message");
        Assert.assertTrue(privacyWarningMsg.contains("Warning: You must agree to the Privacy Policy!"), "Privacy warning message is not displaying");

        String firstnameWarningMsg = registerPage.getFirstnameAlertMsg();
        log.info("Assert firstname warning message");
        Assert.assertTrue(firstnameWarningMsg.contains("First Name must be between 1 and 32 characters!"), "First name warning message is not displaying");

        String lastnameWarningMsg = registerPage.getLastnameAlertMsg();
        log.info("Assert lastname warning message");
        Assert.assertTrue(lastnameWarningMsg.contains("Last Name must be between 1 and 32 characters!"), "Last name warning message is not displaying");

        String emailWarningMsg = registerPage.getEmailAlertMsg();
        log.info("Assert email address warning message");
        Assert.assertTrue(emailWarningMsg.contains("E-Mail Address does not appear to be valid!"), "Email address warning message is not displaying");

        String telephoneWarningMsg = registerPage.getTelephoneAlertMsg();
        log.info("Assert telephone warning message");
        Assert.assertTrue(telephoneWarningMsg.contains("Telephone must be between 3 and 32 characters!"), "Telephone warning message is not displaying");

        String passwordWarningMsg = registerPage.getPasswordAlertMsg();
        log.info("Assert password warning message");
        Assert.assertTrue(passwordWarningMsg.contains("Password must be between 4 and 20 characters!"), "Password warning message is not displaying");
    }

}
