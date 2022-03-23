package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
public class FavoritesWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь добавляет товар в избранное")
    @Test
    public void addProductToFavorites() {
        mainPage.clickClosePopUp();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
    }

    @DisplayName("Пользователь удаляет товар из избранного")
    @Test
    public void deleteProductFromFavorites() {
        mainPage.clickClosePopUp();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
        favoritesPage.deleteProductFromFavorites();
        favoritesPage.checkFavoritesPageEmpty();
    }

    @DisplayName("Пользователь на странице Избранное переходит по гиперссылке на главную страницу сайта")
    @Test
    public void checkMainHyperlink() {
        mainPage.clickClosePopUp();
        cartPage.checkAndClearCartQuantity();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkProductsOnFavoritesPage();
        favoritesPage.clickMainPageButton();
    }

    @DisplayName("Товар, добавленный в избранное будучи не авторизованным," +
            "добавился в список избранного у авторизованного пользователя")
    @Test
    public void transferProductForAuthorizedUser() {
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber9"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        cartPage.checkAndClearCartQuantity();
        pageActions.waitPageLoad();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkProductsOnFavoritesPage();
        favoritesPage.clickMainPageButton();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickLogOut();
        pageActions.reloadPage();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber9"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();

    }

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на странице избранное")
    @Test
    public void increaseQuantityMaterialOnFavoritesPage() {
        mainPage.clickClosePopUp();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
        favoritesPage.clickAddToCardButton();
        favoritesPage.clickIncreaseQuantity();
        int firstQuantity = favoritesPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

/*    // TODO: проверить после bugfix
    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на странице избранное")
    @Test
    public void decreaseQuantityMaterialOnFavoritesPage() {
        mainPage.clickClosePopUp();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
        favoritesPage.clickAddToCardButton();
        favoritesPage.clickIncreaseQuantity();
        int firstQuantity = favoritesPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        favoritesPage.clickDecreaseQuantity();
        int secondQuantity = favoritesPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }*/

    @DisplayName("Пользователь проверяет, что товар который был добавлен в избранное," +
            " на странице корзины так же отмечен что он находится в избранном")
    @Test
    public void checkActivFavoritesButtonOnCartPage() {
        mainPage.clickClosePopUp();
        mainPage.clickFavoritesIcon();
        headerBlock.clickFavoritesButton();
        favoritesPage.checkButtonAddToCart();
        favoritesPage.clickAddToCardButton();
        headerBlock.clickToCartButton();
        cartPage.clickFavoritesButton();

    }


}
