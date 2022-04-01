package pages.mobile.product;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MobileProductCardPage extends MainTestBase {


    //элементы
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;//form[@class='product_counter__form js-add-to-cart__form js-add-to-cart__form-hide ']//child::button";
    private static final String PRICE_LABLE_XPATH = "xpath;//span[contains(@class,'price ')]";
    private static final String ONE_CKICK_XPATH = "xpath;(//div[@class='btn btn_secondary js-order-quick-navigate'])[1]";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//label[@class='js-storefinder-sort js-product-stores__head-item js-storefinder-recommend']";
    private static final String ONE_CKICK_APTEKA_BUTTONS_XPATH = "xpath;(//button[@class='b-btn b-btn--third js-order-quick__button'])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//span[contains(@class,'plus js-qty-selector-plus-gz')])[2]";
    private static final String QUANTITY_PRODUCT_XPATH = "xpath;(//a[@class='product_counter_short__desc'])[2]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String MAIN_BUTTON_XPATH = "xpath;//div[@class='breadcrumbs__item']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String REGION_TEXT_XPATH = "xpath;//h2[contains(.,'%s')]";
    private static final String RECIPE_INFO_XPATH = "xpath;(//div[contains(@class,'product__info__desc')])[6]";

    //конструктор
    public MobileProductCardPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getPriceLable() {
        return new PageElementActions(PRICE_LABLE_XPATH, driver);
    }

    public PageElementActions getOneClick() {
        return new PageElementActions(ONE_CKICK_XPATH, driver);
    }

    public PageElementActions getAptekaMap() {
        return new PageElementActions(APTEKA_MAP_XPATH, driver);
    }

    public PageElementActions getPharmacyAddressInput() {
        return new PageElementActions(PHARMACY_ADDRESS_INPUT_XPATH, driver);
    }

    public PageElementActions getChangeAptekaList() {
        return new PageElementActions(CHANGE_APTEKA_LIST_XPATH, driver);
    }

    public PageElementActions getOneClickAptekaButtons() {
        return new PageElementActions(ONE_CKICK_APTEKA_BUTTONS_XPATH, driver);
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
        int price = getPriceLable().formatElementToValue();
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
        getAptekaMap().elementIsVisibility();
        logger.info("Пользователь проверяет отображении карты на странице");
    }

    @Step("Пользователь вводит адрес - {addres}")
    public void setInputSearchAddres(String addres) {
        getPharmacyAddressInput().sendKeysAndEnter(addres);
    }

    @Step("Пользователь нажимает на список доступных Аптек")
    public void clickChangeAptekaList() {
        pageActions.staticWait(500);
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на 1-ую кнопку 'Купить в 1 клик' напротив выбранной аптеки")
    public void clickBuyOneClick() {
        getOneClickAptekaButtons().click();
        logger.info("Пользователь нажимает на 1-ую кнопку 'Купить в 1 клик' напротив выбранной аптеки");
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

    @Step("Пользователь роверяет видимость кнопки в корзину")
    public void checkButtonToCartButton() {
        getCartButton().isElementDisplayed();
        logger.info("Пользователь роверяет видимость кнопки в корзину");
    }

    @Step("Пользователь нажимает на кнопку Главная")
    public void clickMainButton() {
        getMainButton().click();
        logger.info("Пользователь нажимает на кнопку Главная");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь проверяет выбранный регион на странице")
    public void checkSelectedRegion(String regionName) {
        getRegionTest(String.format(REGION_TEXT_XPATH, regionName)).isElementDisplayed();
        logger.info("Пользователь проверяет выбранный регион на странице");
    }


}
