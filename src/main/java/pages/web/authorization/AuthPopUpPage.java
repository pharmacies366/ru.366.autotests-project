package pages.web.authorization;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;


public class AuthPopUpPage {

    //элементы
    private final Button PHONE_NUMBER_INPUT = new Button($x( "//input[@id='login-phone']"));
    private final Button GO_PASSWORD_INPUT = new Button($x( "//div[contains(@class,'popup_login_link js-auth-ext__button')]"));
    private final Button PASSWORD_INPUT = new Button($x(  "//input[@id='login-pass']"));
    private final Button CHANGE_TO_EMAIL = new Button($x(  "//a[contains(.,'E-mail')]"));
    private final Button AUTH_EMAIL = new Button($x(  "//input[@id='login-email']"));
    private final Button LOGIN_BUTTON = new Button($x(  "//button[contains(.,'Войти')]"));

    //Методы

    @Step("Пользователь переключается на вход по Email")
    public AuthPopUpPage setChangeToEmail() {
        CHANGE_TO_EMAIL.click();
        return this;
    }

    @Step("Пользователь вводит номер телефона")
    public AuthPopUpPage setPhoneNumber(String phoneNumber) {
        PHONE_NUMBER_INPUT.sendKeys(phoneNumber);
        return this;
    }

    @Step("Пользователь вводит номер телефона и пароль")
    public AuthPopUpPage setPhoneAndPassword(String phone, String password) {
        PHONE_NUMBER_INPUT.sendKeys(phone);
        GO_PASSWORD_INPUT.click();
        PASSWORD_INPUT.sendKeys(password);
        return this;
    }

    @Step("Пользователь вводит Email и пароль")
    public AuthPopUpPage setEmailAndPassword(String email, String password) {
        AUTH_EMAIL.sendKeys(email);
        GO_PASSWORD_INPUT.sendKeys(password);
        return this;
    }

    @Step("клик на кнопку \"войти\"")
    public AuthPopUpPage clickToLoginButton() {
        LOGIN_BUTTON.click();
        return this;
    }

    @Step("Пользователь вводит номер телефона, пароль и нажимает войти")
    public AuthPopUpPage authorizeWithPhoneAndPassword(String phone, String password) {
        PHONE_NUMBER_INPUT.clear();
        PHONE_NUMBER_INPUT.sendKeys(phone);
        GO_PASSWORD_INPUT.click();
        PASSWORD_INPUT.clear();
        PASSWORD_INPUT.sendKeys(password);
        clickToLoginButton();
        return this;
    }


}
