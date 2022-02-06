package mobile.authorization;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя")
public class SignInPositive extends BaseSettingsMobileTests {

    @DisplayName("Авторизация пользователя на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        mobileCookiePage.reCaptchaKey();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToEmail();
        mobileAuthPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }

    @DisplayName("Авторизация пользователя на сайте по номеру телефона")
    @Test
    public void loginUserPhone() {
        mobileCookiePage.reCaptchaKey();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.getPhoneNumberInput().click();
        mobileAuthPopUpPage.setPhoneNumber(propertiesManager.getProperty("userauthphone"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserCardNumber() {
        mobileCookiePage.reCaptchaKey();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("userauthphone"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }

}
