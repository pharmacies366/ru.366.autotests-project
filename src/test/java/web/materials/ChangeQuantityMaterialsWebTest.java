package web.materials;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story(value = "Изменение количества товара в корине на сайте 36.6")
@DisplayName("Изменение количества товара в корзине")
@Tag("Web")
@Tag("Regression")
public class ChangeQuantityMaterialsWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMainPage() {
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
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

    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/47497");
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        productCardPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int quantity = productCardPage.getQuantityProduct();
        Assertions.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        productCardPage.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");

    }

}
