package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Изменение региональности на сайте 36.6")
@DisplayName("Изменение региональности")
public class CheckRegionalMobileTest extends BaseSettingsMobileTests {


    @DisplayName("Пользователь устанавливает город Санкт-Петербург")
    @Test
    public void checkChangeRegionOnMainPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Санкт-Петербург");
    }

    @DisplayName("Пользователь устанавливает город Санкт-Петербург, а затем меняет его на Москва")
    @Test
    public void checkRevertRegionOnMainPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Санкт-Петербург");
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionMsk();
        mobileCitiesPopUpPage.selectMskCity();
        mobileHeaderBlock.clickBurgerButton();
        mobileHeaderBlock.checkSelectedRegion("Москва");
    }

    @DisplayName("Пользователь проверяет установленный город на станице товара")
    @Test
    public void checkChangeRegionOnProductPage() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickCitiesButton();
        mobileCitiesPopUpPage.clickSelectRegionButton();
        mobileCitiesPopUpPage.selectRegionSpb();
        mobileCitiesPopUpPage.selectSpbCity();
        mobileMainPage.clickFirstProductOnMainPage();
        mobileProductCardPage.checkSelectedRegion("Санкт-Петербург");
    }
}
