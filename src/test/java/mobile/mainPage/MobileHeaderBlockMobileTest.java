package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story("Проверка шапки сайта 36.6")
@DisplayName("Проверка шапки сайта")
@Tag("Regression")
@Tag("Mobile")
public class MobileHeaderBlockMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo(){
        mobileHeaderBlock.clickSiteLogo();
        logger.info("Логотип кликабелен");
    }

    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch(){
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/search/?text=35523");
        logger.info("Поиск работает корректно");
    }

    @DisplayName("Проверка корекного перехода в избранное")
    @Test
    public void checkClickableFavorites(){
        mobileHeaderBlock.clickFavorites();
        pageActions.contentIsDisplayed("Избранное");
        logger.info("Переход на страницу Избранное выполнен корректно");
    }

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart(){
        mobileMainPage.AddToCartClick();
        pageActions .waitPageLoad();
        int quantity = mobileHeaderBlock.checkCartQuantity();
        Assertions.assertEquals(1, quantity);
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        pageActions.contentIsDisplayed("В корзине 1 товар");
        logger.info("Проверки прошли успешно");
    }



}
