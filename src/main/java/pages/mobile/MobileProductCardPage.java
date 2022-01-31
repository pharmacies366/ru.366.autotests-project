package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class MobileProductCardPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileProductCardPage.class);

    //элементы
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String PRICE_LABLE_XPATH = "xpath;(//span[@class='product_price__val'])[1]";



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



    //Методы
    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public void clickToCartButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'в корзину'");
        saveAllureScreenshot();
    }

    @Step("Запоминаем цену товара")
    public int getProductPrice() {
        int price = getPriceLable().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }




}