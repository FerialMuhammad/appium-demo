package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import utils.WaitStrategies;

public class LoginScreen {
    AppiumDriver driver;

    public LoginScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public void enterMobileNumber(String number){
        By mobileField = By.xpath("//android.widget.EditText[@content-desc=\"phoneNumb_cell\"]");
        WaitStrategies.waitTillElementPresent(driver,mobileField);
        driver.findElementByAccessibilityId("phoneNumb_cell").sendKeys(number);
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"continue_btn\"]/android.widget.TextView").click();
    }

    public void enterPassword(String password){
        By passwordField = By.xpath("//android.widget.EditText[@content-desc=\"password_pwd\"]");
        WaitStrategies.waitTillElementPresent(driver, passwordField);
        driver.findElementByAccessibilityId("password_pwd").sendKeys(password);
    }
    public LandingScreen clickLogin(){
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"login_btn\"]/android.widget.TextView").click();
        return new LandingScreen(driver);
    }
}
