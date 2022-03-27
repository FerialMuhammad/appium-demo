package screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.WaitStrategies;

public class SelectLanguageScreen {
    AppiumDriver driver;

    public SelectLanguageScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public void selectLanguage(String lang){
        String xpath;
        switch(lang){
            case "en":
                xpath = "//android.view.ViewGroup[@content-desc=\"en\"]";
                break;
            case "ar":
                xpath = "//android.view.ViewGroup[@content-desc=\"ar\"]";
                break;
            default:
                throw new NoSuchElementException(lang);
        }
        WaitStrategies.waitTillElementPresent(driver, By.xpath(xpath));
        driver.findElement(By.xpath(xpath)).click();
    }

    public IntroScreen clickContinue(){
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Continue\"]/android.view.ViewGroup").click();
        return new IntroScreen(driver);
    }
}
