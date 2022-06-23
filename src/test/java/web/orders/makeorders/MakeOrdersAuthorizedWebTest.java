package web.orders.makeorders;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для авторизованного пользователя")
@Tag("Web")
@Tag("Regression")
@Tag("Smoke")
public class MakeOrdersAuthorizedWebTest extends BaseSettingsWebTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

/*    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.waitPageLoad();
        cartPage.сlickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickDeliveryMethod();
        checkOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        checkOutPage.clickToFinalButton();
        sberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        sberPage.clickOnSubmitButton();
        thankForTheOrderPage.checkPaymentError();
    }*/

    @DisplayName("Авторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber2"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickProductCard();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddress("Москва");
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        cookiePage.reCaptchaKey();
        // checkOutPage.clickBookingButton();
        // thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Авторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        headerBlock.clickSiteLogo();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddress("метро Автозаводская");
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        // checkOutPage.clickMakeOrder();
        // thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Авторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber4"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //checkOutPage.clickMakeOrder();
    }

    @DisplayName("Авторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber5"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickAddCartButton();
        headerBlock.clickSiteLogo();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //  checkOutPage.clickMakeOrder();
        // thankForTheOrderPage.checkSuccessMessage();
    }
}
