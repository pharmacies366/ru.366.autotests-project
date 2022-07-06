package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Страница товаров на сайте 36.6")
@DisplayName("Страница товаров")
@Tag("Web")
@Tag("Regression")
public class ProductsPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет работу слайдера для изменения цены")
    @Test
    public void checkChangePricesRangeWithSlider() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        int startPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int finishPriceRange = commonActionsOnWebPages.getToPriceRange();
        commonActionsOnWebPages.changePricesRangeWithSlider();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.getPriceRangeFrom().waitingForElementNullOnThePage();
        int newStartPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int newFinishPriceRange = commonActionsOnWebPages.getToPriceRange();
        Assertions.assertTrue(startPriceRange < newStartPriceRange);
        Assertions.assertTrue(finishPriceRange > newFinishPriceRange);
    }

    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.changePricesRangeWithHands("100", "500");
        pageActions.waitPageLoad();
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
    }

    @DisplayName("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkProductsOnlyDelivery() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
    }

    @DisplayName("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelCheckboxDelivery() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnWebPages.clickCloseCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedProductsWithAllMethods();
    }

    @DisplayName("Пользователь сбрасывает все выбранные чекбоксы и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelAllCheckboxes() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnWebPages.clickResetCheckboxes();
        commonActionsOnWebPages.checkSelectedProductsWithAllMethods();
    }

    @DisplayName("Пользователь проверяет коррекность работы пагинации страниц")
    @Test
    public void checkPagination() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickNextPage();
        commonActionsOnWebPages.clickPrevPage();
    }

/*    @DataProvider
    public static Object[][] checkingCheckboxes() {
        return new Object[][]{
                {1, 1},//Форма выпуска
                {2, 104},//Бренд
                {3, 219},//Теги
                {4, 235},//Для кого
                {5, 247},//Производители
        };
    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска,брендом,тегами,для кого,производителями")
    @Test
    @UseDataProvider("checkingCheckboxes")
    public void test(int INDEX_SHOW_ALL, int INDEX_OPTION) {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickShowAll(INDEX_SHOW_ALL);
        commonActionsOnWebPages.clickAndCheckCheckboxes(INDEX_OPTION);
    }*/

    @DisplayName("Пользователь проверяет корректную выдачу товаров по рецепту")
    @Test
    public void checkCheckboxWithRecipe() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.checkCheckboxWithRecipe();
        String recipeInfo = productCardPage.getRecipeInfo().getText();
        Assertions.assertEquals(recipeInfo, "По рецепту");
    }

/*
    @DisplayName("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    @Test
    public void checkSortingPriceReduction() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickPriceReductionOption();
        commonActionsOnWebPages.checkSortingOption("по уменьшению цены");
        commonActionsOnWebPages.checkSortingPriceReduction();
    }


    @DisplayName("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    @Test
    public void checkSortingPriceIncrease() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickPriceIncreaseOption();
        commonActionsOnWebPages.checkSortingOption("по увеличению цены");
        commonActionsOnWebPages.checkSortingPriceIncrease();
    }

    @DisplayName("Пользователь проверяет сортировку выдачи товаров по названию")
    @Test
    public void checkSortingName() {
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickSortingNameOption();
        commonActionsOnWebPages.checkSortingOption("по названию");
    }
*/



}
