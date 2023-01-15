package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://tutorialsninja.com/demo/index.php?route=account/login
public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountLink;

    @FindBy(linkText = "Login")
    private WebElement linkLogin;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitBtn;

    @FindBy(linkText = "Edit your account information")
    private WebElement editAccountInfo;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    public WebElement warningMsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccount() {
        this.myAccountLink.click();
    }

    public void clickOnLogin() {
        this.linkLogin.click();
    }

    public void setInputEmail(String emailAddress) {
        this.inputEmail.sendKeys(emailAddress);
    }

    public void setInputPassword(String password) {
        this.inputPassword.sendKeys(password);
    }

    public void clickOnSubmitBtn() {
        this.submitBtn.click();
    }

    public String verifyEditAccountInfo() {
        String  editAccountInfoText = this.editAccountInfo.getText();
        return editAccountInfoText;
    }

    public boolean verifyWarningMsgDisplay() {
        Boolean display = this.warningMsg.isDisplayed();
        return display;
    }

    public String verifyWarningMsgText() {
        String warningMsgText = this.warningMsg.getText();
        return warningMsgText;
    }
}