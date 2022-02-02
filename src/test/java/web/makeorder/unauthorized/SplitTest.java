package web.makeorder.unauthorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Оформление сплит заказа")
@DisplayName("Оформление сплит заказа")
public class SplitTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    //Данный тест ещё дублирует проверку на недоступность одного из товаров в корзине
    public void split() {
        mainPage.clickClosePopUp();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.waitPageLoad();
        cartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        mainPage.setSearchInput(propertiesManager.getProperty("productcode2"));
        pageActions.waitPageLoad();
        cartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        cartPage.clickToCartButton();
        cartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        checkOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        checkOutPage.clickSelectApteka();
        checkOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        checkOutPage.getAvailabilityAndChooseThisPharmacy();
        checkOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
    }



}
