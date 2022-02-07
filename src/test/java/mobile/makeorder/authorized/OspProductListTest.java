package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Пользователь покупает товар со страницы ОСП")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileCookiePage.cookieAuthorization();
        mobileCookiePage.reCaptchaKey();
        pageActions.reloadPage();
        pageActions.waitPageLoad();
        mobileCartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mobileMainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        mobileOspPage.clickShowAll();
        pageActions.waitPageLoad();
        mobileOspPage.clickProductName();
        pageActions.waitPageLoad();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickSelectApteka();
        pageActions.waitPageLoad();
        mobileCheckOutPage.setInputSearchAddres("Москва");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileCheckOutPage.ckickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }
}
