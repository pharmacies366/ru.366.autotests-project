package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Оформление заказа доставкой")
@DisplayName("Оформление заказа доставкой")
public class DeliveryOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        pageActions.reloadPage();
        //mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
       // pageActions.waitPageLoad();
        mobileMainPage.clickClosePopUp();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickDeliveryMethod();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("username"));
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        //mobileSberPage.clickOnSubmitButton();
       // mobileThankForTheOrderPage.checkPaymentError();
    }

}
