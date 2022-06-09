package web.cft;

import base.BaseSettingsWebTests;
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

@Feature(value = "Web")
@Story("ЦФТ на сайте 36.6")
@DisplayName("Проверка работы ЦФТ на странице с листингом товаров сайта 36.6")
@Tag("Regression")
@Tag("CFT")
public class CftOnListingPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        String actualColor = commonActionsOnWebPages.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка всплывающего окна с информацией по бонусам - Cash back за покупку")
    @Description("При наведении мышкой появляется всплывающее окно с информацией по бонусам")
    @Test
    public void checkInfoProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.getProductGalleryBonusesButton().moveToElement();
        String actualText = commonActionsOnWebPages.getTextAboutCashBack();
        Assertions.assertEquals("Cash back за покупку", actualText);
    }

    @DisplayName("Проверка по URL релевантного перехода по ссылке во всплывающем окне с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на ссылку происходит переход на страницу с подробным описанием бонусных карт")
    @Test
    public void checkLinkInfoProductGalleryBonus() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.getProductGalleryBonusesButton().moveToElement();
        commonActionsOnWebPages.clickOnLinkMoreAboutBonuses();
        pageActions.checkUrl("https://366.ru/pravila_programmy/");
    }

    @DisplayName("Проверка на отсутствие начисляемых бонусов за покупку товара")
    @Description("Взять цену товара, умножить на 0,03 (Текущий процент бонусов от цены), если значение меньше 0.5, то шильдик должен отсутствовать")
    @Test
    public void checkUnVisibilityBonuses() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.changePricesRangeWithHands("10", "10");
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assertions.assertEquals(price, FromPriceRange);
        Assertions.assertEquals(price, ToPriceRange);
        commonActionsOnWebPages.getProductGalleryBonusesButton().isElementNotVisible();
    }

    @DisplayName("Проверка на наличия начисляемых бонусов за покупку товара")
    @Description("Взять цену товара, умножить на 0,03 (Текущий процент бонусов от цены), если значение больше или равно 0.5, то шильдик должен быть")
    @Test
    public void checkVisibilityBonuses() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.changePricesRangeWithHands("15", "1000");
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price >= ToPriceRange);
        commonActionsOnWebPages.getProductGalleryBonusesButton().isElementDisplayed();
    }
}
