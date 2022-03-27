package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.WaitStrategies;

public class LandingScreen {
    AppiumDriver driver;

    public LandingScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void grantLocationAccess(){
        try {
            By grantDialogue = By.id("com.android.permissioncontroller:id/grant_dialog");
            WaitStrategies.waitTillElementPresent(driver, grantDialogue);
            driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click();
        }
        catch (NoSuchElementException e){
        }
    }
    public void selectDeliveryDay(String day){
        String xpath;
        switch (day){
            case "Tomorrow":
                xpath = "//android.view.ViewGroup[@content-desc=\"Tomorrow_btn\"]";
                By dayButton = By.xpath(xpath);
                WaitStrategies.waitTillElementPresent(driver,dayButton);
                driver.findElement(dayButton).click();
                break;
            case "Now":
                break;
            default:
                throw new NoSuchElementException(day);
        }
    }
    public SetLocationScreen clickStart(){
        By startButton = By.xpath("//android.view.ViewGroup[@content-desc=\"start_btn\"]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, startButton);
        driver.findElement(startButton).click();
        return new SetLocationScreen(driver);
    }
}
