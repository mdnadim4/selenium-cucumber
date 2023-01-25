package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://tutorialsninja.com/demo/index.php?route=account/register
public class RegisterPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLink;

    @FindBy(linkText = "Register")
    private WebElement linkRegister;

    @FindBy(id = "input-firstname")
    private WebElement inputFirstname;

    @FindBy(id = "input-lastname")
    private WebElement inputLastname;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-telephone")
    private WebElement inputTelephone;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "input-confirm")
    private WebElement inputConfirm;

    @FindBy(name = "newsletter")
    private WebElement inputNewsletter;

    @FindBy(name = "agree")
    private WebElement agreeCheckbox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement warningMsg;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    private WebElement privacyWarningMsg;

    @FindBy(css = "div[id='content'] h1")
    private WebElement registerSuccessMsg;

    @FindBy(xpath = "//*[text() = 'First Name must be between 1 and 32 characters!']")
    private WebElement firstNameAlertMsg;

    @FindBy(xpath = "//*[text() = 'Last Name must be between 1 and 32 characters!']")
    private WebElement lastNameAlertMsg;

    @FindBy(xpath = "//*[text() = 'E-Mail Address does not appear to be valid!']")
    private WebElement emailAlertMsg;

    @FindBy(xpath = "//*[text() = 'Telephone must be between 3 and 32 characters!']")
    private WebElement telephoneAlertMsg;

    @FindBy(xpath = "//*[text() = 'Password must be between 4 and 20 characters!']")
    private WebElement passwordAlertMsg;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount() {
        this.myAccountLink.click();
    }
    public void clickOnRegister() {
        this.linkRegister.click();
    }
    public void setInputFirstname(String firstName) {
        this.inputFirstname.sendKeys(firstName);
    }
    public void setInputLastname(String lastName) {
        this.inputLastname.sendKeys(lastName);
    }
    public void setInputEmail(String emailAddress) {
        this.inputEmail.sendKeys(emailAddress);
    }
    public void setInputTelephone(String telephone) {
        this.inputTelephone.sendKeys(telephone);
    }
    public void setInputPassword(String password) {
        this.inputPassword.sendKeys(password);
    }
    public void setInputConfirm(String conPassword) {
        this.inputConfirm.sendKeys(conPassword);
    }
    public void clickOnNewsletter() {
        this.inputNewsletter.click();
    }
    public void clickOnAgreeCheckbox() {
        this.agreeCheckbox.click();
    }
    public void clickOnContinueBtn() {
        this.continueBtn.click();
    }
    public String getRegisterSuccessMsg() {
        String registerSuccessMsgText = this.registerSuccessMsg.getText();
        return registerSuccessMsgText;
    }
    public String getWarningMsg() {
        String warningMsgtext = this.warningMsg.getText();
        return warningMsgtext;
    }
    public String getPrivacyAlertMsg() {
        String privacyAlertMsgText = this.privacyWarningMsg.getText();
        return privacyAlertMsgText;
    }
    public String getFirstnameAlertMsg() {
        String firstnameAlertMsgText = this.firstNameAlertMsg.getText();
        return firstnameAlertMsgText;
    }
    public String getLastnameAlertMsg() {
        String lastnameAlertMsgText = this.lastNameAlertMsg.getText();
        return lastnameAlertMsgText;
    }
    public String getEmailAlertMsg() {
        String emailAlertMsgText = this.emailAlertMsg.getText();
        return emailAlertMsgText;
    }
    public String getTelephoneAlertMsg() {
        String telephoneAlertMsgText = this.telephoneAlertMsg.getText();
        return telephoneAlertMsgText;
    }
    public String getPasswordAlertMsg() {
        String passwordAlertMsgText = this.passwordAlertMsg.getText();
        return passwordAlertMsgText;
    }


}