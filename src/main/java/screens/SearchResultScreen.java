package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.WaitStrategies;

public class SearchResultScreen {
    AppiumDriver driver;

    public SearchResultScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public void addProductToCart(){
        By addToCartButton = By.xpath("//android.view.ViewGroup[@content-desc=\"Add to cart\"]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, addToCartButton);
        driver.findElement(addToCartButton).click();
    }
    public String getNumberOfItems(){
        By purchasedNumber = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup" +
                "/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver,purchasedNumber);
        return driver.findElement(purchasedNumber).getText();
    }
}
