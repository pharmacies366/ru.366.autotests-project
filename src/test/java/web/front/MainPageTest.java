package web.front;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Проверка главной страницы сайта 36.6")
@DisplayName("Проверка главной страницы")
public class MainPageTest extends BaseSettingsWebTests {

    @DisplayName("Проверка отображения логотипа")
    @Test
    public void checkVisibilityLogoMainPage(){
        mainPage.getSiteLogo().elementIsVisibility();
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogoMainPage(){
        mainPage.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }
}
