package pages.web.checkout;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends MainTestBase{


    //элементы
    private static final String BASE_INPUT_CONTACT_DETAILS_XPATH = "xpath;//input[@id='%s']";
    private static final String Fio = "fio";
    private static final String PhoneNumber = "phone";
    private static final String Email = "email";
    private static final String BASE_INPUT_DELIVERY_XPATH = "xpath;//input[@id='address%s']";
    private static final String Address = "";
    private static final String Entrance = "-entrance";
    private static final String Level = "-level";
    private static final String Flat = "-flat";
    private static final String CHOOSE_DELIVERY_METHOD_XPATH = "xpath;(//span[contains(@class,'checkout_delivery_info__mark')])[2]";
    private static final String FINAL_BUY_BUTTON_XPATH = "xpath;//button[contains(.,'Оформить заказ')]";
    private static final String INPUT_PHONE_NUMBER_XPATH = "xpath;//input[@name='phone']";
    private static final String BOOKING_BUTTON_XPATH = "xpath;//input[@value='Забронировать']";
    private static final String SELECT_APTEKA_XPATH = "xpath;//span[contains(.,'Выбрать аптеку')]";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//span[contains(.,'Списком')]";
    private static final String AVAILABILITY_XPATH= "xpath;(//span[contains(.,'Узнать о наличии')])[1]";
    private static final String CHOOSE_THIS_PHARMACY_XPATH = "xpath;(//span[contains(.,'Выбрать эту аптеку')])[1]";
    private static final String MAKE_ORDER_BUTTON_XPATH = "xpath;(//button[contains(.,'Оформить заказ')])[1]";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PICKAP_RADIO_BUTTON_XPATH = "xpath;(//span[@class='checkout_delivery_info__mark'])[1]";


    //конструктор
    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getChooseDeliveryMethod() {
        return new PageElementActions(CHOOSE_DELIVERY_METHOD_XPATH, driver);
    }

    public PageElementActions getBaseInputDelivery(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    public PageElementActions getFinalBuyButton() {
        return new PageElementActions(FINAL_BUY_BUTTON_XPATH, driver);
    }

    public PageElementActions getInputPhoneNumber() {
        return new PageElementActions(INPUT_PHONE_NUMBER_XPATH, driver);
    }

    public PageElementActions getBookingButton() {
        return new PageElementActions(BOOKING_BUTTON_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_XPATH, driver);
    }

    public PageElementActions getSelectApteka() {
        return new PageElementActions(SELECT_APTEKA_XPATH, driver);
    }

    public PageElementActions getAvailability() {
        return new PageElementActions(AVAILABILITY_XPATH, driver);
    }

    public PageElementActions getChooseThisPharmacy() {
        return new PageElementActions(CHOOSE_THIS_PHARMACY_XPATH, driver);
    }

    public PageElementActions getMakeOrderButton() {
        return new PageElementActions(MAKE_ORDER_BUTTON_XPATH, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }

    public PageElementActions getAptekaMap() {
        return new PageElementActions(APTEKA_MAP_XPATH, driver);
    }

    public PageElementActions getPickupRadioButton() {
        return new PageElementActions(PICKAP_RADIO_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Заполнение данных адреса доставки")
    public void addressDelivery(String address, String entrance, String level, String flat) {
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Address)).sendKeys(address);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Entrance)).sendKeys(entrance);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Level)).sendKeys(level);
        getBaseInputDelivery(String.format(BASE_INPUT_DELIVERY_XPATH, Flat)).sendKeys(flat);
    }

    @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String fio, String phoneNumber, String email ) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        logger.info("Пользователь заполнил контактные данные");
    }

    @Step("Пользователь выбирает способ получения - Доставка")
    public void clickDeliveryMethod() {
        chooseDeliveryMethod();
        logger.info("Пользователь выбирает способ получения - Доставка");
    }

    @Step("Пользователь нажимает на кнопку купить")
    public void clickToFinalButton() {
        getFinalBuyButton().click();
        logger.info("ПОЛЬЗОВАТЕЛЬ ПЕРЕШЕЛ НА СТРАНИЦУ СБЕРА");
    }

    @Step("Пользователь вводит номер телефона при покупке в 1-клик")
    public void setInputOneClickPhoneNumber(String number) {
        getInputPhoneNumber().sendKeys(number);
        logger.info("Пользователь вводит номер телефона при покупке в 1-клик");
    }

    @Step("Пользователь нажимает на кнопку 'Забронировать'")
    public void clickBookingButton(){
        getBookingButton().click();
        logger.info("Пользователь нажимает на кнопку 'Забронировать'");
    }

    @Step("Проверка выбранного способа получения 'Самовывоз'")
    public void choosePickupMethod() {
        if (getSelectApteka().isElementVisible()) {
            getSelectApteka().click();
        }
        else {
            getPickupRadioButton().click();
            getSelectApteka().click();
        }
        logger.info("Проверка выбранного способа получения 'Самовывоз'");
    }

    @Step("Проверка выбранного способа получения 'Доставка'")
    public void chooseDeliveryMethod() {
        if (getSelectApteka().isElementVisible()) {
            getChooseDeliveryMethod().click();
        }
        else {
            getChooseDeliveryMethod().click();
        }
        logger.info("Проверка выбранного способа получения 'Доставка'");
    }

    @Step("Пользователь нажимает кнопку 'Выбрать Аптеку'")
    public void clickSelectApteka() {
        choosePickupMethod();
        logger.info("Пользователь нажимает кнопку 'Выбрать Аптеку'");
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickChangeAptekaList() {
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'")
    public void getAvailabilityAndChooseThisPharmacy(){
        getAvailability().click();
        getChooseThisPharmacy().click();
        logger.info("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'");
    }

    @Step("Пользователь нажимает на кнопку 'Сделать заказ'")
    public void clickMakeOrder(){
        getMakeOrderButton().click();
        logger.info("Пользователь нажимает на кнопку 'Сделать заказ'");
    }

    @Step("Пользователь вводит адрес - {addres}")
    public void setInputSearchAddres(String addres) {
        getPharmacyAddressInput().sendKeysAndEnter(addres);
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }

}
