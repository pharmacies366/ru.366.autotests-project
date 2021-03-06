package web.modules;

import base.BaseSettingsWebTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@Feature(value = "Web")
@Story(value = "Страница товаров на сайте 36.6")
@DisplayName("Страница товаров")
@RunWith(DataProviderRunner.class)
public class ProductsPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет работу слайдера для изменения цены")
    @Test
    public void checkChangePricesRangeWithSlider() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        int startPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int finishPriceRange = commonActionsOnWebPages.getToPriceRange();
        commonActionsOnWebPages.changePricesRangeWithSlider();
        pageActions.staticWait(500);
        int newStartPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int newFinishPriceRange = commonActionsOnWebPages.getToPriceRange();
        Assert.assertTrue(startPriceRange < newStartPriceRange);
        Assert.assertTrue(finishPriceRange > newFinishPriceRange);
    }

    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.changePricesRangeWithHands("100", "500");
        int ToPriceRange = commonActionsOnWebPages.getToPriceRange();
        int FromPriceRange = commonActionsOnWebPages.getFromPriceRange();
        int price = commonActionsOnWebPages.checkProductsPrices();
        Assert.assertTrue(price >= FromPriceRange);
        Assert.assertTrue(price <= ToPriceRange);
    }

    @DisplayName("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkProductsOnlyDelivery() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickCheckboxDelivery();
        commonActionsOnWebPages.checkSelectedCheckbox("Доставка");
        commonActionsOnWebPages.checkSelectedProductsWithDeliveryMethod();
    }

    @DisplayName("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelCheckboxDelivery() {
        mainPage.clickClosePopUp();
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
        mainPage.clickClosePopUp();
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
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickNextPage();
        commonActionsOnWebPages.clickPrevPage();
    }

    @DataProvider
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
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickShowAll(INDEX_SHOW_ALL);
        commonActionsOnWebPages.clickAndCheckCheckboxes(INDEX_OPTION);
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров по рецепту")
    @Test
    public void checkCheckboxWithRecipe() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.checkCheckboxWithRecipe();
        String recipeInfo = productCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "По рецепту");
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров без рецепта")
    @Test
    public void checkCheckboxWithoutRecipe() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.checkCheckboxWithoutRecipe();
        String recipeInfo = productCardPage.getRecipeInfo().getText();
        Assert.assertEquals(recipeInfo, "Без рецепта");
    }

/*    @DisplayName("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    @Test
    public void checkSortingPriceReduction() {
        mainPage.clickClosePopUp();
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
        mainPage.clickClosePopUp();
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
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        pageActions.waitPageLoad();
        commonActionsOnWebPages.clickSortingButton();
        commonActionsOnWebPages.clickSortingNameOption();
        commonActionsOnWebPages.checkSortingOption("по названию");
    }*/



}
