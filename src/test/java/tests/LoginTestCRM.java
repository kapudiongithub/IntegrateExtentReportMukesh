package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import utility.BrowserFactory;

public class LoginTestCRM extends BaseTest {
    WebDriver driver;

    @Test
    public void loginApp() {
//        BrowserFactory.startApplication(driver, "Chrome", "https://freecrm.com/");
        BrowserFactory.startApplication(driver, "Chrome", "https://ui.cogmento.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginToCRM("Selenium_50", "Abcd@123456");
        System.out.println(driver.getTitle());
        BrowserFactory.quitBrowser(driver);
    }

    @Test
    public void loginApp1() {
        logger = report.createTest("Login to CRM");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        logger.info("Starting Application");
//        loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
        logger.pass("Login Success");
    }

    @Test
    public void loginApp2() {
        logger = report.createTest("Logout");
        logger.fail("Logout failed");
    }
}
