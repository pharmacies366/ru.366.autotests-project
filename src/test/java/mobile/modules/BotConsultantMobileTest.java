package mobile.modules;/*
package mobile.modules;

import base.BaseSettingsMobileTests;
import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "Консультант бот на сайте 36.6")
@DisplayName("Консультант бот")
public class BotConsultantMobileTest extends BaseSettingsMobileTests {

    @DisplayName("Пользователь выбирает пункт: Не могу оформить заказ, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemCanNotCheckout() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCantNotOrder();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Мне нужен препарат, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedADrug() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedADrug();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь выбирает пункт: Нужна доставка, заполняет свои данные и получает ответ от бота")
    @Test
    public void checkItemINeedDelivery() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickNeedDelivery();
        mobileBotConsultantPopUpPage.contactDetails("test","00000000000","test@gmail.com");
        mobileBotConsultantPopUpPage.clicksendMessage();
        mobileBotConsultantPopUpPage.checkThanksMessage();
    }

    @DisplayName("Пользователь проверяет закрытие консультант бота")
    @Test
    public void checkCloseBot() {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        mobileMainPage.clickBotConsultantButton();
        mobileBotConsultantPopUpPage.clickCloseBot();
        mobileBotConsultantPopUpPage.checkCloseBot();

    }
}
*/
