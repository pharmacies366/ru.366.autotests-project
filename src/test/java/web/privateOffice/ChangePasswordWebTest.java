package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
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
