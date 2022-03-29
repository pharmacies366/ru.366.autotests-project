package web.orders.makeorders;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для авторизованного пользователя")
public class MakeOrdersAuthorizedWebTest extends BaseSettingsWebTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

/*    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber1"),
                propertiesManager.getProperty("userpass"));
                pageActions.waitPageLoad();
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
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber2"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber3"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber4"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber5"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
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
