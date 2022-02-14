package web.orders.cancellation;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Отмена заказа на сайте 36.6")
@DisplayName("Отмена созданного заказа")
public class OrderCancellationTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
    public void OrderCancellation() {
        mainPage.clickClosePopUp();
        topPanelPage.clickToLoginIcon();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
       // String orderNumber = thankForTheOrderPage.savingOrderNumber();
        pageActions.reloadPage();
        topPanelPage.clickToPersonalAccount();
        topPanelPage.clickMyOrders();
        pageActions.reloadPage();
        //Assert.assertEquals(myOrdersPage.getOrderNumber(), orderNumber);
        myOrdersPage.clickOrderNumber();
        myOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", myOrdersPage.getOrderStatus());
    }

}
