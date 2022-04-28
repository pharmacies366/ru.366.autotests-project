package pages.web.orders;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class MyOrdersPage {

    //элементы
    private final Button ORDER = new Button($x( "(//a[@class='c-order-item__link'])[1]"));
    private final Button CANCEL_ORDER = new Button($x( "//div[@class='b-btn hidden-xs b-btn--third js-cancel-order']"));
    private final Button APPROVE_CANCEL_ORDER = new Button($x( "//a[contains(@class,'approve')]"));
    private final Button STATUS_ORDER = new Button($x( "//div[@class='b-order-status']"));



    //Методы

    @Step("номера заказа")
    public MyOrdersPage getOrderNumber() {
        String orderNumber = ORDER.getText().replaceAll("[^1-12]", "").trim();
       // logger.info("номера заказа");
        return this;
    }

    @Step("Пользователь открывает созданный заказ")
    public MyOrdersPage clickOrderNumber() {
        ORDER.click();
      //  logger.info("Пользователь открывает созданный заказ");
        return this;
    }

    @Step("Пользователь нажимает кнопки отменить и подвердить отмену заказа")
    public MyOrdersPage clickCancelNumber() {
        CANCEL_ORDER.click();
        APPROVE_CANCEL_ORDER.click();
       // logger.info("Пользователь нажимает кнопки отменить и подвердить отмену заказа");
        return this;
    }

    @Step("Пользователь проверяет статус заказа")
    public MyOrdersPage getOrderStatus() {
        String orderStatus = STATUS_ORDER.getText();
       // logger.info("Пользователь проверяет статус заказа");
        return this;
    }

    @Step("Пользователь отменяет созданный заказ")
    public MyOrdersPage cancelOrder() {
        Selenide.open("https://366.ru/my-account/orders/");
        clickOrderNumber();
        CANCEL_ORDER.click();
        APPROVE_CANCEL_ORDER.click();
       // pageActions.assertEqualsTwoObject("Отменен",getOrderStatus());
       // logger.info("Пользователь отменяет созданный заказ");
        return this;
    }
}
