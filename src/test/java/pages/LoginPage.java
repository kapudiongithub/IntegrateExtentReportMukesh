package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    public WebDriver driver;

//    @FindBy(xpath = "//input[@name='email']")
//    WebElement uname;
//    @FindBy(xpath = "//input[@name='password']")
//    WebElement pass;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button'][contains(.,'Login')]")
    WebElement loginButton;

    public LoginPage(WebDriver ldriver) {
        this.driver = ldriver;
    }

    public void loginToCRM(String usernameApplication, String passwordApplication) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        uname.sendKeys(usernameApplication);
//        pass.sendKeys(passwordApplication);
        loginButton.click();
    }
}
