package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
@Tag("Regression")
public class ChangePasswordWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь изменяет пароль")
    @Test
    public void changePassword() {
        mainPage.clickClosePopUp();
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber8"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickChangePassword();
        changePasswordPage.clickChangePassword(
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("newuserpass"));
        changePasswordPage.clickChangeButton();
        changePasswordPage.getMessageAboutChangePassword();
        changePasswordPage.clickChangePassword(
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("olduserpass"));
        changePasswordPage.clickChangeButton();
        changePasswordPage.getMessageAboutChangePassword();
    }
}
