package mobile.privateOffice;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


@Feature(value = "Мобильная версия")
@Story(value = "Личный кабинет на сайте 36.6")
@DisplayName("Личный кабинет")
//@RunWith(DataProviderRunner.class)
@Tag("Regression")
@Tag("Mobile")
public class PersonalDataMobileTest extends BaseSettingsMobileTests{

    @ParameterizedTest(name = "{index} {1}")
    @MethodSource("checkDisplayedOptions")
    public void checkDisplayedOptions(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
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
    }

    private static Stream<Arguments> checkDisplayedOptions() {
        return Stream.of(
                Arguments.of("/my-account/orders", "Мои заказы", "Мои заказы"),
                Arguments.of("/my-account/profile", "Личные данные", "Личные данные"),
                Arguments.of("/my-account/update-password", "Изменить пароль", "Изменить пароль"),
                Arguments.of("/favorites", "Избранное", "Избранное"),
                Arguments.of("/my-account/invite-friend", "Приведи друга", "Приведи друга"),
                Arguments.of("/logout/", "Выйти", "Как сделать заказ")
        );
    }

    @DisplayName("Пользователь заполняет фамилию и отчество и сохраняет данные")
    @Test
    public void checkPersonalData() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
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
    public void clearPersonalData() {
        mobileHeaderBlock.clickBurgerButton();
        mobileMainPopUpBlock.clickToLoginIcon();
        mobileCookiePage.reCaptchaKey();
        mobileAuthPopUpPage.authorizeWithPhoneAndPassword(
                propertiesManager.getProperty("mobilephonenumber7"),
                propertiesManager.getProperty("userpass"));
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
