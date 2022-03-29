package web.banners;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Проверка работы банеров на сайте 36.6")
@DisplayName("Проверка работы банеров на сайте")
public class BannersWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь проверяет прокрутку банеров вперед по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkNextBannerOnMainPage() {
        mainPage.checkNextBannerList();
    }

    @DisplayName("Пользователь проверяет прокрутку банеров назад по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkPrevBannerOnMainPage() {
        mainPage.checkPrevBannerList();
    }

    @DisplayName("Пользователь проверяет смену банеров по пинам на главной странице")
    @Test
    public void checkBannerButtonsOnMainPage() {
        mainPage.checkNextBannerButtons();
    }

    @DisplayName("Пользователь проверяет переход по банерам на главной странице")
    @Test
    public void checkBannersClickableOnMainPage() {
        mainPage.checkBannersClickable();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице OSP")
    @Test
    public void checkBannersClickableOnOspPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickLetterN();
        ospPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице товара")
    @Test
    public void checkBannersClickableOnProductPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        productCardPage.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице категории")
    @Test
    public void checkBannersClickableOnCategoryPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickCatalogButton();
        catalogPage.clickMedicationsButtons();
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице поисковой выдачи")
    @Test
    public void checkBannersClickableWithSearch() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        headerBlock.setSearchInput("Лекарства");
        commonActionsOnWebPages.clickBanner();
        productCardPage.clickMainButton();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице корзины")
    @Test
    public void checkBannersClickableOnCartPage() {
        driver.get(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.clickBanner();
        productCardPage.clickMainButton();
    }
}
