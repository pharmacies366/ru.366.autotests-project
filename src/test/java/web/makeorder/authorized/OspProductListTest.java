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
        cookiePage.cookieAuthorization();
        pageActions.reloadPage();
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.clickSiteLogo();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
        cookiePage.deleteAllCookie();
    }
}
