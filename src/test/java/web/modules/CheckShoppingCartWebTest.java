package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Изменения корзины на сайте 36.6")
@DisplayName("Изменения корзины")
public class CheckShoppingCartWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickAddToCardButton();
        headerBlock.clickToCartButton();
        cartPage.clickIncreaseQuantity();
        int quantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mainPage.clickDecreaseQuantity();
        int secondQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.clickDeleteMaterials();
        Assert.assertEquals(1, cartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.deleteAllMaterials();
        Assert.assertEquals(0, cartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void checkTotalAmountProducts() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        productCardPage.clickAddCartButton();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @DisplayName("Пользователь проверяет нотификацию после удаления товара")
    @Test
    public void checkNotificationCart() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        productCardPage.clickAddCartButton();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice + secondPrice, totalPrice);
        cartPage.clickDeleteMaterials();
        Assert.assertEquals(1, cartPage.checkCartQuantity());
        int finalPrice = cartPage.getPriceTotal();
        Assert.assertEquals(firstPrice, finalPrice);
    }

    @DisplayName("Пользователь проверяет, что добавленный товар в корзину, возможно добавить в избранное со странице корзины")
    @Test
    public void addProductToFavoritePageOnShoppingCartPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickAddToCardButton();
        headerBlock.clickToCartButton();
        cartPage.clickFavoritesButton();
        headerBlock.clickFavoritesButton();
        int count =  headerBlock.checkQuantityProductsOnFavoritesPage();
        Assert.assertEquals(count,1);
    }

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = cartPage.checkTextDoNotAddToCart();
        Assert.assertEquals(text,"Не забудьте положить в корзину");
        int count = cartPage.checkDoNotAddToCartProductsList();
        Assert.assertTrue(count > 0);
    }
    
}
