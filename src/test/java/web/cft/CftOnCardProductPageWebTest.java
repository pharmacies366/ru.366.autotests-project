package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@DisplayName("ЦФТ на сайте 36.6")
@Story("Проверка работы ЦФТ в карточке товаров сайта 36.6")
@Tag("Web")
@Tag("Regression")
@Tag("CFT")
public class CftOnCardProductPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка цвета начисляемых бонусов для товара")
    @Description("Цвет количества бонусов должен быть: #004b80 - Синий")
    @Test
    public void checkColorCountBonuses() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorCountBonuses();
        Assertions.assertEquals("#004b80", actualColor);
    }

    @DisplayName("Проверка цвета начисляемых бонусов для товара")
    @Description("Текст слова 'бонусы' должен быть обозначен чёрным цветом: #212121")
    @Test
    public void checkTextWordBonuses() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.checkColorTextWordBonuses();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка, что у товара присутствует значок '+' синего цвета для главного товара в карточке товара")
    @Description("У товара должен присутствовать знак '+' синего цвета")
    @Test
    public void checkInfoOnMainProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.checkPlusOnMainProductAboutBonuses();
        productCardPage.checkPlusColorOnMainProductAboutBonuses();

    }

    @DisplayName("Проверка цвета текста на табличке с расчётом бонусов для товаров - аналогов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов для товаров - аналогов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        String actualColor = productCardPage.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка всплывающего окна с информацией по бонусам - Cash back за покупку")
    @Description("При наведении мышкой появляется всплывающее окно с информацией по бонусам")
    @Test
    public void checkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.getProductGalleryBonusesButton().moveToElement();
        String actualText = productCardPage.getTextAboutCashBack();
        Assertions.assertEquals("Cash back за покупку", actualText);
    }

    @DisplayName("Проверка по URL релевантного перехода по ссылке во всплывающем окне с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на ссылку происходит переход на страницу с подробным описанием бонусных карт")
    @Test
    public void checkLinkInfoProductGalleryBonus() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/207185");
        productCardPage.getProductGalleryBonusesButton().moveToElement();
        productCardPage.clickOnLinkMoreAboutBonuses();
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/pravila_programmy/");
    }


    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkCorrectEnding")
    public void checkCorrectEnding(String PRODUCT, String BONUS_MESSAGE) {
        openUrl(propertiesManager.getProperty("baseurl") + PRODUCT);
        assertThat(productCardPage.getTextWordBonuses().getText(), containsString(BONUS_MESSAGE));
    }

    private static Stream<Arguments> checkCorrectEnding() {
        return Stream.of(
                Arguments.of("p/211533", "бонус"),
                Arguments.of("p/334476", "бонуса"),
                Arguments.of("p/54907", "бонусов")
        );
    }

}
