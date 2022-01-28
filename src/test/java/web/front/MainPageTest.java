package web.front;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import pages.web.MainPage;

@Feature(value = "Web")
@Story("Проверка главной страницы сайта")
@DisplayName("Проверка главной страницы")
public class MainPageTest extends BaseSettingsWebTests {
    private Logger logger = LogManager.getLogger(MainPage.class);

    @DisplayName("Проверка отображения логотипа")
    @Test
    public void checkVisibilityLogoMainPage(){
        mainPage.getSiteLogo().elementIsVisibility();
        logger.info("Логотип отображается на сайте");
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogoMainPage(){
        mainPage.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }
}
