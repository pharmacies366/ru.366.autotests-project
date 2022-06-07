package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
//@RunWith(DataProviderRunner.class)
@Tag("Regression")
public class PersonalDataMobileTest extends BaseSettingsMobileTests{

/*    @DataProvider
    public static Object[][] checkDisplaedOptions() {
        return new Object[][]{
                {"/my-account/orders", "Мои заказы", "Мои заказы"},
                {"/my-account/profile", "Личные данные", "Личные данные"},
                {"/my-account/update-password", "Изменить пароль", "Изменить пароль"},
                {"/favorites", "Избранное", "Избранное"},
               // {"/my-account/invite-friend", "Приведи друга", "Приведи друга"},
                {"/logout/", "Выйти", "Как сделать заказ"}
        };
    }

    @DisplayName("Пользователь переходит в личный кабинет и проверяет отображения списка с пунктами страниц в Л.К." +
            " и релевантный переход")
    @Step("В личном кабинете переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("checkDisplaedOptions")
    public void checkDisplaedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileCartPage.checkAndClearCartQuantity();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobilePersonalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobilePersonalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }*/

    @DisplayName("Пользователь заполняет фамилию и отчество и сохраняет данные")
    @Test
    public void checkPersonalDeta() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearLastNameAndPatronymic();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.personalDetails(
                propertiesManager.getProperty("lastname"),
                propertiesManager.getProperty("patronymic"));
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkSavePersonalData();
    }

    @DisplayName("Пользователь очищает поля фамилии и отчества и сохраняет данные")
    @Test
    public void clearPersonalDeta() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearLastNameAndPatronymic();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkClearPersonalData();
    }

    @DisplayName("Пользователь очищает поля имя и получает ошибку")
    @Test
    public void clearNameAndGettingError() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithName();
    }

    @DisplayName("Пользователь изменяет и сохраняет имя")
    @Test
    public void chanchName() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.sendName("Alex");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNewName("Alex");
        mobilePersonalDataPage.clearName();
        mobilePersonalDataPage.sendName("Ivan");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNewName("Ivan");
    }

    @DisplayName("Пользователь изменяет дату рождения")
    @Test
    public void changeBirthday() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeBirthday("12","Апрель","1994");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.changeBirthday("1","Февраль","1993");//Возврашаем в исходную дату
        mobilePersonalDataPage.ckickSaveButton();
    }

    @DisplayName("Пользователь изменяет пол")
    @Test
    public void changeGender() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.changeGender("FEMALE");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.getFemaleButton().checkAttribute("value", "FEMALE");
        mobilePersonalDataPage.changeGender("MALE");
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }

    @DisplayName("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    @Test
    public void clearEmail() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clearEmail();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.gettingErrorWithEmail();
    }

    @DisplayName("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    @Test
    public void checkPhone() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.checkPhone();
    }

    @DisplayName("Проверка чекбокса с новостной рассылкой")
    @Test
    public void checkReceiveNews() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
        pageActions.waitPageLoad();
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToPersonalAccount();
        mobileMainPopUpBlock.clickPersonalData();
        mobilePersonalDataPage.clickReceiveNews();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkSelectedCheckboxReceiveNews();
        mobilePersonalDataPage.clickReceiveNews();
        mobilePersonalDataPage.ckickSaveButton();
        mobilePersonalDataPage.checkNotSelectedCheckboxReceiveNews();
    }

}
