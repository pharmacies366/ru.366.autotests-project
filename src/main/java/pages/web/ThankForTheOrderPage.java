package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ThankForTheOrderPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(ThankForTheOrderPage.class);

    //элементы
    private static final String THANKS_ORDER_SELF_XPATH = "xpath;//h2[contains(.,'Спасибо за ваш заказ!')]";
    private static final String ERROR_PAYMENT_XPATH = "xpath;//a[contains(.,'Вернуться в магазин')]";
    private static final String THANKS_ORDER_DELIVERY_XPATH = "xpath;//input[@id='pan']";
    private static final String THANKS_ORDER_SPLIT_XPATH = "xpath;//input[@id='pan']";


    //конструктор
    public ThankForTheOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getThanksOrderSelf() {
        return new PageElementActions(THANKS_ORDER_SELF_XPATH, driver);
    }

    public PageElementActions getThanksOrderDelivery() {
        return new PageElementActions(THANKS_ORDER_DELIVERY_XPATH, driver);
    }

    public PageElementActions getErrorPayment() {
        return new PageElementActions(ERROR_PAYMENT_XPATH, driver);
    }


    //Методы

    @Step("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'")
    public void checkSuccessMessage(){
        getThanksOrderSelf().elementIsVisibility();
        logger.info("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'");
        saveAllureScreenshot();
    }

    @Step("Пользователь после отлаты тестовой картой получает ошибку об оплате")
    public void checkPaymentError(){
        getErrorPayment().elementIsVisibility();
        logger.info("Пользователь получает ошибку об оплате");
        saveAllureScreenshot();
    }
}
