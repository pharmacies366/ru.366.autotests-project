package pages.mobile.orders;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMyOrdersPage extends MainTestBase {

    //элементы
    private static final String ORDER_XPATH = "xpath;(//a[@class='c-order-item__link'])[1]";
    private static final String CANCEL_ORDER_XPATH = "xpath;//div[@class='b-btn visible-xs b-btn--third js-cancel-order']";
    private static final String APPROVE_CANCEL_ORDER_XPATH = "xpath;//a[contains(@class,'approve')]";
    private static final String STATUS_ORDER_XPATH = "xpath;//div[@class='b-order-status']";
    private static final String TITLE_IFRAME_POP_UP = "uxfb_form";
    private static final String CLOSE_POP_UP_XPATH = "xpath;//button[@class='uxf-close sc-bZQynM bYZQSZ']";


    //конструктор
    public MobileMyOrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getOrder() {
        return new PageElementActions(ORDER_XPATH, driver);
    }

    public PageElementActions getCancelOrder() {
        return new PageElementActions(CANCEL_ORDER_XPATH, driver);
    }

    public PageElementActions getApproveCancelOrder() {
        return new PageElementActions(APPROVE_CANCEL_ORDER_XPATH, driver);
    }

    public PageElementActions getStatusOrder() {
        return new PageElementActions(STATUS_ORDER_XPATH, driver);
    }

    public PageElementActions getClosePopUp() {
        return new PageElementActions(CLOSE_POP_UP_XPATH, driver);
    }




    //Методы

    @Step("номера заказа")
    public String getOrderNumber() {
        String orderNumber = getOrder().getText();
        logger.info("номера заказа");
        return orderNumber;
    }

    @Step("Пользователь открывает созданный заказ")
    public void clickOrderNumber() {
        getOrder().click();
        logger.info("Пользователь открывает созданный заказ");
    }

    @Step("Пользователь отменяет созданный заказ")
    public void clickCancelNumber() {
        getCancelOrder().click();
        getApproveCancelOrder().click();
        logger.info("Пользователь отменяет созданный заказ");
    }

    @Step("Пользователь проверяет статус заказа")
    public String getOrderStatus() {
        String orderStatus = getStatusOrder().getText();
        logger.info("Пользователь проверяет статус заказа");
        return orderStatus;
    }

    @Step("Пользователь закрывает попап с оценкой приложения")
    public void clickClosePopUp() {
        pageActions.switchToiFrame(TITLE_IFRAME_POP_UP);
        //pageActions.switchToiFrame(0);
        getClosePopUp().click();
        logger.info("Пользователь закрывает попап с оценкой приложения");
    }
}
