package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainTestBase {
    private Logger logger = LogManager.getLogger(MainPage.class);

    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";


    //конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getSiteLogo() {
        return new PageElementActions(SITE_LOGO_XPATH, driver);
    }

    public PageElementActions getPopUpButton() {
        return new PageElementActions(POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getSearchInput() {
        return new PageElementActions(SEARCH_INPUT_XPATH, driver);
    }


    //Методы

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect(){
        getSiteLogo().elementIsVisibility();
        logger.info("Лого отображается");
        saveAllureScreenshot();
    }

    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp(){
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
        saveAllureScreenshot();
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {search}")
    public void setSearchInput(String search) {
        getSearchInput().sendKeys(search);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
        saveAllureScreenshot();
    }


}
