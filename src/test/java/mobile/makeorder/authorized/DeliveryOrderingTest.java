package mobile.makeorder.authorized;
//Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами


/*
package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление заказа доставкой на сайте 36.6")
@DisplayName("Оформление заказа доставкой")
public class DeliveryOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Оформление заказа доставкой. Авторизованный пользователь")
    @Test
    public void delivery() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber1"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkCartQuantity();
        mobileMainPage.clickSiteLogo();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        mobileCheckOutPage.clickMakeOrder();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        mobileSberPage.clickOnSubmitButton();
        mobileThankForTheOrderPage.checkPaymentError();
    }

}

*/
