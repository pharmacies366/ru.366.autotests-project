package mobile.authorization;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя на сайте 36.6")
@DisplayName("Авторизация пользователя")
public class SignInPositiveMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Авторизация пользователя на сайте по номеру телефона и паролю")
    @Test
    public void loginUserPhoneNumberAndPassword() {
        mobileCookiePage.reCaptchaKey();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneAndPassword(
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }

    /*    @DisplayName("Авторизация пользователя на сайте через E-mail")
     *//*работает только для старых пользователей у которых нет номера телефона
    нужно каждый раз как то создавать предварительно такого пользователя
    так как тест отработает только 1 раз и нужно будет ввести номер телефона*//*
    @Test
    public void loginUserEmail() {
        mobileCookiePage.reCaptchaKey();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToEmail();
        mobileAuthPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }*/


/*    @DisplayName("Авторизация пользователя на сайте по номеру телефона")
    // Нужно как то отлавливать код, который приходит на телефон
    @Test
    public void loginUserPhone() {
        mobileCookiePage.reCaptchaKey();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileAuthPopUpPage.getPhoneNumberInput().click();
        mobileAuthPopUpPage.setPhoneNumber(propertiesManager.getProperty("userauthphone"));
        mobileAuthPopUpPage.clickToLoginButton();
        mobileMainPage.checkElementIsCorrect();
    }*/

}
