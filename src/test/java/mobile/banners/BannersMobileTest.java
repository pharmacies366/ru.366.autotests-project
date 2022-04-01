package mobile.banners;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка работы банеров на сайте 36.6")
@DisplayName("Проверка работы банеров на сайте")
public class BannersMobileTest extends BaseSettingsMobileTests {

/*    @DisplayName("Пользователь проверяет прокрутку банеров вперед по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkNextBannerOnMainPage() {
        mobileMainPage.checkNextBannerList();
    }*/

/*
   @DisplayName("Пользователь проверяет прокрутку банеров назад по стрелке и возврат к первоначальному баннеру на главной странице")
    @Test
    public void checkPrevBannerOnMainPage() {
        mobileMainPage.checkPrevBannerList();
    }
*/

    @DisplayName("Пользователь проверяет смену банеров по пинам на главной странице")
    @Test
    public void checkBannerButtonsOnMainPage() {
        mobileMainPage.checkNextBannerButtons();
    }

    @DisplayName("Пользователь проверяет переход по банерам на главной странице")
    @Test
    public void checkBannersClickableOnMainPage() {
        mobileMainPage.checkBannersClickable();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице OSP")
    @Test
    public void checkBannersClickableOnOspPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickSiteLogo();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
        mobileOspPage.clickBanner();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице товара")
    @Test
    public void checkBannersClickableOnProductPage() {
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        mobileProductCardPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @DisplayName("Пользователь проверяет переход по банерау на странице категории")
    @Test
    public void checkBannersClickableOnCategoryPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickMedicationsButtons();
        mobileMedicationsCategoryPage.clickAllergyButton();
        mobileAllergyPage.checkAllergyPage();
        mobileAllergyPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице поисковой выдачи")
    @Test
    public void checkBannersClickableWithSearch() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.setSearchInput("Лекарства");
        mobileMedicationsPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }

    @DisplayName("Пользователь проверяет переход по банеру на странице корзины")
    @Test
    public void checkBannersClickableOnCartPage() {
        driver.get(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.clickBanner();
        mobileProductCardPage.checkButtonToCartButton();
        mobileMainPage.clickSiteLogo();
    }
}
