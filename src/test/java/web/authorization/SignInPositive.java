package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя")
public class SignInPositive extends BaseSettingsWebTests {

    @DisplayName("Авторизация пользователя на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.setChangeToEmail();
        authPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        mainPage.checkElementIsCorrect();
    }

    @DisplayName("Авторизация пользователя на сайте по номеру телефона")
    @Test
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("userauthphone"));
        authPopUpPage.clickToLoginButton();
        mainPage.checkElementIsCorrect();
    }

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserCardNumber() {
        cookiePage.reCaptchaKey();
        topPanelPage.clickToLoginIcon();
        authPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("userauthphone"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        mainPage.checkElementIsCorrect();
    }
}
