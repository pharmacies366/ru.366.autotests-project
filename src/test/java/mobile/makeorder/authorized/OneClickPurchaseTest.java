/*
package mobile.makeorder.authorized;

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
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        pageActions.reloadPage();
        mobileCartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickBookingButton();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
*/
