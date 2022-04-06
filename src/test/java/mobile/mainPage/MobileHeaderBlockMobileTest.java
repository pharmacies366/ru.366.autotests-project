package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка шапки сайта 36.6")
@DisplayName("Проверка шапки сайта")
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
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-p1-public.model-t.cc.commerce.ondemand.com/search/?text=44226");
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
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.AddToCartClick();
        pageActions .waitPageLoad();
        int quantity = mobileHeaderBlock.checkCartQuantity();
        Assert.assertEquals(1, quantity);
        mobileHeaderBlock.clickToCartButton();
        pageActions.waitPageLoad();
        pageActions.contentIsDisplayed("В корзине 1 товар");
        logger.info("Проверки прошли успешно");
    }



}
