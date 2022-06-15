package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Михаил
 */

@Feature(value = "Мобильная версия")
@DisplayName("ЦФТ на сайте 36.6")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта 36.6")
@Tag("Regression")
@Tag("CFT")
@Tag("Mobile")
public class CftOnListingPageMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        String actualColor = commonActionsOnMobilePages.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка окна с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на шильдик с бонусами, появляется окно с информацией по бонусам")
    @Test
    public void checkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.getProductGalleryBonusesButton().click();
        String actualText = commonActionsOnMobilePages.getTextAboutCashBack();
        Assertions.assertEquals("Cash back за покупку", actualText);
    }

    @DisplayName("Проверка по URL релевантного перехода по ссылке во всплывающем окне с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на ссылку происходит переход на страницу с подробным описанием бонусных карт")
    @Test
    public void checkLinkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.getProductGalleryBonusesButton().click();
        commonActionsOnMobilePages.clickOnLinkMoreAboutBonuses();
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/pravila_programmy/");
    }

    @DisplayName("Проверка на отсутствие начисляемых бонусов за покупку товара")
    @Description("Взять цену товара, умножить на 0,03 (Текущий процент бонусов от цены), если значение меньше 0.5, то шильдик должен отсутствовать")
    @Test
    public void checkUnVisibilityBonuses() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("10", "10");
        commonActionsOnMobilePages.clickFiltersButton();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assertions.assertEquals(price, FromPriceRange);
        Assertions.assertEquals(price, ToPriceRange);
        commonActionsOnMobilePages.getProductGalleryBonusesButton().isElementNotVisible();
    }

    @DisplayName("Проверка на наличия начисляемых бонусов за покупку товара")
    @Description("Взять цену товара, умножить на 0,03 (Текущий процент бонусов от цены), если значение больше или равно 0.5, то шильдик должен быть")
    @Test
    public void checkVisibilityBonuses() {
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("15", "1000");
        commonActionsOnMobilePages.clickFiltersButton();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
        commonActionsOnMobilePages.getProductGalleryBonusesButton().isElementNotVisible();
    }
}
