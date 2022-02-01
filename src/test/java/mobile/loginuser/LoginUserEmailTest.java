package mobile.loginuser;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Авторизация пользователя")
@DisplayName("Авторизация пользователя по E-mail")
public class LoginUserEmailTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь авторизовывается на сайте через E-mail")
    @Test
    public void loginUserEmail() {
        //mobileCookiePage.reCaptchaKey();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickToLoginIcon();
        mobileAuthPopUpPage.setChangeToEmail();
        mobileAuthPopUpPage.setEmailAndPassword(
                propertiesManager.getProperty("userauthmail"),
                propertiesManager.getProperty("userpass"));
        mobileAuthPopUpPage.clickToLoginButton();
        pageActions.waitPageLoad();
        mobileMainPage.checkElementIsCorrect();
    }
}
