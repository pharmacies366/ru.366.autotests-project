
package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Покупка в 1 клик")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsWebTests {

    @DisplayName("Аавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mainPage.clickClosePopUp();
        cookiePage.cookieAuthorization();
        cookiePage.reCaptchaKey();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickProductCard();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddres("Москва");
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        checkOutPage.clickBookingButton();// капча
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
        cookiePage.deleteAllCookie();
    }


}

