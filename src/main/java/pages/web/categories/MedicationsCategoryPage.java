package pages.web.categories;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MedicationsCategoryPage extends MainTestBase {

    //элементы
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String SLIDER_FROM_XPATH = "xpath;//span[@class='irs-slider from']";
    private static final String SLIDER_TO_XPATH = "xpath;//span[@class='irs-slider to']";
    private static final String PRICE_RANGE_FROM_XPATH = "xpath;//input[@class='b-range__input js-range-from']";
    private static final String PRICE_RANGE_TO_XPATH = "xpath;//input[@class='b-range__input js-range-to']";
    private static final String PRODUCT_PRICES_RANGE_LIST_XPATH = "xpath;//div[@class='listing_product__price']";
    private static final String PRODUCT_PRICES_LIST_XPATH = "xpath;//div[@class='listing_product__price']//child::span";

    private static final String BASE_INPUT_DELETE_PRODUCT_XPATH = "xpath;(//div[@class='listing_product__price']//child::span)[%s]";


    //конструктор
    public MedicationsCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }

    public PageElementActions getSliderFrom() {
        return new PageElementActions(SLIDER_FROM_XPATH, driver);
    }

    public PageElementActions getSliderTo() {
        return new PageElementActions(SLIDER_TO_XPATH, driver);
    }

    public PageElementActions getPriceRangeFrom() {
        return new PageElementActions(PRICE_RANGE_FROM_XPATH, driver);
    }

    public PageElementActions getPriceRangeTo() {
        return new PageElementActions(PRICE_RANGE_TO_XPATH, driver);
    }

    public PageElementActions getProductPricesRangeList() {
        return new PageElementActions(PRODUCT_PRICES_RANGE_LIST_XPATH, driver);
    }

    public PageElementActions getProductPricesList() {
        return new PageElementActions(PRODUCT_PRICES_LIST_XPATH, driver);
    }

    public PageElementActions getBaseInputDeleteProduct(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы
    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(2000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь изменяет нижный и верхний диапозон цены")
    public void changePricesRangeWihtSlider() {
        getSliderFrom().drugAndDropToOffSet(50, 0);
        getSliderTo().drugAndDropToOffSet(-50, 0);
        logger.info("Пользователь изменяет нижный и верхний диапозон цены");
    }

    @Step("Пользователь получает значение начального диапазона цены")
    public int getFromPriceRange() {
        logger.info("Пользователь получает значение начального диапазона цены");
        String priseRangeFrom = getPriceRangeFrom().getAttribute("placeholder");
        int price = Integer.parseInt(priseRangeFrom);
        return price;
    }

    @Step("Пользователь получает значение конечного диапазона цены")
    public int getToPriceRange() {
        logger.info("Пользователь получает значение конечного диапазона цены");
        String priseRangeTo = getPriceRangeTo().getAttribute("placeholder");
        int price = Integer.parseInt(priseRangeTo);
        return price;
    }

    @Step("Пользователь прописывает нижный и верхний диапозон цены")
    public void changePricesRangeWithHands(String fromPrice, String toPrice) {
        getPriceRangeFrom().clean();
        getPriceRangeFrom().sendKeys(fromPrice);
        getPriceRangeTo().clean();
        getPriceRangeTo().sendKeysAndEnter(toPrice);
        logger.info("Пользователь прописывает нижный и верхний диапозон цены");
    }

    @Step("Пользователь проверяет что после установки диапазона цен, цены на товары показываются в верном диапазоне")
    public void checkChangeProductsPrices(int fromPrice, int toPrice) {
        int par = getProductPricesRangeList().getSize();
        for (int i = 1; i <= par; i++) {
            int price = getBaseInputDeleteProduct(String.format(BASE_INPUT_DELETE_PRODUCT_XPATH, i)).formatElementToValue();
            Assert.assertTrue(price >= fromPrice);
            Assert.assertTrue(price <= toPrice);
        }
        logger.info("Пользователь проверяет что после установки диапазона цен, цены на товары показываются в верном диапазоне");
    }

}
