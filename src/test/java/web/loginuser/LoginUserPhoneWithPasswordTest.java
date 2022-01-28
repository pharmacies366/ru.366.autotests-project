package web.loginuser;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру Бонусной карты")
public class LoginUserPhoneWithPasswordTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру телефона и паролю")
    @Test
    public void loginUserCardNumber() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.setPhoneAndPassword(propertiesManager.getProperty("userauthphone"), "userpass");
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mainPage.checkElementIsCorrect();
    }
}
