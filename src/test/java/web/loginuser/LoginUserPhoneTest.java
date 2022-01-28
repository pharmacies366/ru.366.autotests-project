package web.loginuser;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру телефона")
public class LoginUserPhoneTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру телефона")
    @Test
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("userauthphone"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mainPage.checkElementIsCorrect();
    }

}
