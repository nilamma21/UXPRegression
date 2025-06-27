package lasvegasmarket_PROD;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import resources.ExtendReporterNG;
import resources.base;

public class TestListeners extends base implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtendReporterNG.getReportObject();

    @Override
    public void onFinish(ITestContext arg0) {
        extent.flush();
    }

    @Override
    public void onStart(ITestContext arg0) {
        String testMethodName = arg0.getName().toString().trim();
        System.out.println(testMethodName + " Started");
        File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots/");
        if (screenshotsDir.exists()) {
            try {
    FileUtils.deleteDirectory(screenshotsDir);
   } catch (IOException e) {
    e.printStackTrace();
   }
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // Not implemented
    }

    @Override
    public void onTestFailure(ITestResult arg0) {
        String testMethodName = arg0.getName().toString().trim();
        test.fail(arg0.getThrowable());

        // Get WebDriver from test class
        Object testClass = arg0.getInstance();
        if (testClass instanceof base) {
            base baseTest = (base) testClass;
            WebDriver driver = baseTest.driver;
            if (driver != null) {
                try {
                    String screenshotPath = baseTest.capture(testMethodName);
                    // Attach screenshot to Extent Report
                    test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                    System.out.println("FAILED- " + testMethodName + ": Screenshot captured at " + screenshotPath);
                } catch (IOException e) {
                    test.fail("Failed to capture screenshot: " + e.getMessage());
                    System.out.println("FAILED- " + testMethodName + ": Error capturing screenshot - " + e.getMessage());
                }
            } else {
                test.fail("WebDriver is null, cannot capture screenshot.");
                System.out.println("FAILED- " + testMethodName + ": WebDriver is null.");
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {
        String testMethodName = arg0.getName().toString().trim();
        System.out.println("SKIPPED- " + testMethodName);
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestStart(ITestResult arg0) {
        test = extent.createTest(arg0.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        String testMethodName = arg0.getName().toString().trim();
        System.out.println("PASSED- " + testMethodName);
        test.log(Status.PASS, "Test Passed");
    }
}
