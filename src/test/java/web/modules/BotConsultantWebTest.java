package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story(value = "Консультант бот на сайте 36.6")
@DisplayName("Консультант бот")
@Tag("Web")
@Tag("Regression")
public class BotConsultantWebTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь выбирает пункт: Не могу оформить заказ, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemCanNotCheckout() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickCantNotOrder();
        pageActions.waitPageLoad();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Мне нужен препарат, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedADrug() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedADrug();
        pageActions.waitPageLoad();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Нужна доставка, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedDelivery() {
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedDelivery();
        pageActions.waitPageLoad();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь проверяет закрытие консультант бота")
    @Test
    public void checkCloseBot() {
        mainPage.clickBotConsultantButton();
        pageActions.waitPageLoad();
        botConsultantPopUpPage.clickCloseBot();
        mainPage.getBotConsultantButton().isElementDisplayed();

    }
}
