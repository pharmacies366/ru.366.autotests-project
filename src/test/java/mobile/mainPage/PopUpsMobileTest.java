package mobile.mainPage;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Проверка куки попапов 36.6")
@DisplayName("Проверка куки попапов")
public class PopUpsMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Проверка отображения и закрытия попапа с куки файлами")
    @Test
    public void checkCloseCookiePopUp() {
        mobileMainPage.getPopUpButton().isElementDisplayed();
        mobileMainPage.clickClosePopUp();
    }

   /* @DisplayName("Проверка отображения и закрытия попапа мобильного приложения")
    @Test
    public void checkCloseMobileAppPopUp() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.getMobileAppPopUpButton().isElementDisplayed();
        mobileMainPage.clickCloseMobileAppPopUp();
    }*/
}
