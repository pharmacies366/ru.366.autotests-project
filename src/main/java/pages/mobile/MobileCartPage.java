package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;

public class MobileCartPage extends MainTestBase {
    private Logger logger = LogManager.getLogger(MobileCartPage.class);
    private PropertiesManager propertiesManager = new PropertiesManager();

    //элементы
    private static final String TOTAL_PRICE_XPATH = "xpath;//div[@class='cart-summary_value js-revenue']";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;//span[contains(.,'В корзину')]";
    private static final String CARD_BUTTON_XPATH = "xpath;//span[@class='mini_cart_link__icon']";
    private static final String MAKE_ORDER_XPATH = "xpath;//a[@href='/cart/checkout']";



    //конструктор
    public MobileCartPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getTotalPrice() {
        return new PageElementActions(TOTAL_PRICE_XPATH, driver);
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



    //Методы
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
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().click();
        logger.info("Пользователь нажимает на иконку корзины");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимае на кнопку 'Оформить заказ'")
    public void clickToMakeOrder() {
        getMakeOrder().click();
        logger.info("Пользователь нажимае на кнопку 'Оформить заказ'");
        saveAllureScreenshot();
    }


}
