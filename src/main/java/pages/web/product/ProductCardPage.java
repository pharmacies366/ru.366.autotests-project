package pages.web.product;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class ProductCardPage extends MainTestBase {


    //элементы
    private static final String PRICE_LABEL_XPATH = "xpath;(//span[@class='product_price__val'])[1]";
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;//span[contains(.,'В корзину')]";
    private static final String ONE_CLICK_XPATH = "xpath;(//div[@class='btn btn_secondary js-order-quick-navigate'])[1]";
    private static final String PHARMACY_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String ONE_CLICK_PHARMACY_BUTTONS_XPATH = "xpath;(//button[contains(.,'Купить в 1 клик')])";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//span[contains(@class, 'product_counter_short__plus')])[1]";
    private static final String QUANTITY_PRODUCT_XPATH = "xpath;(//span[contains(@class,'product_counter_short__qty')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String MAIN_BUTTON_XPATH = "xpath;//div[@class='breadcrumbs__item']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String REGION_TEXT_XPATH = "xpath;//h2[contains(.,'%s')]";
    private static final String BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH = "xpath;//div[@class='product__info__desc'][contains(.,'%s')]";
    private static final String RECIPE_INFO_XPATH = "xpath;(//div[contains(@class,'product__info__desc')])[6]";


    //конструктор
    public ProductCardPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getPriceLabel() {
        return new PageElementActions(PRICE_LABEL_XPATH, driver);
    }

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getOneClick() {
        return new PageElementActions(ONE_CLICK_XPATH, driver);
    }

    public PageElementActions getPharmacyMap() {
        return new PageElementActions(PHARMACY_MAP_XPATH, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }

    public PageElementActions getOneClickPharmacyButtons() {
        return new PageElementActions(ONE_CLICK_PHARMACY_BUTTONS_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getProductQuantity() {
        return new PageElementActions(QUANTITY_PRODUCT_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getMainButton() {
        return new PageElementActions(MAIN_BUTTON_XPATH, driver);
    }

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }

    public PageElementActions getRegionTest(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMainInformation(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getRecipeInfo() {
        return new PageElementActions(RECIPE_INFO_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public void clickAddCartButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'в корзину'");
    }

    @Step("Запоминаем цену товара")
    public int getProductPrice() {
        int price = getPriceLabel().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь нажимает на кнопку 'Купить в 1 клик'")
    public void buyOneClick() {
        getOneClick().click();
        logger.info("Пользователь нажимает на кнопку 'Купить в 1 клик'");
    }

    @Step("Пользователь проверяет отображении карты на странице")
    public void checkVisibilityMap() {
        getPharmacyMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }

    @Step("Пользователь вводит адрес - {address}")
    public void setInputSearchAddress(String address) {
        getPharmacyAddressInput().sendKeysAndEnter(address);
    }

    @Step("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки")
    public void clickBuyOneClick() {
        getOneClickPharmacyButtons().click();
        logger.info("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки");
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity() {
        getIncreaseQuantity().click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Сохранение количества товара")
    public int getQuantityProduct() {
        int quantity = getProductQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
    }

    @Step("Пользователь нажимает на иконку главная")
    public void clickMainButton() {
        getMainButton().click();
        logger.info("Пользователь нажимает на иконку главная");
    }

    @Step("Пользователь проверяет переход по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет переход по банеру");
    }

    @Step("Пользователь проверяет выбранный регион на странице")
    public void checkSelectedRegion(String regionName) {
        getRegionTest(String.format(REGION_TEXT_XPATH, regionName)).isElementDisplayed();
        logger.info("Пользователь проверяет выбранный регион на странице");
    }

    @Step("Пользователь проверяет содержание {titleName} : в блоке Основная информация")
    public void checkSomeMainInformation(String titleName) {
        getMainInformation(String.format(BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH, titleName)).isElementDisplayed();
        logger.info("Пользователь проверяет содержание {titleName} : в блоке Основная информация");
    }

}
