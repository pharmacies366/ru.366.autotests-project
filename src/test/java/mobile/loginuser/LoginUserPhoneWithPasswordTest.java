package mobile.loginuser;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по номеру телефона и паролю")
public class LoginUserPhoneWithPasswordTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь авторизовывается на сайте по номеру телефона и паролю")
    @Test
    public void loginUserCardNumber() {
        mobileCookiePage.reCaptchaKey();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setPhoneAndPassword(propertiesManager.getProperty("userauthphone"), "userpass");
        mobileAuthPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkElementIsCorrect();
    }
}
