package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


@Feature(value = "Web")
@Story(value = "Страница товаров на сайте 36.6")
@DisplayName("Страница товаров")
public class ProductsPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет работу слайдера для изменения цены")
    @Test
    public void checkChangePricesRangeWithSlider() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        int startPriceRange = medicationsCategoryPage.getFromPriceRange();
        int finishPriceRange = medicationsCategoryPage.getToPriceRange();
        medicationsCategoryPage.changePricesRangeWihtSlider();
        pageActions.reloadPage();
        int newStartPriceRange = medicationsCategoryPage.getFromPriceRange();
        int newFinishPriceRange = medicationsCategoryPage.getToPriceRange();
        Assert.assertTrue(startPriceRange < newStartPriceRange);
        Assert.assertTrue(finishPriceRange > newFinishPriceRange);
    }

    @DisplayName("Пользователь проверяет изменения диапазона цены вручную")
    @Test
    public void checkChangePricesRangeWithHands() {
        mainPage.clickClosePopUp();
        headerBlock.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        medicationsCategoryPage.changePricesRangeWithHands("100","500");
        medicationsCategoryPage.checkChangeProductsPrices(100,500);

    }

}
