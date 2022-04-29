package blocks.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.MainTestBase;
import io.qameta.allure.Step;


import pages.web.cart.CartPage;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebHeaderBlock extends MainTestBase {

    //элементы
    private final SelenideElement SIGN_IN_BUTTON = $x( "(//a[contains(.,'Войти')])[1]");
    private final SelenideElement SIGN_UP_BUTTON = $x( "(//a[@class='b-login-link js-register-ext__button'])[1]");
    private final SelenideElement LOGOUT_BUTTON = $x( "(//a[@href='/logout/'])[1]");
    private final SelenideElement PERSONAL_ACCOUNT = $x( "(//span[@class='js-check-user-status'])[1]");
    private final SelenideElement MY_ORDERS = $x( "(//a[@href='/my-account/orders'])[1]");
    private final SelenideElement PERSONAL_DATA = $x( "(//a[@href='/my-account/profile'])[1]");
    private final SelenideElement CHANGE_PASSWORD = $x( "(//a[@href='/my-account/update-password'])[1]");
    private final SelenideElement CARD_COUNT = $x( "//div[contains(@class,'count js-mini-cart-count')]");
    private final SelenideElement CARD_BUTTON = $x( "//div[@id='js-mini-cart-link']");
    private final SelenideElement SITE_LOGO = $x( "//img[contains(@alt,'9477014323230.png')]");
    private final SelenideElement CATALOG_BUTTON = $x( "//span[@class='catalog_menu__title']");
    private final SelenideElement CITIES_BUTTON = $x( "(//span[@class='b-login-link i-fw-b'])[1]");
    private final SelenideElement PHARMACIES_BUTTON = $x( "(//a[@href='/apteki/map'])[1]");
    private final SelenideElement SELECT_CITIES = $x( "(//div[contains(@class,'title i-float-l')])[2]");
    private final SelenideElement SEARCH_INPUT = $x( "//input[@id='js-site-search-input']");
    private final SelenideElement BASE_INPUT = $x( "(//a[@href='%s'])");
    private final SelenideElement PHONE_NUMBER = $x( "(//a[@class='b-icn--phone i-fw-b'])[1]");
    // private final Button FAVORITES_BUTTON = $x( "//div[@class='js-link-seo i-cr-pointer b-seo-link b-icn--favorites c-header__link--secondary js-header__favorites']");
    private final SelenideElement FAVORITES_BUTTON = $x( "(//div[contains(@class,'js-header__favorites')])[1]");
    private final SelenideElement GET_COUNT_FAVORITES = $x( "//div[@class='c-prod-item-list c-prod-item-list-favorites']");
    private final SelenideElement GET_SELECTED_REGION = $x( "(//span[@class='b-login-link i-fw-b'])[1]");

    //Методы

    @Step("Пользователь нажимает на иконку авторизации")
    public WebHeaderBlock clickToSignInButton() {
        SIGN_IN_BUTTON.click();
        logger.info("Пользователь нажимает на иконку авторизации");
        return this;
    }

    @Step("Пользователь нажимает на кнопку регистрации")
    public WebHeaderBlock clickToSignUpButton() {
        SIGN_UP_BUTTON.click();
        logger.info("Пользователь нажимает на иконку авторизации");
        return this;
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public WebHeaderBlock clickLogOut() {
        LOGOUT_BUTTON.click();
        logger.info("Пользователь нажимает на иконку авторизации");
        return this;
    }


    @Step("Пользователь нажимает на иконку личного кабинета")
    public WebHeaderBlock clickToPersonalAccount() {
        PERSONAL_ACCOUNT.click();
        logger.info("Пользователь нажимает на иконку личного кабинета");
        return this;
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public WebHeaderBlock clickMyOrders() {
        MY_ORDERS.click();
        logger.info("Пользователь нажимает на иконку авторизации");
        return this;
    }

    @Step("Пользователь нажимает на кнопку Личные данные")
    public WebHeaderBlock clickPersonalData() {
        PERSONAL_DATA.click();
        logger.info("Пользователь нажимает на кнопку Личные данные");
        return this;
    }

    @Step("Пользователь нажимает на кнопку Изменить пароль")
    public WebHeaderBlock clickChangePassword() {
        CHANGE_PASSWORD.click();
        logger.info("Пользователь нажимает на кнопку Изменить пароль");
        return this;
    }

    @Step("Проверка количества товаров в корзине")
    public int checkCartQuantity() {
        //String stringCartQuantity = CARD_COUNT.getText();
        String stringCartQuantity =  CARD_COUNT.getWrappedElement().getText();
        return Integer.parseInt(stringCartQuantity);
    }

    @Step("Пользователь нажимает на иконку корзины")
    public CartPage clickToCartButton() {
        CARD_BUTTON.click();
        logger.info("Пользователь нажимает на иконку корзины");
        return new CartPage();
    }

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect(){
        ((SelenideElement) SITE_LOGO.getWrappedElement()).shouldBe(Condition.visible);
        logger.info("Лого отображается");
    }

    @Step("Пользователь нажимает на иконку 36.6 и переходит на главную страницу")
    public WebHeaderBlock clickSiteLogo(){
        SITE_LOGO.click();
        logger.info("Пользователь нажимает на иконку 36.6 и переходит на главную страницу");
        return this;
    }

    @Step("Пользователь нажимает на кнопку Каталог")
    public WebHeaderBlock clickCatalogButton(){
        CATALOG_BUTTON.click();
        logger.info("Пользователь нажимает на кнопку Каталог");
        return this;
    }

    @Step("Пользователь нажимает на кнопку для выбора города")
    public WebHeaderBlock clickCitiesButton(){
        CITIES_BUTTON.click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
        return this;
    }

    @Step("Пользователь нажимает на кнопку аптеки и переходит на страницу с картой аптек")
    public WebHeaderBlock clickPharmaciesButton(){
        PHARMACIES_BUTTON.click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
        return this;
    }

    @Step("Проверка видимости попапа с выбором городов")
    public WebHeaderBlock checkCitiesPopUp(){
        String text = SELECT_CITIES.getText();
        logger.info("Проверка видимости попапа с выбором городов");
        return this;
    }

    @Step("Пользователь вводит артикул товара в поисковую строку - {vendorCode}")
    public WebHeaderBlock setSearchInput(String vendorCode) {
        SEARCH_INPUT.sendKeys(vendorCode);
      //  SEARCH_INPUT.sendKeys(Keys.ENTER);
        logger.info("Пользователь вводит артикул товара в поисковую строку");
        return this;
    }

/*
    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public WebHeaderBlock checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputHeaderLinks(String.format(BASE_INPUT, LOCATOR)).contentIsDisplayed(LINKTEXT);
        return this;
    }

    @Step("Кликает по локатору {LOCATOR}")
    public WebHeaderBlock selectHeaderButtons(String LOCATOR) {
        getBaseInputHeaderLocators(String.format(BASE_INPUT, LOCATOR)).click();
        return this;
    }
*/

    @Step("Пользователь нажимает кнопку избранное")
    public WebHeaderBlock clickFavoritesButton() {
        FAVORITES_BUTTON.click();
        logger.info("Пользователь нажимает кнопку избранное");
        return this;
    }

    @Step("Пользователь получает количество товаров в избранном")
    public WebHeaderBlock checkQuantityProductsOnFavoritesPage() {
        String stringFavoritesQuantity = GET_COUNT_FAVORITES.getAttribute("childElementCount");
        int quantity = Integer.parseInt(stringFavoritesQuantity);
        logger.info("Пользователь получает количество товаров в избранном");
        return this;
    }

    @Step("Пользователь проверяет выбранный регион")
    public WebHeaderBlock checkSelectedRegion(String regionName) {
        String region = GET_SELECTED_REGION.getText();
        assertEquals(region, regionName);
        logger.info("Пользователь проверяет выбранный регион");
        return this;
    }

}
