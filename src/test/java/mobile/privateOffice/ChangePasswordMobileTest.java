package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
@Tag("Regression")
public class ChangePasswordMobileTest extends BaseSettingsMobileTests{

    @DisplayName("Пользователь изменяет пароль")
    @Test
    public void changePassword() {
       // mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber8"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobilePersonalAccountPage.clickChangePassword();
        mobileChangePasswordPage.clickChangePassword(
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("newuserpass"));
        mobileChangePasswordPage.clickChangeButton();
       // mobileChangePasswordPage.getMessageAboutChangePassword();
        mobileChangePasswordPage.clickChangePassword(
                propertiesManager.getProperty("newuserpass"),
                propertiesManager.getProperty("olduserpass"),
                propertiesManager.getProperty("olduserpass"));
        mobileChangePasswordPage.clickChangeButton();
      //  mobileChangePasswordPage.getMessageAboutChangePassword();
    }
}
