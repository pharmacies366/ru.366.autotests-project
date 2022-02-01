package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMainPage extends MainTestBase {


    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String MOBILE_APP_POP_UP_BUTTON_XPATH = "xpath;//div[contains(@class,'flyer--close')]";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@class='b-search__input']";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";


    //конструктор
    public MobileMainPage(WebDriver driver) {
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

    public PageElementActions getMobileAppPopUpButton() {
        return new PageElementActions(MOBILE_APP_POP_UP_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp(){
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'")
    public void clickCloseMobileAppPopUp(){
        getMobileAppPopUpButton().click();
        logger.info("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'");
    }

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect(){
        getSiteLogo().elementIsVisibility();
        logger.info("Лого отображается");
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {search}")
    public void setSearchInput(String search) {
        getSearchInput().sendKeys(search);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN(){
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

}
