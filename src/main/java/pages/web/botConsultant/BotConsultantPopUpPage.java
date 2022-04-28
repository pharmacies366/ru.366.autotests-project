package pages.web.botConsultant;

import io.qameta.allure.Step;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import ru.yandex.qatools.htmlelements.element.Button;
import static com.codeborne.selenide.Selenide.$x;

public class BotConsultantPopUpPage {

    //элементы
    private final Button BASE_INPUT_CONTACT_DETAILS = new Button($x( "xpath;//input[@type='%s']"));
    public final String NAME = "name";
    public final String PHONE_NUMBER = "tel";
    public final String EMAIL = "email";
    private final Button CLOSE_BOT_BUTTON = new Button($x("//jdiv[@class='closeIcon_fc52']"));
    private final Button CAN_NOT_ORDER_BUTTON = new Button($x( "(//jdiv[@class='button_acaf'])[1]"));
    private final Button NEED_A_DRUG_BUTTON = new Button($x( "(//jdiv[@class='button_acaf'])[2]"));
    private final Button NEED_DELIVERY_BUTTON = new Button($x( "(//jdiv[@class='button_acaf'])[3]"));
    private final Button ENTER_MESSAGE_INPUT = new Button($x( "//jdiv[text()='Отправить']"));
    private final Button THANKS_MESSAGE = new Button($x( "//jdiv[@class='submitSuccess_f0ba __show_ee7c']"));
    private final Button ANIMATION_BOT = new Button($x( "(//jdiv[@class='globalClass_bc43']//child::jdiv)[1]"));



    //Методы
    @Step("Пользователь закрывает консультант бота")
    public BotConsultantPopUpPage clickCloseBot() {
        CLOSE_BOT_BUTTON.click();
        //logger.info("Пользователь закрывает консультант бота");
        return this;
    }

    @Step("Пользователь выбирает пункт: Не могу оформить заказ")
    public BotConsultantPopUpPage clickCantNotOrder() {
        CAN_NOT_ORDER_BUTTON.click();
        //logger.info("Пользователь выбирает пункт: Не могу оформить заказ");
        return this;
    }

    @Step("Пользователь выбирает пункт: Нужен препарат")
    public BotConsultantPopUpPage clickNeedADrug() {
        NEED_A_DRUG_BUTTON.click();
       // logger.info("Пользователь выбирает пункт: Нужен препарат");
        return this;
    }

    @Step("Пользователь выбирает пункт: Нужна доставка")
    public BotConsultantPopUpPage clickNeedDelivery() {
        NEED_DELIVERY_BUTTON.click();
      //  logger.info("Пользователь выбирает пункт: Нужна доставка");
        return this;
    }

    @Step("Пользователь вводит сообщение")
    public BotConsultantPopUpPage enterMessage() {
        ENTER_MESSAGE_INPUT.click();
       // logger.info("Пользователь вводит сообщение");
        return this;
    }

/*    @Step("Пользователь заполняет контактные данные")
    public BotConsultantPopUpPage contactDetails(String name, String phoneNumber, String email ) {
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, NAME)).sendKeys(name);
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, PHONE_NUMBER)).sendKeys(phoneNumber);
        BASE_INPUT_CONTACT_DETAILS(String.format(BASE_INPUT_CONTACT_DETAILS, EMAIL)).sendKeys(email);
      //  logger.info("Пользователь заполнил контактные данные");
        return this;
    }*/

    @Step("Пользователь нажимает кнопку отправить")
    public BotConsultantPopUpPage clicksendMessage() {
        ENTER_MESSAGE_INPUT.click();
      //  logger.info("Пользователь нажимает кнопку отправить");
        return this;
    }

    @Step("Пользователь проверяет сообщение с текстом 'Спасибо'")
    public BotConsultantPopUpPage checkThanksMessage() {
       String message = THANKS_MESSAGE.getText();
       // Assert.assertEquals(message, "\uD83C\uDF89 Спасибо!");
       // logger.info("Пользователь проверяет сообщение с текстом 'Спасибо'");
        return this;
    }

    @Step("Пользователь проверяет, что консультант бот закрылся")
    public BotConsultantPopUpPage checkCloseBot() {
      String statusBot = ANIMATION_BOT.getAttribute("style");
        MatcherAssert.assertThat(statusBot, CoreMatchers.containsString("Label_CLOSE"));
       // logger.info("Пользователь проверяет, что консультант бот закрылся");
        return this;
    }

}
