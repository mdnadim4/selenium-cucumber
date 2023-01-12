package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {

    WebDriver driver;
    public Properties prop;

    public Base() {
        prop = new Properties();
        File file = new File("Config/config.properties");
        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowserAndUrl(String browserName) {

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
        driver.get(prop.getProperty("url"));

        return driver;

    }

}
