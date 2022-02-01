package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MobileProductCardPage extends MainTestBase {


    //элементы
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String PRICE_LABLE_XPATH = "xpath;(//span[@class='product_price__val'])[1]";
    private static final String ONE_CKICK_XPATH = "xpath;(//div[contains(.,'Купить в 1 клик')])[10]";
    private static final String APTEKA_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String CHANGE_APTEKA_LIST_XPATH = "xpath;//span[contains(.,'Списком')]";
    private static final String ONE_CKICK_APTEKA_BUTTONS_XPATH = "xpath;(//button[contains(.,'Купить в 1 клик')])";



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



    //Методы
    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public void clickToCartButton() {
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
        getChangeAptekaList().click();
        logger.info("Пользователь нажимает на список доступных Аптек");
    }

    @Step("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки")
    public void clickBuyOneClick() {
        getOneClickAptekaButtons().clickIndex(0);
        logger.info("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки");
    }

}
