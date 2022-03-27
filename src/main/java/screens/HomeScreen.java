package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.WaitStrategies;

public class HomeScreen {
    AppiumDriver driver;

    public HomeScreen(AppiumDriver driver) {
        this.driver = driver;
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
    public void clickStart(){
        By startButton = By.xpath("//android.view.ViewGroup[@content-desc=\"start_btn\"]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, startButton);
        driver.findElement(startButton).click();
    }
    public SearchScreen goToSearch(){
        By searchButton = By.xpath("(//android.view.ViewGroup[@content-desc=\"Home\"])[2]/android.widget.ImageView");
        WaitStrategies.waitTillElementPresent(driver, searchButton);
        driver.findElement(searchButton).click();
        return new SearchScreen(driver);
    }
}
