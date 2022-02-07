package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Оформление заказа доставкой")
@DisplayName("Оформление заказа доставкой")
public class DeliveryOrderingTest extends BaseSettingsWebTests {

    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.authorizeWithEmailAndPassword(
                propertiesManager.getProperty("userauthphone1"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkCartQuantity();
        pageActions.waitPageLoad();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.clickDeliveryMethod();
        pageActions.waitPageLoad();
        checkOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        checkOutPage.clickToFinalButton();
        sberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        sberPage.clickOnSubmitButton();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkPaymentError();
    }

}
