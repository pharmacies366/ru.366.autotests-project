package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление сплит заказа")
@DisplayName("Оформление сплит заказа")
public class SplitTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    /*Данный тест ещё дублирует проверку на недоступность одного из товаров в корзине,
            но по хорошему нужно получать эти данные из БД*/
    public void split() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCookiePage.cookieAuthorization();
        pageActions.reloadPage();
        mobileCartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileMainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.ckickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }



}
