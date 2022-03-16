package mobile.front;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка суммы 2-х товаров в корзине на сайте 36.6")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class VariableSampleMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void test() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        int firstPrice = mobileProductCardPage.getProductPrice();
        mobileCartPage.сlickAddCartButton();
        mobileMainPage.clickSiteLogo();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode3"));
        int secondPrice = mobileProductCardPage.getProductPrice();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        int totalPrice = mobileCartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }
}