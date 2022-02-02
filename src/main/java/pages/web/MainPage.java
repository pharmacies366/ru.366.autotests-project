package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainTestBase {

    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";


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

    public PageElementActions getLetterN() {
        return new PageElementActions(LETTER_N_XPATH, driver);
    }

    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp(){
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect(){
        getSiteLogo().elementIsVisibility();
        logger.info("Лого отображается");
    }

    @Step("Пользователь нажимает на иконку 36.6 и переходит на главную страницу")
    public void clickSiteLogo(){
        getSiteLogo().click();
        logger.info("Пользователь нажимает на иконку 36.6 и переходит на главную страницу");
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {vendorCode}")
    public void setSearchInput(String vendorCode) {
        getSearchInput().sendKeysAndEnter(vendorCode);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN(){
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }


}
