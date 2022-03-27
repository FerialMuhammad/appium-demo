package base;

import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;
import utils.LoadProperties;

public class AddToCartTest extends BaseTest{

    @Test
    public void addProductToCart(){
        SelectLanguageScreen selectLanguageScreen = new SelectLanguageScreen(driver);
        selectLanguageScreen.selectLanguage("en");
        IntroScreen introScreen = selectLanguageScreen.clickContinue();
        LoginScreen loginScreen = introScreen.goToLogin();
        loginScreen.enterMobileNumber(LoadProperties.loadProperty("phone.number"));
        loginScreen.enterPassword(LoadProperties.loadProperty("password"));
        LandingScreen landingScreen = loginScreen.clickLogin();
        landingScreen.grantLocationAccess();
        landingScreen.selectDeliveryDay("Tomorrow");
        SetLocationScreen setLocationScreen = landingScreen.clickStart();
        HomeScreen homeScreen = setLocationScreen.setLocation();
        homeScreen.selectDeliveryDay("Tomorrow");
        homeScreen.clickStart();
        SearchScreen searchScreen = homeScreen.goToSearch();
        searchScreen.enterSearchKeyword("pasta");
        SearchResultScreen searchResultScreen = searchScreen.getAllResults();
        searchResultScreen.addProductToCart();
        String addedItems = searchResultScreen.getNumberOfItems();
        Assert.assertEquals(addedItems,"1","Actual added number is " + addedItems);
    }
}
