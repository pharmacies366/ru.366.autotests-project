package pages.web.thanks;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;


public class ThankForTheOrderPage {



    //элементы
    private final Button THANKS_ORDER_SELF = new Button($x( "xpath;//h1[contains(.,'Спасибо за ваш заказ!')]"));
    private final Button SAVING_ORDER_NUMBER = new Button($x( "xpath;//div[@class='order-number-code']"));
    private final Button SAVING_ADDRESS = new Button($x( "xpath;//span[@class='js-gtm-store-name']"));




    //Методы

/*    @Step("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'")
    public ThankForTheOrderPage checkSuccessMessage(){
        THANKS_ORDER_SELF.elementIsVisibility();
       // logger.info("Пользователь проверяет отображение сообщения 'Спасибо за ваш заказ!'");
        return this;
    }*/



 /*   @Step("Проверка видимости номера заказа")
    public ThankForTheOrderPage checkOrderNumberWithAddress() {
        SAVING_ORDER_NUMBER.elementIsVisibility();
        SAVING_ADDRESS.elementIsVisibility();
       // logger.info("Проверка видимости номера заказа");
        return this;
    }*/
}
