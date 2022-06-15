package mobile.cft;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


/**
 * @author Михаил
 */

@Feature(value = "Мобильная версия")
@Story("ЦФТ на сайте 36.6")
@DisplayName("Проверка работы ЦФТ на главной странице сайта 36.6")
@Tag("Regression")
@Tag("CFT")
public class CftOnMainPageMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка заднего фона кнопки с расчётом бонусов")
    @Description("Цвет заднего фона кнопки должен быть: #212121 - Синий")
    @Test
    public void checkBackgroundColorProductGalleryBonus() {
        String actualColor = mobileMainPage.getColorBackgroundProductGalleryButton();
        Assertions.assertEquals("#212121", actualColor);
    }

    @DisplayName("Проверка фона текста кнопки с расчётом бонусов")
    @Description("Цвет текста на фоне кнопки должен быть: #fff - Белый")
    @Test
    public void checkColorTextProductGalleryBonus() {
        String actualColor = mobileMainPage.getColorTextProductGalleryButton();
        Assertions.assertEquals("#ffffff", actualColor);
    }

    @DisplayName("Проверка окна с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на шильдик с бонусами, появляется окно с информацией по бонусам")
    @Test
    public void checkInfoProductGalleryBonus() {
        mobileMainPage.getTextColorProductGalleryButton().click();
        String actualText = mobileMainPage.getTextAboutCashBack();
        Assertions.assertEquals("Cash back за покупку", actualText);
    }

    @DisplayName("Проверка по URL релевантного перехода по ссылке во всплывающем окне с информацией по бонусам - Cash back за покупку")
    @Description("При нажатии на ссылку происходит переход на страницу с подробным описанием бонусных карт")
    @Test
    public void checkLinkInfoProductGalleryBonus() {
        mobileMainPage.clickOnButtonBonuses();
        mobileMainPage.clickOnLinkMoreAboutBonuses();
        pageActions.checkUrl("https://366.cwzw6gg24a-llcapteka1-s1-public.model-t.cc.commerce.ondemand.com/pravila_programmy/");
    }
}
