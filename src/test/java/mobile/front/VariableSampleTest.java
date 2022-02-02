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
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        int firstPrice = mobileProductCardPage.getProductPrice();
        pageActions.waitPageLoad();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileMainPage.clickSiteLogo();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode3"));
        int secondPrice = mobileProductCardPage.getProductPrice();
        pageActions.waitPageLoad();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }
}