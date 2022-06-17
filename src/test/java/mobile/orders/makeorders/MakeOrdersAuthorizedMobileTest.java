package mobile.orders.makeorders;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для авторизованного пользователя")
@Tag("Regression")
@Tag("Smoke")
@Tag("Mobile")
public class MakeOrdersAuthorizedMobileTest extends BaseSettingsMobileTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber1"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileMainPage.clickSiteLogo();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
       // mobileSberPage.clickOnSubmitButton();
       // mobileThankForTheOrderPage.checkPaymentError();
    }

    @DisplayName("Аавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber2"),
                propertiesManager.getProperty("userpass"));
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileCartPage.clickProductCard();
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.clickChangeAptekaList();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCookiePage.reCaptchaKey();
      //  mobileCheckOutPage.clickBookingButton();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber3"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileMainPage.clickSiteLogo();
        mobileMainPage.clickLetterN();
        mobileOspPage.clickShowAll();
        mobileOspPage.clickProductName();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickSelectApteka();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.setInputSearchAddres("Москва");
        mobileCheckOutPage.clickSelect();
      //  mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Авторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber4"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.reloadPage();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        mobileCheckOutPage.clickSelect();
       // mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Авторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber5"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileCartPage.сlickAddCartButton();
        mobileMainPage.clickSiteLogo();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickSelectApteka();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        mobileCheckOutPage.clickSelect();
      //  mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }
}
