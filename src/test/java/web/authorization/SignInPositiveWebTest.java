package web.authorization;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story("Авторизация пользователя на сайте 36.6")
@DisplayName("Авторизация пользователя")
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

    /*    @DisplayName("Авторизация пользователя на сайте через E-mail")
     *//*  работает только для старых пользователей у которых нет номера телефона
    нужно каждый раз как то создавать предварительно такого пользователя
    так как тест отработает только 1 раз и нужно будет ввести номер телефона*//*
    @Test
    public void loginUserEmail() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.setChangeToEmail();
        authPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("usermail"),
                propertiesManager.getProperty("userpass"));
        authPopUpPage.clickToLoginButton();
        headerBlock.checkElementIsCorrect();
    */

/*    @DisplayName("Авторизация пользователя на сайте по номеру телефона")
// Нужно как то отлавливать код, который приходит на телефон
    @Test
    public void loginUserPhone() {
        cookiePage.reCaptchaKey();
        headerBlock.clickToSignInButton();
        authPopUpPage.getPhoneNumberInput().click();
        authPopUpPage.setPhoneNumber(propertiesManager.getProperty("phonenumber"));
        authPopUpPage.clickToLoginButton();
        headerBlock.checkElementIsCorrect();
    }*/

}
