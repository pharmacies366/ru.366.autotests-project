package pages.web.checkout;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class CheckOutPage {


    //элементы
    private final Button BASE_INPUT_CONTACT_DETAILS = new Button($x( "xpath;//input[@id='%s']"));
    private final String FIO = "fio";
    private final String PHONE_NUMBER = "phone";
    private final String EMAIL = "email";
    private final Button BASE_INPUT_DELIVERY = new Button($x( "xpath;//input[@id='address%s']"));
    private final String ADDRESS = "";
    private final String ENTRANCE = "-entrance";
    private final String LEVEL = "-level";
    private final String FLAT = "-flat";
    private final Button CHOOSE_DELIVERY_METHOD = new Button($x( "(//span[contains(@class,'checkout_delivery_info__mark')])[2]"));
    private final Button FINAL_BUY_BUTTON = new Button($x( "//button[contains(.,'Оформить заказ')]"));
    private final Button INPUT_PHONE_NUMBER = new Button($x( "//input[@name='phone']"));
    private final Button BOOKING_BUTTON = new Button($x( "//input[@value='Забронировать']"));
    private final Button SELECT_APTEKA = new Button($x( "//span[contains(.,'Выбрать аптеку')]"));
    private final Button CHANGE_APTEKA_LIST = new Button($x( "//span[contains(.,'Списком')]"));
    private final Button AVAILABILITY = new Button($x( "(//span[contains(.,'Узнать о наличии')])[1]"));
    private final Button CHOOSE_THIS_PHARMACY = new Button($x( "(//span[contains(.,'Выбрать эту аптеку')])[1]"));
    private final Button MAKE_ORDER_BUTTON = new Button($x( "(//button[contains(.,'Оформить заказ')])[1]"));
    private final Button PHARMACY_ADDRESS_INPUT = new Button($x( "//input[@name='q']"));
    private final Button APTEKA_MAP = new Button($x( "//*[@id='store-finder-map']"));
    private final Button PICKUP_RADIO_BUTTON = new Button($x( "(//span[@class='checkout_delivery_info__mark'])[1]"));



    //Методы
/*    @Step("Заполнение данных адреса доставки")
    public CheckOutPage addressDelivery(String address, String entrance, String level, String flat) {
        BASE_INPUT_DELIVERY(String.format(BASE_INPUT_DELIVERY, ADDRESS)).sendKeys(address);
        BASE_INPUT_DELIVERY(String.format(BASE_INPUT_DELIVERY, ENTRANCE)).sendKeys(entrance);
        BASE_INPUT_DELIVERY(String.format(BASE_INPUT_DELIVERY, LEVEL)).sendKeys(level);
        BASE_INPUT_DELIVERY(String.format(BASE_INPUT_DELIVERY, FLAT)).sendKeys(flat);
        return this;
    }

    @Step("Пользователь заполняет контактные данные")
    public CheckOutPage contactDetails(String fio, String phoneNumber, String email ) {
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, FIO)).sendKeys(fio);
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, PHONE_NUMBER)).sendKeys(phoneNumber);
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, EMAIL)).sendKeys(email);
        return this;
       // logger.info("Пользователь заполнил контактные данные");
    }*/

/*    @Step("Пользователь выбирает способ получения - Доставка")
    public CheckOutPage clickDeliveryMethod() {
        chooseDeliveryMethod();
      //  logger.info("Пользователь выбирает способ получения - Доставка");
        return this;
    }*/

    @Step("Пользователь нажимает на кнопку купить")
    public CheckOutPage clickToFinalButton() {
        FINAL_BUY_BUTTON.click();
      //  logger.info("ПОЛЬЗОВАТЕЛЬ ПЕРЕШЕЛ НА СТРАНИЦУ СБЕРА");
        return this;
    }

    @Step("Пользователь вводит номер телефона при покупке в 1-клик")
    public CheckOutPage setInputOneClickPhoneNumber(String number) {
        INPUT_PHONE_NUMBER.sendKeys(number);
      //  logger.info("Пользователь вводит номер телефона при покупке в 1-клик");
        return this;
    }

    @Step("Пользователь нажимает на кнопку 'Забронировать'")
    public CheckOutPage clickBookingButton(){
        BOOKING_BUTTON.click();
      //  logger.info("Пользователь нажимает на кнопку 'Забронировать'");
        return this;
    }

/*    @Step("Проверка выбранного способа получения 'Самовывоз'")
    public CheckOutPage choosePickupMethod() {
        if (SELECT_APTEKA.isElementVisible()) {
            SELECT_APTEKA.click();
        }
        else {
            PICKUP_RADIO_BUTTON.click();
            SELECT_APTEKA.click();
        }
      //  logger.info("Проверка выбранного способа получения 'Самовывоз'");
        return this;
    }*/

/*    @Step("Проверка выбранного способа получения 'Доставка'")
    public CheckOutPage chooseDeliveryMethod() {
        if (SELECT_APTEKA.isElementVisible()) {
            CHOOSE_DELIVERY_METHOD.click();
        }
        else {
            CHOOSE_DELIVERY_METHOD.click();
        }
        //logger.info("Проверка выбранного способа получения 'Доставка'");
        return this;
    }*/

/*    @Step("Пользователь нажимает кнопку 'Выбрать Аптеку'")
    public CheckOutPage clickSelectApteka() {
        choosePickupMethod();
       // logger.info("Пользователь нажимает кнопку 'Выбрать Аптеку'");
    }*/

    @Step("Пользователь нажимает на список доступных Аптек")
    public CheckOutPage clickChangeAptekaList() {
        CHANGE_APTEKA_LIST.click();
       // logger.info("Пользователь нажимает на список доступных Аптек");
        return this;
    }

    @Step("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'")
    public CheckOutPage getAvailabilityAndChooseThisPharmacy(){
        AVAILABILITY.click();
        CHOOSE_THIS_PHARMACY.click();
       // logger.info("Пользователь нажимает на кнопки 'Узнать о наличии' и 'Выбрать эту аптеку'");
        return this;
    }

    @Step("Пользователь нажимает на кнопку 'Сделать заказ'")
    public CheckOutPage clickMakeOrder(){
        MAKE_ORDER_BUTTON.click();
        //logger.info("Пользователь нажимает на кнопку 'Сделать заказ'");
        return this;
    }

  /*  @Step("Пользователь вводит адрес - {address}")
    public CheckOutPage setInputSearchAddres(String address) {
        PHARMACY_ADDRESS_INPUT.sendKeysAndEnter(address);
        return this;
    }*/

/*    @Step("Пользователь проверяет отображении карты на странице")
    public CheckOutPage checkVisibilityMap() {
        APTEKA_MAP.elementIsVisibility();
        //logger.info("Пользователь проверяет отображении карты на странице");
        return this;
    }*/

}
