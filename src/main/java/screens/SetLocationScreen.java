package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.WaitStrategies;

public class SetLocationScreen {
    AppiumDriver driver;

    public SetLocationScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public HomeScreen setLocation(){
        //driver.setLocation(new Location(29.971023882689412, 31.27502054145427, 0));
        By confirmLocationButton = By.xpath("//android.view.ViewGroup[@content-desc=\"CONFIRM LOCATION\"]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, confirmLocationButton);
        driver.findElement(confirmLocationButton).click();
        return new HomeScreen(driver);
    }
}
