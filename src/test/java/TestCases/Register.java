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

public class Register {

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
        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyRegisterWithRequiredFields() {
        driver.findElement(By.id("input-firstname")).sendKeys("William");
        driver.findElement(By.id("input-firstname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("test"+Utils.generateTimeStamp()+"@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9085380500");
        driver.findElement(By.id("input-password")).sendKeys("test12345");
        driver.findElement(By.id("input-confirm")).sendKeys("test12345");
        driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        String heading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();

        Boolean url = driver.getCurrentUrl().contains("account/success");

        Assert.assertTrue(url, "Success url is incorrect");
        Assert.assertTrue(heading.contains("Your Account Has Been Created!"), "Title heading is not match");

    }

}
