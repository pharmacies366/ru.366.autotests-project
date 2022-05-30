package web.cft;

import base.BaseSettingsWebTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Михаил
 */

@Feature(value = "Web")
@Story("ЦФТ на сайте 36.6")
@DisplayName("Проверка работы ЦФТ на главной странице сайта 36.6")
public class CftOnMainPageWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        String actualColor = mainPage.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        String actualColor = mainPage.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка всплывающего окна с информацией по бонусам - Cash back за покупку")
    @Description("При наведении мышкой появляется всплывающее окно с информацией по бонусам")
    @Test
    public void checkInfoProductGalleryBonus() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.getTextColorProductGalleryButton().moveToElement();
        String actualText = mainPage.getTextAboutCashBack();
        Assertions.assertEquals("Cash back за покупку", actualText);
    }

    @DisplayName("Проверка по URL релевантного перехода по ссылке во всплывающем окне с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на ссылку происходит переход на страницу с подробным описанием бонусных карт")
    @Test
    public void checkLinkInfoProductGalleryBonus() {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        mainPage.getTextColorProductGalleryButton().moveToElement();
        mainPage.clickOnLinkMoreAboutBonuses();
        pageActions.checkUrl("https://366.ru/pravila_programmy/");
    }
}
