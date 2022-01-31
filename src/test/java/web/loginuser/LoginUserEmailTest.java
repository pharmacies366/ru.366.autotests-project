package web.loginuser;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по E-mail")
public class LoginUserEmailTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь авторизовывается на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.setChangeToEmail();
        authPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mainPage.checkElementIsCorrect();
    }
}
