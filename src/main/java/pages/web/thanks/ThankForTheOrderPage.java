package pages.web.thanks;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ThankForTheOrderPage extends MainTestBase {



    //элементы
    private static final String THANKS_ORDER_SELF_XPATH = "xpath;//h1[contains(.,'Спасибо за ваш заказ!')]";
    private static final String SAVING_ORDER_NUMBER_XPATH = "xpath;//div[@class='order-number-code']";
    private static final String SAVING_ADDRESS_XPATH = "xpath;//span[@class='js-gtm-store-name']";


    //конструктор
    public ThankForTheOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getThanksOrderSelf() {
        return new PageElementActions(THANKS_ORDER_SELF_XPATH, driver);
    }

    public PageElementActions getOrderNumber() {
        return new PageElementActions(SAVING_ORDER_NUMBER_XPATH, driver);
    }

    public PageElementActions getAddress() {
        return new PageElementActions(SAVING_ADDRESS_XPATH, driver);
    }



    //Методы

    @Step("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'")
    public void checkSuccessMessage(){
        getThanksOrderSelf().elementIsVisibility();
        logger.info("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'");
    }

    @Step("Проверка видимости номера заказа")
    public void checkOrderNumberWithAddress() {
        getOrderNumber().elementIsVisibility();
        getAddress().elementIsVisibility();
        logger.info("Проверка видимости номера заказа");
    }
}
