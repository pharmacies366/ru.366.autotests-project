/*
package web.privateOffice;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature(value = "Web")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
@RunWith(DataProviderRunner.class)
@Tag("Web")
@Tag("Regression")
public class PersonalDataWebTest extends BaseSettingsWebTests {

/*    @DataProvider
    public static Object[][] checkDisplayedOptions() {
        return new Object[][]{
                {"/my-account/orders", "Мои заказы", "Мои заказы"},
                {"/my-account/profile", "Личные данные", "Личные данные"},
                {"/my-account/update-password", "Изменить пароль", "Изменить пароль"},
                {"/favorites", "Избранное", "Избранное"},
                //{"/my-account/invite-friend", "Приведи друга", "Приведи друга"},
                 {"/logout/", "Выйти", "Как сделать заказ"}
        };
    }

    @DisplayName("Пользователь переходит в личный кабинет и проверяет отображения списка с пунктами страниц в Л.К." +
            " и релевантный переход")
    @Step("В личном кабинете переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("checkDisplayedOptions")
    public void checkDisplayedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        cartPage.checkAndClearCartQuantity();
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        personalDataPage.selectPersonalDataButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }*/

    @DisplayName("Пользователь заполняет фамилию и отчество и сохраняет данные")
    @Test
    public void checkPersonalData() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearLastNameAndPatronymic();
        personalDataPage.clickSaveButton();
        personalDataPage.personalDetails(
                propertiesManager.getProperty("lastname"),
                propertiesManager.getProperty("patronymic"));
        personalDataPage.clickSaveButton();
        personalDataPage.checkSavePersonalData();
    }

    @DisplayName("Пользователь очищает поля фамилии и отчества и сохраняет данные")
    @Test
    public void clearPersonalData() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearLastNameAndPatronymic();
        personalDataPage.clickSaveButton();
        personalDataPage.checkClearPersonalData();
    }

    @DisplayName("Пользователь очищает поля имя и получает ошибку")
    @Test
    public void clearNameAndGettingError() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearName();
        personalDataPage.clickSaveButton();
        personalDataPage.gettingErrorWithName();
    }

    @DisplayName("Пользователь изменяет и сохраняет имя")
    @Test
    public void changeName() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearName();
        personalDataPage.sendName("Alex");
        personalDataPage.clickSaveButton();
        personalDataPage.checkNewName("Alex");
        personalDataPage.clearName();
        personalDataPage.sendName("Ivan");
        personalDataPage.clickSaveButton();
        personalDataPage.checkNewName("Ivan");
    }

    @DisplayName("Пользователь изменяет дату рождения")
    @Test
    public void changeBirthday() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeBirthday("12","Апрель","1994");
        personalDataPage.clickSaveButton();
        personalDataPage.changeBirthday("1","Февраль","1993");//Возврашаем в исходную дату
        personalDataPage.clickSaveButton();
    }

    @DisplayName("Пользователь изменяет пол")
    @Test
    public void changeGender() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.changeGender("FEMALE");
        personalDataPage.clickSaveButton();
        personalDataPage.getFemaleButton().checkAttribute("value", "FEMALE");
        personalDataPage.changeGender("MALE");
        personalDataPage.clickSaveButton();
        personalDataPage.getMaleButton().checkAttribute("value", "MALE");
    }

    @DisplayName("Пользователь очищает поля email, нажимает сохранить и получает ошибку")
    @Test
    public void clearEmail() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clearEmail();
        personalDataPage.clickSaveButton();
        personalDataPage.gettingErrorWithEmail();
    }

    @DisplayName("Пользователь проверяет, что поле с номером телефона нельзя редактировать")
    @Test
    public void checkPhone() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.checkPhone();
    }

    @DisplayName("Проверка чекбокса с новостной рассылкой")
    @Test
    public void checkReceiveNews() {
        headerBlock.clickToSignInButton();
        cookiePage.reCaptchaKey();
        authPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("phonenumber7"),
                propertiesManager.getProperty("userpass"));
        headerBlock.clickToPersonalAccount();
        headerBlock.clickPersonalData();
        personalDataPage.clickReceiveNews();
        personalDataPage.clickSaveButton();
        personalDataPage.checkSelectedCheckboxReceiveNews();
        personalDataPage.clickReceiveNews();
        personalDataPage.clickSaveButton();
        personalDataPage.checkNotSelectedCheckboxReceiveNews();
    }

}
*/
