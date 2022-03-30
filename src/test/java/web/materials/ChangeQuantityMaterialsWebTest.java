package web.materials;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


@Feature(value = "Web")
@Story(value = "Изменение количества товара в корине на сайте 36.6")
@DisplayName("Изменение количества товара в корзине")
public class ChangeQuantityMaterialsWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        mainPage.clickIncreaseQuantity();
        int firstQuantity = mainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        headerBlock.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMainPage() {
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

    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        mainPage.clickClosePopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        productCardPage.clickAddCartButton();
        pageActions.waitPageLoad();
        productCardPage.clickIncreaseQuantity();
        int quantity = productCardPage.getQuantityProduct();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        productCardPage.clickToCartButton();
        int finalQuantity = cartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");

    }

}
