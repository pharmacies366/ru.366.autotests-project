package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Страница товаров на сайте 36.6")
@DisplayName("Страница товаров")
//@RunWith(DataProviderRunner.class)
@Tag("Regression")
public class ProductsPageMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь проверяет работу слайдера для изменения цены")
    @Test
    public void checkChangePricesRangeWithSlider() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        int startPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int finishPriceRange = commonActionsOnMobilePages.getToPriceRange();
        commonActionsOnMobilePages.changePricesRangeWithSlider();
        commonActionsOnMobilePages.clickFiltersButton();
        int newStartPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int newFinishPriceRange = commonActionsOnMobilePages.getToPriceRange();
        pageActions.reloadPage();
        Assertions.assertTrue(startPriceRange < newStartPriceRange);
        Assertions.assertTrue(finishPriceRange > newFinishPriceRange);
    }

    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.changePricesRangeWithHands("100", "500");
        commonActionsOnMobilePages.clickFiltersButton();
        int ToPriceRange = commonActionsOnMobilePages.getToPriceRange();
        int FromPriceRange = commonActionsOnMobilePages.getFromPriceRange();
        int price = commonActionsOnMobilePages.checkProductsPrices();
        Assertions.assertTrue(price >= FromPriceRange);
        Assertions.assertTrue(price <= ToPriceRange);
    }

    @DisplayName("Пользователь выбирет чекбокс Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkProductsOnlyDelivery() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
    }

    @DisplayName("Пользователь снимает галочку с чекбокса Доставка и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelCheckboxDelivery() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCloseCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedProductsWithAllMethods();
    }

    @DisplayName("Пользователь сбрасывает все выбранные чекбоксы и проверяет корректное изменение списка товаров")
    @Test
    public void checkCancelAllCheckboxes() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickCheckboxDelivery();
        commonActionsOnMobilePages.checkSelectedCheckbox("Доставка");
        commonActionsOnMobilePages.checkSelectedProductsWithDeliveryMethod();
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickResetCheckboxes();
        commonActionsOnMobilePages.checkSelectedProductsWithAllMethods();
    }

    @DisplayName("Пользователь проверяет коррекность работы пагинации страниц")
    @Test
    public void checkPagination() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickNextPage();
        commonActionsOnMobilePages.clickPrevPage();
    }

  /*  @DataProvider
    public static Object[][] checkingCheckboxes() {
        return new Object[][]{
                {1, 1},//Форма выпуска
                {2, 101},//Бренд
                {3, 216},//Теги
                {4, 232},//Для кого
                {5, 267},//Производители
        };
    }

    @DisplayName("Пользователь проверяет соотвествие между выдачей товаров и выбранной формы выпуска,брендом,тегами,для кого,производителями")
    @Test
    @UseDataProvider("checkingCheckboxes")
    public void test(int INDEX_SHOW_ALL, int INDEX_OPTION) {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.clickShowAll(INDEX_SHOW_ALL);
        commonActionsOnMobilePages.clickAndCheckCheckboxes(INDEX_OPTION);
    }*/

    @DisplayName("Пользователь проверяет корректную выдачу товаров по рецепту")
    @Test
    public void checkCheckboxWithRecipe() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithRecipe();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assertions.assertEquals(recipeInfo, "По рецепту");
    }

    @DisplayName("Пользователь проверяет корректную выдачу товаров без рецепта")
    @Test
    public void checkCheckboxWithoutRecipe() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickFiltersButton();
        commonActionsOnMobilePages.checkCheckboxWithoutRecipe();
        String recipeInfo = mobileProductCardPage.getRecipeInfo().getText();
        Assertions.assertEquals(recipeInfo, "Без рецепта");
    }

/*    @DisplayName("Пользователь проверяет сортировку выдачи товаров по уменьшению цены")
    @Test
    public void checkSortingPriceReduction() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceReductionOption();
        commonActionsOnMobilePages.checkSortingOption("по уменьшению цены");
        commonActionsOnMobilePages.checkSortingPriceReduction();
    }


    @DisplayName("Пользователь проверяет сортировку выдачи товаров по увеличению цены")
    @Test
    public void checkSortingPriceIncrease() {
      //  mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickPriceIncreaseOption();
        commonActionsOnMobilePages.checkSortingOption("по увеличению цены");
        commonActionsOnMobilePages.checkSortingPriceIncrease();
    }

    @DisplayName("Пользователь проверяет сортировку выдачи товаров по названию")
    @Test
    public void checkSortingName() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "c/lekarstva/");
        commonActionsOnMobilePages.clickSortingButton();
        commonActionsOnMobilePages.clickSortingNameOption();
        commonActionsOnMobilePages.checkSortingOption("по названию");
    }*/


}
