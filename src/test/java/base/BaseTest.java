package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.LoadProperties;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    AppiumDriver driver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, LoadProperties.loadProperty("platform.name"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,LoadProperties.loadProperty("platform.version"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,LoadProperties.loadProperty("device.name"));
        caps.setCapability(AndroidMobileCapabilityType.GPS_ENABLED, true);
        caps.setCapability(MobileCapabilityType.APP,  System.getProperty("user.dir") + LoadProperties.loadProperty("app.path"));

        driver = new AndroidDriver(new URL(LoadProperties.loadProperty("url")),caps);
    }

    @AfterTest
    public void quitDriver(){
        if(null != driver){
            driver.quit();
        }
    }
}
