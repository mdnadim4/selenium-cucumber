package Base;

import Utilities.Utils;
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
    public static Properties prop;
    public Properties dataProp;

    public Base() {
        prop = new Properties();
        dataProp = new Properties();
        File file = new File("src/test/java/Config/config.properties");
        File dataFile = new File("src/test/java/TestData/data.properties");

        try {
            FileInputStream dataFis = new FileInputStream(dataFile);
            dataProp.load(dataFis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream(file);
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowserAndUrl(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIME));
        driver.get(prop.getProperty("url"));

        return driver;

    }

}
