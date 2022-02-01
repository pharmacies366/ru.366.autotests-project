package pages.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartPage extends MainTestBase {

    //элементы
    private static final String TOTAL_PRICE_XPATH = "xpath;//div[@class='cart-summary_value js-revenue']";
    private static final String CLEAR_ALL_FROM_CARD_XPATH = "xpath;//a[contains(.,'Очистить все')]";
    private static final String CONFIRM_CLEAN_ALL_XPATH = "xpath;//input[@value='Да, подтверждаю']";
    private static final String CARD_COUNT_XPATH = "xpath;//div[contains(@class,'count js-mini-cart-count')]";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String MAKE_ORDER_XPATH = "xpath;//a[@href='/cart/checkout']";
    private static final String PRODUCT_CARD_XPATH = "xpath;//a[@data-gtm-source='search list']";

    //конструктор
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getTotalPrice() {
        return new PageElementActions(TOTAL_PRICE_XPATH, driver);
    }

    public PageElementActions getClearAllFromCart() {
        return new PageElementActions(CLEAR_ALL_FROM_CARD_XPATH, driver);
    }

    public PageElementActions getConfirmCleanAll() {
        return new PageElementActions(CONFIRM_CLEAN_ALL_XPATH, driver);
    }

    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_XPATH, driver);
    }

    public PageElementActions getClickAddCartButton() {
        return new PageElementActions(ADD_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getMakeOrder() {
        return new PageElementActions(MAKE_ORDER_XPATH, driver);
    }

    public PageElementActions getProductCard() {
        return new PageElementActions(PRODUCT_CARD_XPATH, driver);
    }


    //Методы
    @Step("Проверка состояния корзины: Если корзина не пустая, удаляем все содержимое")
    public void checkCartQuantity() {
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


    @Step("Сохранение итоговой суммы в корзине")
    public int getPriceTotal() {
        int price = getTotalPrice().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void сlickAddCartButton() {
        getClickAddCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
    }

    @Step("Пользователь нажимае на кнопку 'Оформить заказ'")
    public void clickToMakeOrder() {
        getMakeOrder().click();
        logger.info("Пользователь нажимае на кнопку 'Оформить заказ'");
    }

    @Step("Пользователь нажимает на товар")
    public void clickProductCard() {
        getProductCard().click();
        logger.info("Пользователь нажимает на товар");
    }

}
