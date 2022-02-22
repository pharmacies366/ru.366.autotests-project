package blocks.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HeaderBlock extends MainTestBase {

    //элементы
    private static final String SIGN_IN_BUTTON_XPATH = "xpath;(//a[contains(.,'Войти')])[1]";
    private static final String SIGN_UP_BUTTON_XPATH = "xpath;(//a[@class='b-login-link js-register-ext__button'])[1]";
    private static final String MY_ORDERS_XPATH = "xpath;(//a[@href='/my-account/orders'])[1]";
    private static final String PERSONAL_ACCOUNT_XPATH = "xpath;(//span[@class='js-check-user-status'])[1]";
    private static final String BASE_INPUT_XPATH = "xpath;(//a[@href='%s'])";
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String CATALOG_BUTTON_XPATH = "xpath;//span[@class='catalog_menu__title']";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String CARD_COUNT_XPATH = "xpath;//div[contains(@class,'count js-mini-cart-count')]";
    private static final String CITIES_BUTTON_XPATH = "xpath;(//span[@class='b-login-link i-fw-b'])[1]";
    private static final String SELECT_CITIES_XPATH = "xpath;(//div[contains(@class,'title i-float-l')])[2]";
    private static final String PHARMACIES_BUTTON_XPATH = "xpath;(//a[@href='/apteki/map'])[1]";
    private static final String PHONE_NUMBER_XPATH = "xpath;(//a[@class='b-icn--phone i-fw-b'])[1]";

    //конструктор
    public HeaderBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getSignInButton() {
        return new PageElementActions(SIGN_IN_BUTTON_XPATH, driver);
    }

    public PageElementActions getSignUpButton() {
        return new PageElementActions(SIGN_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getMyOrders() {
        return new PageElementActions(MY_ORDERS_XPATH, driver);
    }

    public PageElementActions getPersonalAccount() {
        return new PageElementActions(PERSONAL_ACCOUNT_XPATH, driver);
    }

    public PageElementActions getSiteLogo() {
        return new PageElementActions(SITE_LOGO_XPATH, driver);
    }

    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_XPATH, driver);
    }

    public PageElementActions getCatalogButton() {
        return new PageElementActions(CATALOG_BUTTON_XPATH, driver);
    }

    public PageElementActions getBaseInputHeaderLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getSearchInput() {
        return new PageElementActions(SEARCH_INPUT_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getCitiesButton() {
        return new PageElementActions(CITIES_BUTTON_XPATH, driver);
    }

    public PageElementActions getSelectCitiesText() {
        return new PageElementActions(SELECT_CITIES_XPATH, driver);
    }

    public PageElementActions getPharmaciesButton() {
        return new PageElementActions(PHARMACIES_BUTTON_XPATH, driver);
    }

    public PageElementActions getPhoneNumber() {
        return new PageElementActions(PHONE_NUMBER_XPATH, driver);
    }

    public PageElementActions getBaseInputHeaderLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToSignInButton() {
        getSignInButton().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Пользователь нажимает на кнопку регистрации")
    public void clickToSignUpButton() {
        getSignUpButton().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Пользователь нажимает на иконку личного кабинета")
    public void clickToPersonalAccount() {
        getPersonalAccount().click();
        logger.info("Пользователь нажимает на иконку личного кабинета");
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickMyOrders() {
        getMyOrders().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Проверка количества товаров в корзине")
    public int checkCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        return quantity;
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
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

    @Step("Пользователь нажимает на кнопку Каталог")
    public void clickCatalogButton(){
        getCatalogButton().click();
        logger.info("Пользователь нажимает на кнопку Каталог");
    }

    @Step("Пользователь нажимает на кнопку для выбора города")
    public void clickCitiesButton(){
        getCitiesButton().click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
    }

    @Step("Пользователь нажимает на кнопку аптеки и переходит на страницу с картой аптек")
    public void clickPharmaciesButton(){
        getPharmaciesButton().click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
    }

    @Step("Проверка видимости попапа с выбором городов")
    public String checkCitiesPopUp(){
      String text = getSelectCitiesText().getText();
        logger.info("Проверка видимости попапа с выбором городов");
        return text;
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {vendorCode}")
    public void setSearchInput(String vendorCode) {
        getSearchInput().sendKeysAndEnter(vendorCode);
        logger.info("Пользователь вводит артикул товара в поисковую строку");
    }

    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public void checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputHeaderLinks(String.format(BASE_INPUT_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
    }

    @Step("Кликает по локатору {LOCATOR}")
    public void selectHeaderButtons(String LOCATOR) {
        getBaseInputHeaderLocators(String.format(BASE_INPUT_XPATH, LOCATOR)).click();
    }

}
