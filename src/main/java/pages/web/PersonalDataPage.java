package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PersonalDataPage extends MainTestBase {
    //элементы
    private static final String BASE_INPUT_PERSONAL_DATA_XPATH = "xpath;//input[@id='%s'";

    private static final String Name = "profile.firstName";
    private static final String LastName = "profile.lastName";
    private static final String Patronymic = "middleName";
    private static final String Email = "profile.email";


    //конструктор
    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputDelivery(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы

   /* @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String fio, String phoneNumber, String email ) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        logger.info("Пользователь заполнил контактные данные");
    }*/
}
