package web.orders.makeorders;


import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для неавторизованного пользователя")
@Tag("Web")
@Tag("Regression")
@Tag("Smoke")
public class MakeOrdersUnauthorizedWebTest extends BaseSettingsWebTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

/*    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.waitPageLoad();
        cartPage.сlickAddCartButton();
        headerBlock.clickToCartButton();
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
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        cartPage.clickProductCard();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        productCardPage.checkVisibilityMap();
        productCardPage.setInputSearchAddress("Москва");
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        // checkOutPage.clickBookingButton();
        // thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        pageActions.waitPageLoad();
        mainPage.clickLetterN();
        ospPage.clickProductName();
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        productCardPage.setInputSearchAddress("метро Автозаводская");//Перенести в чекаут
        pageActions.waitPageLoad();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //  checkOutPage.clickMakeOrder();
        //  thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со способом получения - 'Самовывоз'")
    @Test
    public void pickup() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
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
        //  checkOutPage.clickMakeOrder();
        //  thankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        headerBlock.clickSiteLogo();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        pageActions.waitPageLoad();
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        //  checkOutPage.clickMakeOrder();
        //  thankForTheOrderPage.checkSuccessMessage();
    }

}
