package mobile.orders.cancellation;/*
package mobile.orders.cancellation;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Отмена заказа на сайте 36.6")
@DisplayName("Отмена созданного заказа")
public class OrderCancellationMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
    public void orderCancellation() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber6"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.reloadPage();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickSelectApteka();
        mobileCheckOutPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("москва");
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.ckickSelect();
        mobileCheckOutPage.clickMakeOrder();
        mobileThankForTheOrderPage.checkSuccessMessage();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        pageActions.staticWait(5000);
        mobileMainPopUpBlock.clickMyOrders();
        mobileMyOrdersPage.clickOrderNumber();
        mobileMyOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", mobileMyOrdersPage.getOrderStatus());
    }
}
*/
