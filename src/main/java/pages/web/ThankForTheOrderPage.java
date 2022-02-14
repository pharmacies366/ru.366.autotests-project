package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ThankForTheOrderPage extends MainTestBase {



    //элементы
    private static final String THANKS_ORDER_SELF_XPATH = "xpath;//h1[contains(.,'Спасибо за ваш заказ!')]";
    private static final String ERROR_PAYMENT_XPATH = "xpath;//a[contains(.,'Вернуться в магазин')]";
    private static final String THANKS_ORDER_DELIVERY_XPATH = "xpath;//input[@id='pan']";
    private static final String SAVING_ORDER_NUMBER_XPATH = "xpath;//div[@class='order-number-code']";


    //конструктор
    public ThankForTheOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getThanksOrderSelf() {
        return new PageElementActions(THANKS_ORDER_SELF_XPATH, driver);
    }

    public PageElementActions getErrorPayment() {
        return new PageElementActions(ERROR_PAYMENT_XPATH, driver);
    }

    public PageElementActions getOrderNumber() {
        return new PageElementActions(SAVING_ORDER_NUMBER_XPATH, driver);
    }


    //Методы

    @Step("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'")
    public void checkSuccessMessage(){
        getThanksOrderSelf().elementIsVisibility();
        logger.info("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'");
    }

    @Step("Пользователь после отлаты тестовой картой получает ошибку об оплате")
    public void checkPaymentError(){
        getErrorPayment().elementIsVisibility();
        logger.info("Пользователь получает ошибку об оплате");
    }

    @Step("Сохранение номера заказа")
    public String savingOrderNumber() {
        String orderNumber = getOrderNumber().getText();
        logger.info("Сохранение номера заказа");
        return orderNumber;
    }
}
