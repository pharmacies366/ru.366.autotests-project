package pages.web.privateOffice;

import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalDataPage {

    //элементы
    private final Button BASE_INPUT_PERSONAL_DATA = new Button($x( "//input[@id='%s']"));
    private final Button BASE_INPUT_OPTIONS = new Button($x( "(//a[@href='%s'])[4]"));
    private final String FIRST_NAME = "profile.firstName";
    private final String LAST_NAME = "profile.lastName";
    private final String PATRONYMIC = "profile.middleName";
    private final String EMAIL = "profile.email";
    private final Button BASE_INPUT_GENDER = new Button($x( "//input[@value='%s']"));
    private final Button MALE_BUTTON = new Button($x( "//input[@value='MALE']"));
    private final Button FEMALE_BUTTON = new Button($x( "//input[@value='FEMALE']"));
    private final Button PHONE_NUMBER = new Button($x( "//input[contains(@id,'profile.phone')]"));
    private final Button CHECKBOX_NEWS = new Button($x( "//span[@class='b-custom-input--special']"));
    private final Button CHECKBOX_SELECTED = new Button($x( "//input[@type='checkbox' and @checked]"));
    private final Button CHECKBOX_UNSELECTED = new Button($x( "//input[@type='checkbox' and not(@checked)]"));
    private final Button SAVE_BUTTON = new Button($x( "//button[@class='b-btn']"));
    private final Button LINK_CARD_BUTTON = new Button($x( "(//a[@class='b-btn js-bind-loyalty-card'])[2]"));
    private final Button ERROR_NAME_MESSAGE = new Button($x( "//label[contains(@class,'b-text--error')]"));
    private final String ErrorNameMessage = "Это поле необходимо заполнить";
    private final Button ERROR_EMAIL_MESSAGE = new Button($x( "//label[contains(@class,'b-text--error')]"));
    private final String ErrorEmailMessage = "Введите корректный адрес эл.почты";
    private final Button DAY = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[1]"));
    private final Button SELECT_DAY = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[1]//option[@value='%s']"));
    private final Button MONTH = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[2]"));
    private final Button SELECT_MONTH = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[2]//option[contains(text(),'%s')]"));
    private final Button YEAR = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[3]"));
    private final Button SELECT_YEAR = new Button($x( "(//form[@id='updateProfileResForm']//div[@class='b-select-wr'])[3]//option[contains(@value,'%s')]"));


    //Методы

/*    @Step("Кликает по локатору {LOCATOR}")
    public PersonalDataPage selectPersonalDataButtons(String LOCATOR) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, LOCATOR)).click();
        return this;
    }

    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public PersonalDataPage checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
        return this;
    }

    @Step("Пользователь заполняет фамилию и отчество")
    public PersonalDataPage personalDetails(String lastName, String patronymic) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA, LastName)).sendKeys(lastName);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA, Patronymic)).sendKeys(patronymic);
       // logger.info("Пользователь заполняет фамилию и отчество");
        return this;
    }

    @Step("Пользователь нажимает кнопку сохранить")
    public PersonalDataPage ckickSaveButton() {
        SAVE_BUTTON.click();
      //  logger.info("Пользователь нажимает кнопку сохранить");
        return this;
    }

    @Step("Пользователь проверяет, что фамилия и отчество сохранились корректно")
    public PersonalDataPage checkSavePersonalData() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("class", "form-control valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("class", "form-control valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("value", propertiesManager.getProperty("lastname"));
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("value", propertiesManager.getProperty("patronymic"));
       // logger.info("Пользователь проверяет, что фамилия и отчество сохранились корректно");
        return this;
    }

    @Step("Пользователь проверяет, что поля фамилии и отчества очистились сохранились пустыми")
    public PersonalDataPage checkClearPersonalData() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("class", "form-control  ");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("class", "form-control  ");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).checkAttribute("value", "");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).checkAttribute("value", "");
      //  logger.info("Пользователь проверяет, что поля фамилии и отчества очистились сохранились пустыми");
        return this;
    }


    @Step("Пользователь очищает поля фамилии и отчества")
    public PersonalDataPage clearLastNameAndPatronymic() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, LastName)).clean();
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Patronymic)).clean();
      //  logger.info("Пользователь очищает поля фамилии и отчества");
        return this;
    }

    @Step("Пользователь очищает поля имя")
    public PersonalDataPage clearName() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).clean();
       // logger.info("Пользователь очищает поля имя");
        return this;
    }

    @Step("Пользователь вводит новое имя")
    public PersonalDataPage sendName(String name) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).sendKeys(name);
       // logger.info("Пользователь вводит новое имя");
        return this;
    }

    @Step("Пользователь проверяет, что имя изменилось и сохранилось корректно")
    public PersonalDataPage checkNewName(String name) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).checkAttribute("class", "form-control js-validate--simple valid");
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName)).checkAttribute("value", name);
      //  logger.info("Пользователь проверяет, что имя изменилось и сохранилось корректно");
        return this;
    }

    @Step("Пользователь получает ошибку")
    public PersonalDataPage gettingErrorWithName() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, FirstName))
                .checkAttribute("class", "form-control js-validate--simple b-text--error");
        String message = getErrorNameMessage().getText();
        Assert.assertEquals(ErrorNameMessage, message);
       // logger.info("Пользователь получает ошибку");
        return this;
    }

    @Step("Пользователь установливает новую дату рождения")
    public PersonalDataPage changeBirthday(String Birthday, String MonthOfBirth, String YearOfBirth) {
        getDay().click();
        getBaseSelectDay(String.format(SELECT_DAY_XPATH, Birthday)).click();
        getMonth().click();
        getBaseSelectMonth(String.format(SELECT_MONTH_XPATH, MonthOfBirth)).click();
        getYear().click();
        getBaseSelectYear(String.format(SELECT_YEAR_XPATH, YearOfBirth)).click();
      //  logger.info("Пользователь установливает новую дату рождения");
        return this;
    }

    @Step("Пользователь изменяет пол на {Gender}")
    public PersonalDataPage changeGender(String Gender) {
        getBaseInputGender(String.format(BASE_INPUT_GENDER_XPATH, Gender)).click();
       // logger.info("Пользователь изменяет пол на {Gender}");
        return this;
    }

    @Step("Пользователь очищает поля Email")
    public PersonalDataPage clearEmail() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Email)).clean();
       // logger.info("Пользователь очищает поля Email");
        return this;
    }

    @Step("Пользователь получает ошибку")
    public PersonalDataPage gettingErrorWithEmail() {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PERSONAL_DATA_XPATH, Email))
                .checkAttribute("class", "form-control b-text--error ");
        String message = getErrorEmailMessage().getText();
        Assert.assertEquals(ErrorEmailMessage, message);
      //  logger.info("Пользователь получает ошибку");
        return this;
    }

    @Step("Пользователь проверяет, что поле телефона доступно только на чтение")
    public PersonalDataPage checkPhone() {
        PHONE_NUMBER.checkAttribute("readonly", "true");
      //  logger.info("Пользователь проверяет, что поле телефона доступно только на чтение");
        return this;
    }

    @Step("Пользователь нажимает на чекбокс для получения новостной рассылки")
    public PersonalDataPage clickReceiveNews() {
        CHECKBOX_NEWS.click();
        //logger.info("Пользователь нажимает на чекбокс для получения новостной рассылки");
        return this;
    }

    @Step("Пользователь проверяет, что чекбокс с рассылкой установлен")
    public PersonalDataPage checkSelectedCheckboxReceiveNews() {
        CHECKBOX_SELECTED.isElementVisible();
        //logger.info("Пользователь проверяет, что чекбокс с рассылкой установлен");
        return this;
    }

    @Step("Пользователь проверяет, что чекбокс с рассылкой не установлен")
    public PersonalDataPage checkNotSelectedCheckboxReceiveNews() {
        CHECKBOX_UNSELECTED.isElementVisible();
       // logger.info("Пользователь проверяет, что чекбокс с рассылкой не установлен");
        return this;
    }*/


}
