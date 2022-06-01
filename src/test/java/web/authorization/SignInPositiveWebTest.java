package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя на сайте 36.6")
@DisplayName("Авторизация пользователя")
@Tag("Regression")
public class SignInPositiveWebTest extends BaseSettingsWebTests {

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserPhoneNumberAndPassword() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        headerBlock.checkElementIsCorrect();
    }

}
