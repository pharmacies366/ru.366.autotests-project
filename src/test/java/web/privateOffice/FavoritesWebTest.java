package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
@Tag("Regression")
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
        headerBlock.clickFavoritesButton();
        favoritesPage.clickMainPageButton();
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/");
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
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
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
