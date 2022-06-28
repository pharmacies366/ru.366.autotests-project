package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта 36.6")
@DisplayName("Проверка подвала сайта")
@Tag("Mobile")
@Tag("Regression")
public class MobileBasementBlockMobileTest extends BaseSettingsMobileTests {


    @DisplayName("Проверка кликабельности и отображения номера телефона")
    @Test
    public void checkClickablePhoneNumber() {
        mobileBasementBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона отображается и кликабелен");
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("helpTest")
    public void helpTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickHelpButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    private static Stream<Arguments> helpTest() {
        return Stream.of(
                //Помощь
                /*Arguments.of("howToOrderNew", "Как сделать заказ", "Как оформить заказ на сайте?"),*/
                Arguments.of("/apteki/map/", "Где получить заказ", "Работает сейчас"),
                Arguments.of("/faq/", "Вопрос-ответ", "Вопрос-ответ"),
                Arguments.of("/feedback/", "Задать вопрос", "Обратная связь")
                //Arguments.of("/delivery/", "Доставка", "Доставка заказов")
        );
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("Service")
    public void Service(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickServiceButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    private static Stream<Arguments> Service() {
        return Stream.of(
                //Сервис
                Arguments.of("/polzovatelskoe-soglashenie/", "Пользовательское соглашение", "Пользовательское соглашение"),
                Arguments.of("/politika-konfidencialnosti/", "Политика конфиденциальности", "Политика конфиденциальности"),
                Arguments.of("/mnn/", "Действующие вещества", "Действующие вещества"),
                Arguments.of("/promotions/", "Акции", "Акции"),
                Arguments.of("/articles/", "Статьи", "Статьи")
        );
    }

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("aboutCompanyTest")
    public void aboutCompanyTest(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mobileBasementBlock.clickAboutCompanButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    private static Stream<Arguments> aboutCompanyTest() {
        return Stream.of(
                //О Компании
                Arguments.of("/aboutus/", "О нас", "О нас"),
                Arguments.of("/contacts/", "Контактные данные", "Контактные данные"),
                Arguments.of("/manufacturers/", "Производители", "Производители"),
                Arguments.of("/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"),
                Arguments.of("/license/", "Лицензии", "Лицензии"),
                Arguments.of("/vakansii/", "Вакансии", "Фармацевт/Провизор")
        );
    }
}

