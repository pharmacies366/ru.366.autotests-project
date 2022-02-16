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
public class OrderCancellationTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
    public void OrderCancellation() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber6"),
                propertiesManager.getProperty("userpass"));
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.reloadPage();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
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
        pageActions.reloadPage();
        // String orderNumber = mobileThankForTheOrderPage.savingOrderNumber();
        mobileHeaderBlock.clickBurgerButton();
        mobileMyOrdersPage.clickClosePopUp();
        mobileHeaderBlock.clickToPersonalAccount();
        mobileHeaderBlock.clickMyOrders();
        //Assert.assertEquals(MobileMyOrdersPage.getOrderNumber(), orderNumber);
        mobileMyOrdersPage.clickOrderNumber();
        mobileMyOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", mobileMyOrdersPage.getOrderStatus());
    }
}
