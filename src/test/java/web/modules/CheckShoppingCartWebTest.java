package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Изменения корзины на сайте 36.6")
@DisplayName("Изменения корзины")
@Tag("Web")
@Tag("Regression")
public class CheckShoppingCartWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickIncreaseQuantity();
        mainPage.getIncreaseQuantity().waitingForElementNullOnThePage();
        mainPage.getIncreaseQuantity().moveToElement();
        int quantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mainPage.clickDecreaseQuantity();
        int secondQuantity = mainPage.getQuantityMaterials();
        Assertions.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/47497");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assertions.assertEquals(1, cartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/47497");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        cartPage.deleteAllMaterials();
        pageActions.waitPageLoad();
        Assertions.assertEquals(0, cartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void checkTotalAmountProducts() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/64844");
        productCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        double firstPrice = Double.parseDouble(cartPage.getProductPrice("1"));
        double secondPrice = Double.parseDouble(cartPage.getProductPrice("2"));
        int totalPrice = cartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @DisplayName("Пользователь проверяет нотификацию после удаления товара")
    @Test
    public void checkNotificationCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/47497");
        productCardPage.clickAddCartButton();
        int firstPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        productCardPage.clickAddCartButton();
        int secondPrice = productCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = cartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
        cartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assertions.assertEquals(1, cartPage.checkCartQuantity());
        int finalPrice = cartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice, finalPrice);
    }

    @DisplayName("Пользователь проверяет, что добавленный товар в корзину, возможно добавить в избранное со странице корзины")
    @Test
    public void addProductToFavoritePageOnShoppingCartPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        headerBlock.clickToCartButton();
        pageActions.waitPageLoad();
        cartPage.clickFavoritesButton();
        pageActions.waitPageLoad();
        headerBlock.clickFavoritesButton();
        int count =  headerBlock.checkQuantityProductsOnFavoritesPage();
        Assertions.assertEquals(count,1);
    }

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: - Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = cartPage.checkTextDoNotAddToCart();
        Assertions.assertEquals(text,"Не забудьте положить в корзину");
        int count = cartPage.checkDoNotAddToCartProductsList();
        Assertions.assertTrue(count > 0);
    }
    
}
