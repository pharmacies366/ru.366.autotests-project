package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.web.MainPage;

@Feature(value = "Web")
@Story("Пользователь покупает товар со страницы ОСП")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsWebTests {

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mainPage.clickClosePopUp();
        cookiePage.cookieAuthorization();
        cookiePage.reCaptchaKey();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        mainPage.clickSiteLogo();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddres("метро Автозаводская");
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
    }
}
