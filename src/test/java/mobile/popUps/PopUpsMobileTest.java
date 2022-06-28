package mobile.popUps;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка попапов на сайте 36.6")
@DisplayName("Проверка попапов на сайте 36.6")
@Tag("Mobile")
@Tag("Regression")
public class PopUpsMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка наличия и закрытия попапа с куки файлами")
    @Test
    public void checkCookiesPopUp(){
        mobileMainPage.clickCloseMobileAppPopUp();
    }

    @DisplayName("Проверка наличия и закрытия попапа для скачивания мобильного приложения")
    @Test
    public void checkMobileAppPopUp(){
        mobileMainPage.clickCloseMobileAppPopUp();
    }
}
