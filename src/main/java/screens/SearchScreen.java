package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import utils.WaitStrategies;

public class SearchScreen {
    AppiumDriver driver;

    public SearchScreen(AppiumDriver driver) {
        this.driver = driver;
    }
    public void enterSearchKeyword(String keyword){
        By searchField = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText");
        WaitStrategies.waitTillElementPresent(driver, searchField);
        driver.findElement(searchField).sendKeys(keyword);
        driver.findElement(searchField).click();
    }
    public SearchResultScreen getAllResults(){
        driver.hideKeyboard();
        By searchResultButton = By.xpath("/hierarchy/android.widget.FrameLayout" +
                "/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout" +
                "/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout" +
                "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                "/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.TextView");
        WaitStrategies.waitTillElementPresent(driver, searchResultButton);
        driver.findElement(searchResultButton).click();
        return new SearchResultScreen(driver);
    }
}
