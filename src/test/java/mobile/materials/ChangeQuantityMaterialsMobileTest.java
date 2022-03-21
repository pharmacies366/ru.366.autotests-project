package mobile.materials;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Изменение количества товара в корине на сайте 36.6")
@DisplayName("Изменение количества товара в корзине")
public class ChangeQuantityMaterialsMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь увеличивает количество шт. товара в корзине на главной странице")
    @Test
    public void increaseQuantityMaterialOnMainPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.AddToCartClick();
        pageActions.waitPageLoad();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickToCartButton();
        pageActions.waitPageLoad();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара в корзине на главной странице")
    @Test
    public void decreaseQuantityMaterialOnMainPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.AddToCartClick();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickDecreaseQuantity();
        int secondQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileMainPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь увеличивает количество шт. товара на странице корзины")
    @Test
    public void increaseQuantityMaterialOnCartPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.AddToCartClick();
        mobileMainPage.clickToCartButton();
        mobileCartPage.clickIncreaseQuantity();
        int quantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
    }

    @DisplayName("Пользователь уменьшает количество шт. товара на странице корзины")
    @Test
    public void decreaseQuantityMaterialOnCartPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileMainPage.AddToCartClick();
        mobileMainPage.clickIncreaseQuantity();
        int firstQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(2, firstQuantity);
        logger.info("Количество товара равно 2-м");
        mobileMainPage.clickDecreaseQuantity();
        int secondQuantity = mobileMainPage.getQuantityMaterials();
        Assert.assertEquals(1, secondQuantity);
        logger.info("Количество товара равно 1-му");
        mobileMainPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(1, finalQuantity);
        logger.info("Количество товара равно 1-му");
    }

    @DisplayName("Пользователь увеличивает количество шт. товара в карточке товара")
    @Test
    public void increaseQuantityMaterialOnProductCartPage() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        mobileProductCardPage.clickIncreaseQuantity();
        int quantity = mobileProductCardPage.getQuantityProduct();
        Assert.assertEquals(2, quantity);
        logger.info("Количество товара равно 2-м");
        mobileProductCardPage.clickToCartButton();
        int finalQuantity = mobileCartPage.getQuantityMaterials();
        Assert.assertEquals(2, finalQuantity);
        logger.info("Количество товара равно 2-м");

    }

    @DisplayName("Пользователь удаляет 1 из 2-х товаров в корзине")
    @Test
    public void deleteMaterialsFromCart() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        mobileProductCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.clickDeleteMaterials();
        Assert.assertEquals(1, mobileCartPage.checkCartQuantity());
    }

    @DisplayName("Пользователь удаляет все товары в корзине")
    @Test
    public void deleteAllMaterialsFromCart() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        mobileProductCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "p/33090");
        mobileProductCardPage.clickAddCartButton();
        openUrl(propertiesManager.getProperty("baseurl") + "cart");
        mobileCartPage.deleteAllMaterials();
        Assert.assertEquals(0, mobileCartPage.checkCartQuantity());
    }
}
