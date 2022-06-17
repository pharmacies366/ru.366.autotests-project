package web.orders.finish;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Проверка создания заказа на сайте 36.6")
@DisplayName("Проверка создания заказа")
@Tag("Web")
@Tag("Regression")
public class CheckFinishOrderWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет информацию по заказу: Адрес аптеки, код заказа")
    @Test
    public void OrderCancellation() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber6"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        cartPage.clickAddCartButton();
        headerBlock.clickToCartButton();
        cartPage.clickToMakeOrder();
        checkOutPage.clickSelectApteka();
        checkOutPage.setInputSearchAddres("метро Фили");
        checkOutPage.checkVisibilityMap();
        checkOutPage.clickChangeAptekaList();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
       // checkOutPage.clickMakeOrder();
       // thankForTheOrderPage.checkSuccessMessage();
      //  thankForTheOrderPage.checkOrderNumberWithAddress();

    }
}
