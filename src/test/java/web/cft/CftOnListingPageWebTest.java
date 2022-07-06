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
@DisplayName("ЦФТ на сайте 36.6")
@Story("Проверка работы ЦФТ на странице с листингом товаров сайта 36.6")
@Tag("Web")
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
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/pravila_programmy/");
    }
    @DisplayName("Проверка на наличие начисляемых бонусов за покупку товара")
    @Description("Взять цену товара, умножить на 0,03 (Текущий процент бонусов от цены), если значение больше или равно 0.5, то шильдик должен быть")
    @Test
    public void checkVisibilityBonuses() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.getPriceText().isElementDisplayed();
        commonActionsOnWebPages.changePricesRangeWithHands("15", "100");
        pageActions.waitPageLoad();
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
        commonActionsOnWebPages.getProductGalleryBonusesButton().isElementDisplayed();
    }
}
