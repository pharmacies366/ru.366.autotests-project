package blocks.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileHeaderBlock extends MainTestBase {
    //элементы
    private static final String CARD_COUNT_XPATH = "xpath;//div[contains(@class,'count js-mini-cart-count')]";
    private static final String CLEAR_ALL_FROM_CARD_XPATH = "xpath;//a[contains(.,'Очистить все')]";
    private static final String CONFIRM_CLEAN_ALL_XPATH = "xpath;//input[@value='Да, подтверждаю']";
    private static final String BURGER_BUTTON_XPATH = "xpath;//div[contains(@class,'toggle js-toggle-sm-navigation')]";
    private static final String SITE_LOGO_XPATH = "xpath;//img[contains(@alt,'9477014323230.png')]";
    private static final String SEARCH_INPUT1_XPATH = "xpath;//div[@class='header_search_mobile__toggle js-toggle-xs-search js-header-search-mobile-toggle']";
    private static final String SEARCH_INPUT_XPATH = "xpath;//input[@id='js-site-search-input']";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String FAVORITES_BUTTON_XPATH = "xpath;//span[contains(@class,'header_favorites_mobile__icon')]";
    private static final String GET_SELECTED_REGION_XPATH = "xpath;(//span[contains(@class,'b-login-link i-fw-b')])[3]";

    //конструктор
    public MobileHeaderBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBurgerButton() {
        return new PageElementActions(BURGER_BUTTON_XPATH, driver);
    }

    public PageElementActions getSiteLogo() {
        return new PageElementActions(SITE_LOGO_XPATH, driver);
    }
    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_XPATH, driver);
    }

    public PageElementActions getClearAllFromCart() {
        return new PageElementActions(CLEAR_ALL_FROM_CARD_XPATH, driver);
    }

    public PageElementActions getConfirmCleanAll() {
        return new PageElementActions(CONFIRM_CLEAN_ALL_XPATH, driver);
    }

    public PageElementActions getSearchInput1() {
        return new PageElementActions(SEARCH_INPUT1_XPATH, driver);
    }

    public PageElementActions getSearchInput() {
        return new PageElementActions(SEARCH_INPUT_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getFavoritesButton() {
        return new PageElementActions(FAVORITES_BUTTON_XPATH, driver);
    }

    public PageElementActions getSelectedRegion() {
        return new PageElementActions(GET_SELECTED_REGION_XPATH, driver);
    }


    //Методы
    @Step("Пользователь нажимает на иконку выпадающего списка")
    public void clickBurgerButton(){
        getBurgerButton().click();
        logger.info("Пользователь нажимает на иконку выпадающего списка");
    }

    @Step("Пользователь на логотип сайта и поподает на главную страницу сайта")
    public void clickSiteLogo(){
        getSiteLogo().click();
        logger.info("Пользователь на логотип сайта и поподает на главную страницу сайта");
    }

    @Step("Пользователь нажимает на иконку 'Избранное'")
    public void clickFavorites(){
        getFavoritesButton().click();
        logger.info("Пользователь нажимает на иконку 'Избранное'");
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {vendorCode}")
    public void setSearchInput(String vendorCode) {
        getSearchInput1().click();
        getSearchInput().sendKeysAndEnter(vendorCode);
        logger.info("Пользователь вводит артикул не партнерсского товара в поисковую строку");
    }

    @Step("Проверка состояния корзины: Если корзина не пустая, удаляем все содержимое")
    public void checkAndClearCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        if (quantity != 0) {
            logger.info("В КОРЗИНЕ ЕСТЬ ТОВАРЫ");
            driver.get(propertiesManager.getProperty("baseurl") + "/cart");
            getClearAllFromCart().click();
            getConfirmCleanAll().click();
            logger.info("ТОВАРЫ В КОРЗИНЕ УДАЛЕНЫ");
            saveAllureScreenshot();
        }
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

    @Step("Пользователь нажимает кнопку избранное")
    public void clickFavoritesButton() {
        getFavoritesButton().click();
        logger.info("Пользователь нажимает кнопку избранное");
    }

    @Step("Пользователь проверяет выбранный регион")
    public void checkSelectedRegion(String regionName) {
        String region = getSelectedRegion().getText();
        Assert.assertEquals(region, regionName);
        logger.info("Пользователь проверяет выбранный регион");
    }

    @Step("Пользователь получает количество товаров в избранном")
    public int checkQuantityProductsOnFavoritesPage() {
        String stringFavoritesQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringFavoritesQuantity);
        logger.info("Пользователь получает количество товаров в избранном");
        return quantity;
    }


}
