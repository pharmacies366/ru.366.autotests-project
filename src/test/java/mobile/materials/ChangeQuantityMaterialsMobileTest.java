package mobile.materials;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Изменение количества товара в корине на сайте 36.6")
@DisplayName("Изменение количества товара в корзине")
@Tag("Regression")
@Tag("Mobile")
public class ChangeQuantityMaterialsMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickToCartButton();
        pageActions.waitPageLoad();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMainPage() {
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        mobileMainPage.clickIncreaseQuantity();
        pageActions.waitPageLoad();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assertions.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickDecreaseQuantity();
        pageActions.waitPageLoad();
        int secondQuantity = mobileMainPage.getQuantityMaterials();
        Assertions.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileMainPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/332603");
        mobileProductCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickIncreaseQuantity();
        int quantity = mobileProductCardPage.getQuantityProduct();
        Assertions.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        mobileProductCardPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assertions.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

}
