package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Изменение региональности на сайте 36.6")
@DisplayName("Изменение региональности")
@Tag("Regression")
public class CheckRegionalWebTest extends BaseSettingsWebTests {


    @DisplayName("Пользователь устанавливает город Санкт-Петербург")
    @Test
    public void checkChangeRegionOnMainPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
    }

    @DisplayName("Пользователь устанавливает город Санкт-Петербург, а затем меняет его на Москва")
    @Test
    public void checkRevertRegionOnMainPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectMskCity();
        headerBlock.checkSelectedRegion("Москва и МО");
    }

    @DisplayName("Пользователь проверяет установленный город на станице товара")
    @Test
    public void checkChangeRegionOnProductPage() {
        headerBlock.clickCitiesButton();
        citiesPopUpPage.selectSpbCity();
        headerBlock.checkSelectedRegion("Санкт-Петербург и ЛО");
        mainPage.clickFirstProductOnMainPage();
        productCardPage.checkSelectedRegion("Санкт-Петербург");
    }
}
