import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("http://www.tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//div[@id='top-links']//a[@title='My Account']/span[.='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyValidLogin() {

        driver.findElement(By.id("input-email")).sendKeys("test900@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String url = driver.getCurrentUrl();
        String myAccount = driver.findElement(By.xpath("//div[@id='content']/h2[.='My Account']")).getText();

        // URL Assertion
        Assert.assertTrue(url.contains("/account"), "Page url is not match");

        // Verify My Account Title
        Assert.assertTrue(myAccount.contains(("My Account")), "My account title content is not match");

    }

    @Test
    public void verifyInvalidLogin() {

        driver.findElement(By.id("input-email")).sendKeys("test9000@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test123456");
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String warningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();

        // Verify Warning Message
        Assert.assertTrue(warningMsg.contains(("Warning: No match for E-Mail Address and/or Password.")), "Expected Warning message is not displayed");

    }



}
