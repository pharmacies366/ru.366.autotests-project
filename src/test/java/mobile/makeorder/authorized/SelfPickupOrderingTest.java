package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "оформление заказа самовывозом на сайте 36.6")
@DisplayName("Оформление заказа самовывозом")
public class SelfPickupOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        
        mobileCartPage.checkCartQuantity();
        pageActions.reloadPage();
        
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        
        mobileCartPage.clickToCartButton();
        
        mobileCartPage.clickToMakeOrder();
        
        mobileCheckOutPage.clickSelectApteka();
        
        mobileProductCardPage.checkVisibilityMap();
        
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        
        mobileCheckOutPage.clickChangeAptekaList();
        
        mobileCheckOutPage.ckickSelect();
        
        mobileCheckOutPage.clickMakeOrder();
        
        mobileThankForTheOrderPage.checkSuccessMessage();
    }

}
