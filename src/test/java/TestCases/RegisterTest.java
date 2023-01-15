package TestCases;

import Base.Base;
import Pages.RegisterPage;
import Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegisterTest extends Base {

    WebDriver driver;
    RegisterPage registerPage;

    public RegisterTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        driver = initializeBrowserAndUrl(prop.getProperty("browser"));
        registerPage = new RegisterPage(driver);
        registerPage.clickOnMyAccount();
        registerPage.clickOnRegister();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test (priority = 1)
    public void verifyRegisterWithRequiredFields() {
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));
        registerPage.setInputLastname(dataProp.getProperty("lastName"));
        registerPage.setInputEmail(Utils.generateEmail());
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));
        registerPage.clickOnAgreeCheckbox();
        registerPage.clickOnContinueBtn();

        // Assert title heading
        String registerSuccessMsg = registerPage.getRegisterSuccessMsg();
        Assert.assertTrue(registerSuccessMsg.contains("Your Account Has Been Created!"), "Register success message is not match");
    }

    @Test (priority = 2)
    public void verifyRegisterWithAllFields() throws InterruptedException {
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));
        registerPage.setInputLastname(dataProp.getProperty("lastName"));
        registerPage.setInputEmail(Utils.generateEmail());
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));
        registerPage.clickOnNewsletter();
        registerPage.clickOnAgreeCheckbox();
        registerPage.clickOnContinueBtn();

        // Assert title heading
        String registerSuccessMsg = registerPage.getRegisterSuccessMsg();
        Assert.assertTrue(registerSuccessMsg.contains("Your Account Has Been Created!"), "Register success message is not match");
    }

    @Test (priority = 3)
    public void verifyRegWithExistingEmailAddress() {
        registerPage.setInputFirstname(dataProp.getProperty("firstName"));
        registerPage.setInputLastname(dataProp.getProperty("lastName"));
        registerPage.setInputEmail(dataProp.getProperty("existingEmail"));
        registerPage.setInputTelephone(dataProp.getProperty("telephone"));
        registerPage.setInputPassword(dataProp.getProperty("validPassword"));
        registerPage.setInputConfirm(dataProp.getProperty("validPassword"));
        registerPage.clickOnNewsletter();
        registerPage.clickOnAgreeCheckbox();
        registerPage.clickOnContinueBtn();

        // Assert warning message
        String warningMsg = registerPage.getWarningMsg();
        Assert.assertTrue(warningMsg.contains("Warning: E-Mail Address is already registered!"), "Warning message is not displaying");
    }

    @Test (priority = 4)
    public void verifyRegisterWithEmptyData() {
        registerPage.setInputFirstname("");
        registerPage.setInputLastname("");
        registerPage.setInputEmail("");
        registerPage.setInputTelephone("");
        registerPage.setInputPassword("");
        registerPage.setInputConfirm("");
        registerPage.clickOnContinueBtn();

        // Assert privacy warning message
        String privacyWarningMsg = registerPage.getPrivacyAlertMsg();
        Assert.assertTrue(privacyWarningMsg.contains("Warning: You must agree to the Privacy Policy!"), "Privacy warning message is not displaying");

        // Assert firstname warning message
        String firstnameWarningMsg = registerPage.getFirstnameAlertMsg();
        Assert.assertTrue(firstnameWarningMsg.contains("First Name must be between 1 and 32 characters!"), "First name warning message is not displaying");

        // Assert lastname warning message
        String lastnameWarningMsg = registerPage.getLastnameAlertMsg();
        Assert.assertTrue(lastnameWarningMsg.contains("Last Name must be between 1 and 32 characters!"), "Last name warning message is not displaying");

        // Assert email address warning message
        String emailWarningMsg = registerPage.getEmailAlertMsg();
        Assert.assertTrue(emailWarningMsg.contains("E-Mail Address does not appear to be valid!"), "Email address warning message is not displaying");

        // Assert telephone warning message
        String telephoneWarningMsg = registerPage.getTelephoneAlertMsg();
        Assert.assertTrue(telephoneWarningMsg.contains("Telephone must be between 3 and 32 characters!"), "Telephone warning message is not displaying");

        // Assert password warning message
        String passwordWarningMsg = registerPage.getPasswordAlertMsg();
        Assert.assertTrue(passwordWarningMsg.contains("Password must be between 4 and 20 characters!"), "Password warning message is not displaying");
    }

}
