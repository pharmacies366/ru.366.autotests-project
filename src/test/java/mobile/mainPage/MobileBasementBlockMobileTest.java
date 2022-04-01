package mobile.mainPage;

import base.BaseSettingsMobileTests;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;

@Feature(value = "Мобильная версия")
@Story("Проверка главной страницы сайта 36.6")
@DisplayName("Проверка подвала сайта")
@RunWith(DataProviderRunner.class)
public class MobileBasementBlockMobileTest extends BaseSettingsMobileTests {

    @DataProvider
    public static Object[][] help() {
        return new Object[][]{
                //Помощь
                /*{"howToOrderNew", "Как сделать заказ", "Как оформить заказ на сайте?"},*/
                {"/apteki/map/", "Где получить заказ", "Работает сейчас"},
                {"/faq/", "Вопрос-ответ", "Вопрос-ответ"},
                {"/feedback/", "Задать вопрос", "Обратная связь"},
                {"/delivery/", "Доставка", "Курьерская доставка заказов"},
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("help")
    public void helpTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileBasementBlock.clickHelpButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider
    public static Object[][] Service() {
        return new Object[][]{
                    //Сервис
                    {"/polzovatelskoe-soglashenie/", "Пользовательское соглашение", "Пользовательское соглашение"},
                    {"/politika-konfidencialnosti/", "Политика конфиденциальности", "Политика конфиденциальности"},
                    {"/mnn/", "Действующие вещества", "Все вещества"},
                    {"/promotions/", "Акции", "Акции"},
                    {"/articles/", "Статьи", "Статьи"},
        };
    }

    @DisplayName("Проверка релевантности ссылок в подвале сайта")
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("Service")
    public void serviceTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileBasementBlock.clickServiceButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }


    @DataProvider
    public static Object[][] aboutCompany() {
        return new Object[][]{
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
    @Step("В подвале сайта переходит по ссылке => {LINKTEXT}")
    @Test
    @UseDataProvider("aboutCompany")
    public void aboutCompanyTest(String LOCATOR, String LINKTEXT, String PAGEMESSAGE) {
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileBasementBlock.clickAboutCompanButton();
        mobileBasementBlock.checkLinksValidation(LOCATOR, LINKTEXT);
        logger.info("Ссылка видна на странице и написана корректно");
        mobileBasementBlock.selectBasementButtons(LOCATOR);
        pageActions.contentIsDisplayed(PAGEMESSAGE);
        logger.info("Ссылка кликабельна и ведёт на нужную страницу");
    }

    @DisplayName("Проверка кликабельности и отображения номера телефона")
    @Test
    public void checkClickablePhoneNumber(){
        mobileBasementBlock.getPhoneNumber().elementIsClickable();
        logger.info("Номер телефона отображается и кликабелен");
    }

}
