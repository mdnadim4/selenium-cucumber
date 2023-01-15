package Utilities;

import Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public class ExtentReporter extends Base {

    public static ExtentReports generateExtentReport() {

        ExtentReports extentReport = new ExtentReports();

        File extentReportFile = new File("src/test/java/Reports/ExtentReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("TN Automation Test Report");

        extentReport.attachReporter(sparkReporter);

        extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
        extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
        extentReport.setSystemInfo("Email", prop.getProperty("email"));
        extentReport.setSystemInfo("OS Name", System.getProperty("os.version"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));


        return extentReport;
    }

}
