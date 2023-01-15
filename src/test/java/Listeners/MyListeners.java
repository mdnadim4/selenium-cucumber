package Listeners;

import Utilities.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {

    ExtentReports extentReport;
    ExtentTest extentTest;
    WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReporter.generateExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getName();
        extentTest = extentReport.createTest(testName);
        extentTest.log(Status.INFO, testName + " started executing");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.PASS, testName + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "./Screenshots/" + testName + ".png";

        try {
            FileHandler.copy(src, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentTest.addScreenCaptureFromPath(dest);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, testName + " got failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.SKIP, testName + " got skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        try {
            Desktop.getDesktop().browse(new File("Reports/ExtentReport.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
