package pages.web.orders;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage extends MainTestBase {

    //элементы
    private static final String ORDER_XPATH = "xpath;(//a[@class='c-order-item__link'])[1]";
    private static final String CANCEL_ORDER_XPATH = "xpath;//div[@class='b-btn hidden-xs b-btn--third js-cancel-order']";
    private static final String APPROVE_CANCEL_ORDER_XPATH = "xpath;//a[contains(@class,'approve')]";
    private static final String STATUS_ORDER_XPATH = "xpath;//div[@class='b-order-status']";



    //конструктор
    public MyOrdersPage(WebDriver driver) {
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



    //Методы

    @Step("номера заказа")
    public String getOrderNumber() {
        String orderNumber = getOrder().getText().replaceAll("[^1-12]", "").trim();
        logger.info("номера заказа");
        return orderNumber;
    }

    @Step("Пользователь открывает созданный заказ")
    public void clickOrderNumber() {
        getOrder().click();
        logger.info("Пользователь открывает созданный заказ");
    }

    @Step("Пользователь нажимает кнопки отменить и подвердить отмену заказа")
    public void clickCancelNumber() {
        getCancelOrder().click();
        getApproveCancelOrder().click();
        logger.info("Пользователь нажимает кнопки отменить и подвердить отмену заказа");
    }

    @Step("Пользователь проверяет статус заказа")
    public String getOrderStatus() {
        String orderStatus = getStatusOrder().getText();
        logger.info("Пользователь проверяет статус заказа");
        return orderStatus;
    }

    @Step("Пользователь отменяет созданный заказ")
    public void cancelOrder() {
        openUrl(propertiesManager.getProperty("baseurl") + "my-account/orders/");
        clickOrderNumber();
        getCancelOrder().click();
        pageActions.staticWait(2000);
        getApproveCancelOrder().click();
        pageActions.assertEqualsTwoObject("Отменен",getOrderStatus());
        logger.info("Пользователь отменяет созданный заказ");
    }
}
