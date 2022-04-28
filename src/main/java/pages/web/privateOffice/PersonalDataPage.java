package pages.web.privateOffice;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_PERSONAL_DATA_XPATH = "xpath;//input[@id='%s']";
    private static final String BASE_INPUT_OPTIONS_XPATH = "xpath;(//a[@href='%s'])[4]";
    private static final String FirstName = "profile.firstName";
    private static final String LastName = "profile.lastName";
    private static final String Patronymic = "profile.middleName";
    private static final String Email = "profile.email";
    private static final String BASE_INPUT_GENDER_XPATH = "xpath;//input[@value='%s']";
    private static final String MALE_BUTTON_XPATH = "xpath;//input[@value='MALE']";
    private static final String FEMALE_BUTTON_XPATH = "xpath;//input[@value='FEMALE']";
    private static final String PHONE_NUMBER_XPATH = "xpath;//input[contains(@id,'profile.phone')]";
    private static final String CHECKBOX_NEWS_XPATH = "xpath;//span[@class='b-custom-input--special']";
    private static final String CHECKBOX_SELECTED_XPATH = "xpath;//input[@type='checkbox' and @checked]";
    private static final String CHECKBOX_UNSELECTED_XPATH = "xpath;//input[@type='checkbox' and not(@checked)]";
    private static final String SAVE_BUTTON_XPATH = "xpath;//button[@class='b-btn']";
    private static final String LINK_CARD_BUTTON_XPATH = "xpath;(//a[@class='b-btn js-bind-loyalty-card'])[2]";
    private static final String ERROR_NAME_MESSAGE_XPATH = "xpath;//label[contains(@class,'b-text--error')]";
    private static final String ErrorNameMessage = "Это поле необходимо заполнить";
    private static final String ERROR_EMAIL_MESSAGE_XPATH = "xpath;//label[contains(@class,'b-text--error')]";
    private static final String ErrorEmailMessage = "Введите корректный адрес эл.почты";
    private static final String DAY_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[1]";
    private static final String SELECT_DAY_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[1]//option[@value='%s']";
    private static final String MONTH_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[2]";
    private static final String SELECT_MONTH_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[2]//option[contains(text(),'%s')]";
    private static final String YEAR_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[3]";
    private static final String SELECT_YEAR_XPATH = "xpath;(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[3]//option[contains(@value,'%s')]";


    //конструктор
    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputBasementLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputePrsonalDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputGender(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMaleButton() {
        return new PageElementActions(MALE_BUTTON_XPATH, driver);
    }

    public PageElementActions getFemaleButton() {
        return new PageElementActions(FEMALE_BUTTON_XPATH, driver);
    }

    public PageElementActions getPhoneNumber() {
        return new PageElementActions(PHONE_NUMBER_XPATH, driver);
    }

    public PageElementActions getCheckboxNews() {
        return new PageElementActions(CHECKBOX_NEWS_XPATH, driver);
    }

    public PageElementActions getSaveButton() {
        return new PageElementActions(SAVE_BUTTON_XPATH, driver);
    }

    public PageElementActions getLinkCardButton() {
        return new PageElementActions(LINK_CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getErrorEmailMessage() {
        return new PageElementActions(ERROR_EMAIL_MESSAGE_XPATH, driver);
    }
    public PageElementActions getErrorNameMessage() {
        return new PageElementActions(ERROR_NAME_MESSAGE_XPATH, driver);
    }

    public PageElementActions getDay() {
        return new PageElementActions(DAY_XPATH, driver);
    }

    public PageElementActions getMonth() {
        return new PageElementActions(MONTH_XPATH, driver);
    }

    public PageElementActions getYear() {
        return new PageElementActions(YEAR_XPATH, driver);
    }

    public PageElementActions getBaseSelectYear(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseSelectMonth(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseSelectDay(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getCheckboxSelected() {
        return new PageElementActions(CHECKBOX_SELECTED_XPATH, driver);
    }

    public PageElementActions getCheckboxUnSelected() {
        return new PageElementActions(CHECKBOX_UNSELECTED_XPATH, driver);
    }

    //Методы

    @Step("Кликает по локатору {LOCATOR}")
    public void selectPersonalDataButtons(String LOCATOR) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, LOCATOR)).click();
    }

    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public void checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
    }

    @Step("Пользователь заполняет фамилию и отчество")
    public void personalDetails(String lastName, String patronymic) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).sendKeys(lastName);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).sendKeys(patronymic);
        logger.info("Пользователь заполняет фамилию и отчество");
    }

    @Step("Пользователь нажимает кнопку сохранить")
    public void ckickSaveButton() {
        getSaveButton().click();
        logger.info("Пользователь нажимает кнопку сохранить");
    }

    @Step("Пользователь проверяет, что фамилия и отчество сохранились корректно")
    public void checkSavePersonalData() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("class", "form-control valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("class", "form-control valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("value", propertiesManager.getProperty("lastname"));
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("value", propertiesManager.getProperty("patronymic"));
        logger.info("Пользователь проверяет, что фамилия и отчество сохранились корректно");
    }

    @Step("Пользователь проверяет, что поля фамилии и отчества очистились сохранились пустыми")
    public void checkClearPersonalData() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("class", "form-control  ");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("class", "form-control  ");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("value", "");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("value", "");
        logger.info("Пользователь проверяет, что поля фамилии и отчества очистились сохранились пустыми");
    }


    @Step("Пользователь очищает поля фамилии и отчества")
    public void clearLastNameAndPatronymic() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).clean();
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).clean();
        logger.info("Пользователь очищает поля фамилии и отчества");
    }

    @Step("Пользователь очищает поля имя")
    public void clearName() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).clean();
        logger.info("Пользователь очищает поля имя");
    }

    @Step("Пользователь вводит новое имя")
    public void sendName(String name) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).sendKeys(name);
        logger.info("Пользователь вводит новое имя");
    }

    @Step("Пользователь проверяет, что имя изменилось и сохранилось корректно")
    public void checkNewName(String name) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).checkAttribute("class", "form-control js-validate--simple valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).checkAttribute("value", name);
        logger.info("Пользователь проверяет, что имя изменилось и сохранилось корректно");
    }

    @Step("Пользователь получает ошибку")
    public void gettingErrorWithName() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName))
                .checkAttribute("class", "form-control js-validate--simple b-text--error");
        String message = getErrorNameMessage().getText();
        Assert.assertEquals(ErrorNameMessage, message);
        logger.info("Пользователь получает ошибку");
    }

    @Step("Пользователь установливает новую дату рождения")
    public void changeBirthday(String Birthday, String MonthOfBirth, String YearOfBirth) {
        getDay().click();
        getBaseSelectDay(String.format(SELECT_DAY_XPATH, Birthday)).click();
        getMonth().click();
        getBaseSelectMonth(String.format(SELECT_MONTH_XPATH, MonthOfBirth)).click();
        getYear().click();
        getBaseSelectYear(String.format(SELECT_YEAR_XPATH, YearOfBirth)).click();
        logger.info("Пользователь установливает новую дату рождения");
    }

    @Step("Пользователь изменяет пол на {Gender}")
    public void changeGender(String Gender) {
        getBaseInputGender(String.format(BASE_INPUT_GENDER_XPATH, Gender)).click();
        logger.info("Пользователь изменяет пол на {Gender}");
    }

    @Step("Пользователь очищает поля Email")
    public void clearEmail() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Email)).clean();
        logger.info("Пользователь очищает поля Email");
    }

    @Step("Пользователь получает ошибку")
    public void gettingErrorWithEmail() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Email))
                .checkAttribute("class", "form-control b-text--error ");
        String message = getErrorEmailMessage().getText();
        Assert.assertEquals(ErrorEmailMessage, message);
        logger.info("Пользователь получает ошибку");
    }

    @Step("Пользователь проверяет, что поле телефона доступно только на чтение")
    public void checkPhone() {
        getPhoneNumber().checkAttribute("readonly", "true");
        logger.info("Пользователь проверяет, что поле телефона доступно только на чтение");
    }

    @Step("Пользователь нажимает на чекбокс для получения новостной рассылки")
    public void clickReceiveNews() {
        getCheckboxNews().click();
        logger.info("Пользователь нажимает на чекбокс для получения новостной рассылки");
    }

    @Step("Пользователь проверяет, что чекбокс с рассылкой установлен")
    public void checkSelectedCheckboxReceiveNews() {
        getCheckboxSelected().isElementVisible();
        logger.info("Пользователь проверяет, что чекбокс с рассылкой установлен");
    }

    @Step("Пользователь проверяет, что чекбокс с рассылкой не установлен")
    public void checkNotSelectedCheckboxReceiveNews() {
        getCheckboxUnSelected().isElementVisible();
        logger.info("Пользователь проверяет, что чекбокс с рассылкой не установлен");
    }


}
