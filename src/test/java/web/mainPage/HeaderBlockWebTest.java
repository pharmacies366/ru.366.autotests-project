package web.mainPage;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;


@Feature(value = "Web")
@Story("Проверка шапки сайта 36.6")
@DisplayName("Проверка шапки сайта")
public class HeaderBlockWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка отображения логотипа")//возможно нужно убрать данную проверку,
    // так как по супи в проверки кликабельности уже входит под капотом проверка на видимость
    @Test
    public void checkVisibilityLogo() {
        headerBlock.getSiteLogo().elementIsVisibility();
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo() {
        headerBlock.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }

    @DisplayName("Проверка кликабельности кнопки 'Каталог'")
    @Test
    public void checkClickableCatalogButton() {
        headerBlock.clickCatalogButton();
        logger.info("Каталог кликабелен");
    }

    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch() {
        headerBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/search/?text=44226");
        logger.info("Поиск работает корректно");
    }

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart() {
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        pageActions.waitPageLoad();
        int quantity = headerBlock.checkCartQuantity();
        Assertions.assertEquals(1, quantity);
        headerBlock.clickToCartButton();
        pageActions.contentIsDisplayed("В корзине 1 товар");
        logger.info("Проверки прошли успешно");
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке для выбора городов")
    @Test
    public void checkButtonSelectCities() {
        headerBlock.clickCitiesButton();
        Assertions.assertEquals("Выбор города", headerBlock.checkCitiesPopUp());
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке 'аптеки'")
    @Test
    public void checkButtonPharmacies() {
        headerBlock.clickPharmaciesButton();
        pageActions.contentIsDisplayed("Работает сейчас");
        logger.info("Проверка прошла успешно");
    }

    @DisplayName("Проверка кликабельности кнопки 'Войти'")
    @Test
    public void checkClickableSignIn() {
        headerBlock.clickToSignInButton();
        logger.info("Кнопка 'Войти' кликабельна");
    }

    @DisplayName("Проверка кликабельности кнопки 'Зарегистрироваться'")
    @Test
    public void checkClickableSignUp() {
        headerBlock.clickToSignUpButton();
        logger.info("Кнопка 'Зарегистрироваться' кликабельна");
    }

    @DisplayName("Проверка кликабельности номера телефона")
    @Test
    public void checkClickablePhoneNumber() {
        headerBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона кликабелен");
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkBasementLinks")
    public void testSomething(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) throws IOException {
        headerBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        headerBlock.selectHeaderButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        throw new IOException("Exception in I/O operation");
    }

    private static Stream<Arguments> checkBasementLinks() {
        return Stream.of(
                Arguments.of("/howToOrderNew/", "Как сделать заказ*", "Как сделать заказ*"),
                Arguments.of("/pravila_programmy/", "Клуб 36,6", "Условия выдачи карты"),
                Arguments.of("/certificates/", "Подарочные сертификаты", "Подарочные сертификаты")
        );
    }

}