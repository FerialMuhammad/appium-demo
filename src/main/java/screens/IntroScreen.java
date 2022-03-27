package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitStrategies;

public class IntroScreen {
    AppiumDriver driver;

    public IntroScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public LoginScreen goToLogin(){
        By loginButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Login_btn\"]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, loginButton);
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }
}
