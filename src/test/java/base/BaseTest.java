package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utility.BrowserFactory;
import utility.Helper;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setupSuite() {
        ExtentSparkReporter extent = new ExtentSparkReporter(
                new File(System.getProperty("user.dir") + "/Reports/FreeCRM_"
                        + Helper.getCurrentDateTime() + ".html"));
        report = new ExtentReports();
        report.attachReporter(extent);
    }

    @BeforeClass
    public void setup() {
//        driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL);
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.fail("Test failed ",
                    MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test passed ",
                    MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        report.flush();
    }
}
