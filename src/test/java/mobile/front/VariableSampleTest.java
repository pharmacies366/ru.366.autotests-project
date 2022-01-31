package mobile.front;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка суммы 2-х товаров в корзине")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class VariableSampleTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void test() {
        //mobileMainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        pageActions.waitPageLoad();
        pageActions.reloadPage();;
        mobileProductCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int firstPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickToCartButton();
        pageActions.waitPageLoad();
        int secondPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        pageActions.waitPageLoad();
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice,totalPrice);
    }
}