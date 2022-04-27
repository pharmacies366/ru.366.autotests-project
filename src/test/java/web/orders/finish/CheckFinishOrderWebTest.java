package web.orders.finish;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Проверка создания заказа на сайте 36.6")
@DisplayName("Проверка создания заказа")
public class CheckFinishOrderWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет информацию по заказу: Адрес аптеки, код заказа")
    @Test
    public void OrderCancellation() {
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickAddCartButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        // checkOutPage.clickMakeOrder();
        // thankForTheOrderPage.checkSuccessMessage();
        //  thankForTheOrderPage.checkOrderNumberWithAddress();

    }
}
