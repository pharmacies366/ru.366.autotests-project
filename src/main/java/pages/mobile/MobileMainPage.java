package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMainPage extends MainTestBase {


    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String MOBILE_APP_POP_UP_BUTTON_XPATH = "xpath;//div[@class='b-apps-flyer--close js-apps-flyer--close']";
    private static final String SEARCH_INPUT1_XPATH = "xpath;//div[@class='header_search_mobile__toggle js-toggle-xs-search js-header-search-mobile-toggle']";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_plus')])[1]";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_minus')])[1]";
    private static final String QUANTITY_MATERIALS_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";


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

    public PageElementActions getSearchInput1() {
        return new PageElementActions(SEARCH_INPUT1_XPATH, driver);
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

    public PageElementActions getClickAddCartButton() {
        return new PageElementActions(ADD_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getDecreaseQuantity() {
        return new PageElementActions(DECREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getMaterialsQuantity() {
        return new PageElementActions(QUANTITY_MATERIALS_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
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

    @Step("Пользователь нажимает на иконку 36.6 и переходит на главную страницу")
    public void clickSiteLogo(){
        getSiteLogo().click();
        logger.info("Пользователь нажимает на иконку 36.6 и переходит на главную страницу");
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {vendorCode}")
    public void setSearchInput(String vendorCode) {
        getSearchInput1().click();
        getSearchInput().sendKeys(vendorCode);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN(){
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void AddToCartClick(){
        getClickAddCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity(){
        getIncreaseQuantity().click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public void clickDecreaseQuantity(){
        getDecreaseQuantity().click();
        logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
    }

    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getMaterialsQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
    }

}
