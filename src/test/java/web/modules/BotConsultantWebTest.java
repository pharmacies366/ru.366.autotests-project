/*
package web.modules;
package web.modules;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Web")
@Story(value = "Консультант бот на сайте 36.6")
@DisplayName("Консультант бот")
public class BotConsultantWebTest extends base.BaseSettingsWebTests {

    @DisplayName("Пользователь выбирает пункт: Не могу оформить заказ, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemCanNotCheckout() {
        mainPage.clickClosePopUp();
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickCantNotOrder();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Мне нужен препарат, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedADrug() {
        mainPage.clickClosePopUp();
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedADrug();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Нужна доставка, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedDelivery() {
        mainPage.clickClosePopUp();
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickNeedDelivery();
        botConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        botConsultantPopUpPage.clicksendMessage();
        botConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь проверяет закрытие консультант бота")
    @Test
    public void checkCloseBot() {
        mainPage.clickClosePopUp();
        mainPage.clickBotConsultantButton();
        botConsultantPopUpPage.clickCloseBot();
        botConsultantPopUpPage.checkCloseBot();

    }
}
*/
