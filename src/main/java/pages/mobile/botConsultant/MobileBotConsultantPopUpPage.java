package pages.mobile.botConsultant;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileBotConsultantPopUpPage extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_CONTACT_DETAILS_XPATH = "xpath;//input[@type='%s']";
    private static final String Name = "name";
    private static final String PhoneNumber = "tel";
    private static final String Email = "email";
    private static final String CLOSE_BOT_BUTTON_XPATH = "xpath;//jdiv[@class='closeBox_f08e']";
    private static final String CAN_NOT_ORDER_BUTTON_XPATH = "xpath;(//jdiv[@class='button_acaf'])[1]";
    private static final String NEED_A_DRUG_BUTTON_XPATH = "xpath;(//jdiv[@class='button_acaf'])[2]";
    private static final String NEED_DELIVERY_BUTTON_XPATH = "xpath;(//jdiv[@class='button_acaf'])[3]";
    private static final String ENTER_MESSAGE_INPUT_XPATH = "xpath;//jdiv[text()='Отправить']";
    private static final String THANKS_MESSAGE_XPATH = "xpath;//jdiv[@class='submitSuccess_ee4a __show_c0f4']";
    private static final String ANIMATION_BOT_XPATH = "xpath;(//jdiv[@class='globalClass_bc43']//child::jdiv)[1]";
    private static final String CONSULTANT_BOT_BUTTON_XPATH = "xpath;//jdiv[@class='button_e5c6']";



    //конструктор
    public MobileBotConsultantPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getCloseBotButton() {
        return new PageElementActions(CLOSE_BOT_BUTTON_XPATH, driver);
    }

    public PageElementActions getCanNotOrderButton() {
        return new PageElementActions(CAN_NOT_ORDER_BUTTON_XPATH, driver);
    }

    public PageElementActions getNeedADrugButton() {
        return new PageElementActions(NEED_A_DRUG_BUTTON_XPATH, driver);
    }

    public PageElementActions getNeedDeliveryButton() {
        return new PageElementActions(NEED_DELIVERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getEnterMessageInput() {
        return new PageElementActions(ENTER_MESSAGE_INPUT_XPATH, driver);
    }

    public PageElementActions getBaseInputContactDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getThanksMessage() {
        return new PageElementActions(THANKS_MESSAGE_XPATH, driver);
    }

    public PageElementActions getStatusAnimationBot() {
        return new PageElementActions(ANIMATION_BOT_XPATH, driver);
    }

    public PageElementActions getConsultantBot() {
        return new PageElementActions(CONSULTANT_BOT_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Пользователь закрывает консультант бота")
    public void clickCloseBot() {
        getCloseBotButton().click();
        logger.info("Пользователь закрывает консультант бота");
    }

    @Step("Пользователь выбирает пункт: Не могу оформить заказ")
    public void clickCantNotOrder() {
        getCanNotOrderButton().click();
        logger.info("Пользователь выбирает пункт: Не могу оформить заказ");
    }

    @Step("Пользователь выбирает пункт: Нужен препарат")
    public void clickNeedADrug() {
        getNeedADrugButton().click();
        logger.info("Пользователь выбирает пункт: Нужен препарат");
    }

    @Step("Пользователь выбирает пункт: Нужна доставка")
    public void clickNeedDelivery() {
        getNeedDeliveryButton().click();
        logger.info("Пользователь выбирает пункт: Нужна доставка");
    }

    @Step("Пользователь вводит сообщение")
    public void enterMessage() {
        getEnterMessageInput().click();
        logger.info("Пользователь вводит сообщение");
    }

    @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String name, String phoneNumber, String email ) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Name)).sendKeys(name);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        logger.info("Пользователь заполнил контактные данные");
    }

    @Step("Пользователь нажимает кнопку отправить")
    public void clicksendMessage() {
        getEnterMessageInput().click();
        logger.info("Пользователь нажимает кнопку отправить");
    }

    @Step("Пользователь проверяет сообщение с текстом 'Спасибо'")
    public void checkThanksMessage() {
       String message = getThanksMessage().getText();
        Assert.assertEquals(message, "\uD83C\uDF89 Спасибо!");
        logger.info("Пользователь проверяет сообщение с текстом 'Спасибо'");
    }

    @Step("Пользователь проверяет, что консультант бот закрылся")
    public void checkCloseBot() {
        getConsultantBot().isElementDisplayed();
        logger.info("Пользователь проверяет, что консультант бот закрылся");
    }

}
