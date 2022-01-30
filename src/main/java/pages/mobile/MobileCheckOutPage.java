package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MobileCheckOutPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileCheckOutPage.class);


    //элементы
    private static final String CHOOSE_DELIVERY_METHOD_XPATH = "xpath;(//span[contains(@class,'checkout_delivery_info__mark')])[2]";
    private static final String BASE_INPUT_DELIVERY_XPATH = "xpath;//input[@id='address%s']";
    private static final String Address = "";
    private static final String Entrance = "-entrance";
    private static final String Level = "-level";
    private static final String Flat = "-flat";
    private static final String BASE_INPUT_CONTACT_DETAILS_XPATH = "xpath;//input[@id='%s']";
    private static final String PhoneNumber = "phone";
    private static final String Fio = "fio";
    private static final String Email = "email";
    private static final String MAKE_ORDER_BUTTON_XPATH = "xpath;//button[contains(.,'Оформить заказ')]";



    //конструктор
    public MobileCheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getChooseDeliveryMethod() {
        return new PageElementActions(CHOOSE_DELIVERY_METHOD_XPATH, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMakeOrderButton() {
        return new PageElementActions(MAKE_ORDER_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Пользователь выбирает способ получения - Доставка")
    public void clickDeliveryMethod() {
        getChooseDeliveryMethod().click();
        saveAllureScreenshot();
    }

    @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String email, String phoneNumber, String fio) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        logger.info("Пользователь заполнил контактные данные");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на кнопку 'Сделать заказ'")
    public void clickMakeOrder(){
        getMakeOrderButton().click();
        logger.info("Пользователь нажимает на кнопку 'Сделать заказ'");
        saveAllureScreenshot();
    }



}