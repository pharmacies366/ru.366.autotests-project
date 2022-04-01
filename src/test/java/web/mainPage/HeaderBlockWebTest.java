package web.mainPage;

import base.BaseSettingsWebTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature(value = "Web")
@Story("Проверка шапки сайта 36.6")
@DisplayName("Проверка шапки сайта")
@RunWith(DataProviderRunner.class)
public class HeaderBlockWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка отображения логотипа")//возможно нужно убрать данную проверку,
    // так как по супи в проверки кликабельности уже входит под капотом проверка на видимость
    @Test
    public void checkVisibilityLogo(){
        headerBlock.getSiteLogo().elementIsVisibility();
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo(){
        headerBlock.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }

    @DisplayName("Проверка кликабельности кнопки 'Каталог'")
    @Test
    public void checkClickableCatalogButton(){
        headerBlock.clickCatalogButton();
        logger.info("Каталог кликабелен");
    }

    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch(){
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-p1-public.model-t.cc.commerce.ondemand.com/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart(){
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        int quantity = headerBlock.checkCartQuantity();
        Assert.assertEquals(1, quantity);
        headerBlock.clickToCartButton();
        pageActions.contentIsDisplayed("В корзине 1 товар");
        logger.info("Проверки прошли успешно");
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке для выбора городов")
    @Test
    public void checkButtonSelectCities(){
        headerBlock.clickCitiesButton();
        Assert.assertEquals("Выбор города", headerBlock.checkCitiesPopUp());
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке 'аптеки'")
    @Test
    public void checkButtonPharmacies(){
        headerBlock.clickPharmaciesButton();
        pageActions.contentIsDisplayed("Работает сейчас");
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности кнопки 'Войти'")
    @Test
    public void checkClickableSignIn(){
        headerBlock.clickToSignInButton();
        logger.info("Кнопка 'Войти' кликабельна");
    }

    @DisplayName("Проверка кликабельности кнопки 'Зарегистрироваться'")
    @Test
    public void checkClickableSignUp(){
        headerBlock.clickToSignUpButton();
        logger.info("Кнопка 'Зарегистрироваться' кликабельна");
    }

    @DisplayName("Проверка кликабельности номера телефона")
    @Test
    public void checkClickablePhoneNumber(){
        headerBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона кликабелен");
    }


    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                {"/howToOrderNew/", "Как сделать заказ*", "Как оформить заказ на сайте?"},
                {"/pravila_programmy/", "Клуб 36,6", "Условия выдачи карты"},
                {"/certificates/", "Подарочные сертификаты", "Подарочные сертификаты"},
        };
    }

    @DisplayName("Проверка релевантности ссылок в шапке сайта")
    @Step("В шапке сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("data")
    public void test(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        headerBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        headerBlock.selectHeaderButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

}
