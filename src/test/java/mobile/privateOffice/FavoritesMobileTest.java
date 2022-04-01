package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
public class FavoritesMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь добавляет товар в избранное")
    @Test
    public void addProductToFavorites() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
    }


    @DisplayName("Пользователь удаляет товар из избранного")
    @Test
    public void deleteProductFromFavorites() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
        mobileFavoritesPage.deleteProductFromFavorites();
        mobileFavoritesPage.checkFavoritesPageEmpty();
    }


    @DisplayName("Пользователь на странице Избранное переходит по гиперссылке на главную страницу сайта")
    @Test
    public void checkMainHyperlink() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber9"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkProductsOnFavoritesPage();
        mobileFavoritesPage.clickMainPageButton();
    }


    @DisplayName("Товар, добавленный в избранное будучи не авторизованным," +
            "добавился в список избранного у авторизованного пользователя")
    @Test
    public void transferProductForAuthorizedUser() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber9"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkProductsOnFavoritesPage();
        mobileFavoritesPage.clickMainPageButton();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickLogOut();
        pageActions.reloadPage();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber9"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();

    }


    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на странице избранное")
    @Test
    public void increaseQuantityMaterialOnFavoritesPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
        mobileFavoritesPage.clickAddToCardButton();
        mobileFavoritesPage.clickIncreaseQuantity();
        int firstQuantity = mobileFavoritesPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileHeaderBlock.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }


  /*   TODO: проверить после bugfix
    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на странице избранное")
    @Test
    public void decreaseQuantityMaterialOnFavoritesPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
        mobileFavoritesPage.clickAddToCardButton();
        mobileFavoritesPage.clickIncreaseQuantity();
        int firstQuantity = mobileFavoritesPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileFavoritesPage.clickDecreaseQuantity();
        int secondQuantity = mobileFavoritesPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileHeaderBlock.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }*/


    @DisplayName("Пользователь проверяет, что товар который был добавлен в избранное," +
            " на странице корзины так же отмечен что он находится в избранном")
    @Test
    public void checkActivFavoritesButtonOnCartPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickFavoritesIcon();
        mobileHeaderBlock.clickFavoritesButton();
        mobileFavoritesPage.checkButtonAddToCart();
        mobileFavoritesPage.clickAddToCardButton();
        mobileHeaderBlock.clickToCartButton();
        mobileCartPage.checkActivFavoritesButton();

    }


}
