package web.front;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story("Проверка суммы 2-х товаров в корзине")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class VariableSampleTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void test() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        productCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        productCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }
}



