package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Покупка в 1 клик")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsMobileTests {


    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        pageActions.waitPageLoad();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickBuyOneClick();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCheckOutPage.clickBookingButton();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
