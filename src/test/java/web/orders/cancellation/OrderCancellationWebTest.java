package web.orders.cancellation;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature(value = "Web")
@Story(value = "Отмена заказа на сайте 36.6")
@DisplayName("Отмена созданного заказа")
public class OrderCancellationWebTest extends BaseSettingsWebTests {

/*    @DisplayName("Пользователь отменяет созданный заказ")
    @Test
    public void orderCancellation() {
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.сlickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        thankForTheOrderPage.checkSuccessMessage();
        pageActions.reloadPage();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickMyOrders();
        pageActions.staticWait(5000);
        pageActions.reloadPage();
        myOrdersPage.clickOrderNumber();
        myOrdersPage.clickCancelNumber();
        Assert.assertEquals("Отменен", myOrdersPage.getOrderStatus());
    }*/

}
