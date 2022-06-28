package web.mainPage;

import base.BaseSettingsWebTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Feature(value = "Web")
@Story("Проверка подвала сайта 36.6")
@DisplayName("Проверка подвала сайта")
@Tag("Web")
@Tag("Regression")
public class BasementBlockWebTest extends BaseSettingsWebTests {


    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkBasementLinks")
    public void checkBasementLinks(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
    }

    private static Stream<Arguments> checkBasementLinks() {
        return Stream.of(
                //Помощь
                Arguments.of("/howToOrderNew/", "Как сделать заказ", "Как сделать заказ"),
                Arguments.of("/apteki/map/", "Где получить заказ", "Работает сейчас"),
                Arguments.of("/faq/", "Вопрос-ответ", "Вопрос-ответ"),
                Arguments.of("/feedback/", "Задать вопрос", "Обратная связь"),
               // Arguments.of("/delivery/", "Доставка", "Доставка заказов"),
              //  Arguments.of("/oplata/", "Оплата", "Способы оплаты"),
               // Arguments.of("/refund/", "Обмен и возврат", "Правила обмена и возврата"),
              //  Arguments.of("/warranty/", "Гарантии", "Гарантии"),
                //Сервис
                Arguments.of("/polzovatelskoe-soglashenie/", "Пользовательское соглашение", "Пользовательское соглашение"),
                Arguments.of("/politika-konfidencialnosti/", "Политика конфиденциальности", "Политика конфиденциальности"),
                Arguments.of("/mnn/", "Действующие вещества", "Действующие вещества"),
                Arguments.of("/promotions/", "Акции", "Акции"),
                Arguments.of("/articles/", "Статьи", "Статьи"),
                //О Компании
                Arguments.of("/aboutus/", "О нас", "О компании"),
                Arguments.of("/contacts/", "Контактные данные", "Контактные данные"),
                Arguments.of("/manufacturers/", "Производители", "Производители"),
                Arguments.of("/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"),
                Arguments.of("/license/", "Лицензии", "Лицензии"),
                Arguments.of("/vakansii/", "Вакансии", "Вакансии")
        );
    }


}