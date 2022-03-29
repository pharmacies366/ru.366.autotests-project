package web.mainPage;

import base.BaseSettingsWebTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature(value = "Web")
@Story("Проверка подвала сайта 36.6")
@DisplayName("Проверка подвала сайта")
@RunWith(DataProviderRunner.class)
public class BasementBlockWebTest extends BaseSettingsWebTests {

    @DataProvider
    public static Object[][] data() {
        return new Object[][]{
                //Помощь
                {"/howToOrderNew/", "Как сделать заказ", "Как оформить заказ на сайте?"},
                {"/apteki/map/", "Где получить заказ", "Работает сейчас"},
                {"/faq/", "Вопрос-ответ", "Вопрос-ответ"},
                {"/feedback/", "Задать вопрос", "Обратная связь"},
                {"/delivery/", "Доставка", "Курьерская доставка заказов"},
                //Сервис
                {"/polzovatelskoe-soglashenie/", "Пользовательское соглашение", "Пользовательское соглашение"},
                {"/politika-konfidencialnosti/", "Политика конфиденциальности", "Политика конфиденциальности"},
                {"/mnn/", "Действующие вещества", "Все вещества"},
                {"/promotions/", "Акции", "Акции"},
                {"/articles/", "Статьи", "Статьи"},
                //О Компании
                {"/aboutus/", "О нас", "О нас"},
                {"/contacts/", "Контактные данные", "Контактные данные"},
                {"/manufacturers/", "Производители", "Производители"},
                {"/advertisingplacement/", "Размещение рекламы", "Размещение рекламы"},
                {"/license/", "Лицензии", "Лицензии"},
                {"/vakansii/", "Вакансии", "Фармацевт/Провизор"},
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINK_TEXT}")
    @Test
    @UseDataProvider("data")
    public void test(String LOCATOR, String LINK_TEXT, String PAGE_MESSAGE) {
        mainPage.clickClosePopUp();
        mainPage.ClickClosePopUpNewsButton();
        basementBlock.checkLinksValidation(LOCATOR, LINK_TEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        basementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGE_MESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


}
