package web.orders.makeorders;


import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для неавторизованного пользователя")
public class MakeOrdersUnauthorizedTest extends BaseSettingsWebTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

/*    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
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

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode4"));
        cartPage.clickProductCard();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddres("Москва");
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        checkOutPage.clickBookingButton();
        thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddres("метро Автозаводская");//Перенести в чекаут
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        checkOutPage.checkVisibilityMap();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        cookiePage.reCaptchaKey();
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        mainPage.clickSiteLogo();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
    }

}
