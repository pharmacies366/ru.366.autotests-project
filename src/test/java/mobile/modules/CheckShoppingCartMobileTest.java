package mobile.modules;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Изменения корзины на сайте 36.6")
@DisplayName("Изменения корзины")
@Tag("Regression")
@Tag("Mobile")
public class CheckShoppingCartMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        mobileMainPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileMainPage.getIncreaseQuantity().moveToElement();
        mobileCartPage.clickIncreaseQuantity();
        mobileMainPage.getIncreaseQuantity().waitingForElementNullOnThePage();
        mobileMainPage.getIncreaseQuantity().moveToElement();
        int quantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        mobileMainPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileMainPage.getIncreaseQuantity().moveToElement();
        mobileCartPage.clickIncreaseQuantity();
        mobileMainPage.getIncreaseQuantity().waitingForElementNullOnThePage();
        int firstQuantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickDecreaseQuantity();
        mobileCartPage.getDecreaseQuantity().waitingForElementNullOnThePage();
        mobileCartPage.getDecreaseQuantity().moveToElement();
        int secondQuantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
    }


    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assertions.assertEquals(1, mobileCartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.deleteAllMaterials();
        Assertions.assertEquals(0, mobileCartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    public void checkTotalAmountProducts() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/332603");
        mobileProductCardPage.clickAddCartButton();
        int firstPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        mobileProductCardPage.clickAddCartButton();
        int secondPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = mobileCartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
    }

    @DisplayName("Пользователь проверяет нотификацию после удаления товара")
    @Test
    public void checkNotificationCart() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/332603");
        mobileProductCardPage.clickAddCartButton();
        int firstPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "p/44226");
        mobileProductCardPage.clickAddCartButton();
        int secondPrice = mobileProductCardPage.getProductPrice();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        int totalPrice = mobileCartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice + secondPrice, totalPrice);
        mobileCartPage.clickDeleteMaterials();
        pageActions.waitPageLoad();
        Assertions.assertEquals(1, mobileCartPage.checkCartQuantity());
        int finalPrice = mobileCartPage.getPriceTotal();
        Assertions.assertEquals(firstPrice, finalPrice);
    }

    @DisplayName("Пользователь проверяет, что добавленный товар в корзину, возможно добавить в избранное со странице корзины")
    @Test
    public void addProductToFavoritePageOnShoppingCartPage() {
        mobileMainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickToCartButton();
        mobileCartPage.clickFavoritesButton();
        int count = mobileHeaderBlock.checkQuantityProductsOnFavoritesPage();
        Assertions.assertEquals(count, 1);
    }

    @DisplayName("Пользователь проверяет, что в блоке - не забудьте положить в корзину, отображаются: -Мини-карточки товаров в виде макета")
    @Test
    public void checkDoNotAddToCartBlock() {
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        String text = mobileCartPage.checkTextDoNotAddToCart();
        Assertions.assertEquals(text, "Не забудьте положить в корзину");
        int count = mobileCartPage.checkDoNotAddToCartProductsList();
        Assertions.assertTrue(count > 0);
    }

}
