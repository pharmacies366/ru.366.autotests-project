package mobile.front;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import pages.web.MainPage;

@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта")
@DisplayName("Проверка главной страницы")
public class MainPageTest extends BaseSettingsMobileTests {
    private Logger logger = LogManager.getLogger(MainPage.class);

    @DisplayName("Проверка отображения логотипа")
    @Test
    public void checkVisibilityLogoMainPage(){
        mobileMainPage.getSiteLogo().elementIsVisibility();
        logger.info("Логотип отображается на сайте");
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogoMainPage(){
        mobileMainPage.getSiteLogo().elementIsClickable();
        logger.info("Логотип кликабелен");
    }
}
