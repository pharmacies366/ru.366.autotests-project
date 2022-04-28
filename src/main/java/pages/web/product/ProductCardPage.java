package pages.web.product;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCardPage {


    //элементы
    private final Button PRICE_LABEL = new Button($x( "(//span[@class='product_price__val'])[1]"));
    private final Button ADD_TO_CARD_BUTTON = new Button($x( "//span[contains(.,'В корзину')]"));
    private final Button ONE_CLICK = new Button($x( "(//div[@class='btn btn_secondary js-order-quick-navigate'])[1]"));
    private final Button PHARMACY_MAP = new Button($x( "//*[@id='store-finder-map']"));
    private final Button PHARMACY_ADDRESS_INPUT = new Button($x( "//input[@name='q']"));
    private final Button ONE_CLICK_PHARMACY_BUTTONS = new Button($x( "(//button[contains(.,'Купить в 1 клик')])"));
    private final Button INCREASE_QUANTITY = new Button($x( "(//span[contains(@class, 'product_counter_short__plus')])[1]"));
    private final Button QUANTITY_PRODUCT = new Button($x( "(//span[contains(@class,'product_counter_short__qty')])[1]"));
    private final Button CARD_BUTTON = new Button($x( "//div[@id='js-mini-cart-link']"));
    private final Button MAIN_BUTTON = new Button($x( "//div[@class='breadcrumbs__item']"));
    private final Button BANNER = new Button($x( "//img[@class='b-bnr--responsive__img ']"));
    private final Button REGION_TEXT = new Button($x( "//h2[contains(.,'%s')]"));
    private final Button BASE_INPUT_CHECK_MAIN_INFORMATION = new Button($x( "//div[@class='product__info__desc'][contains(.,'%s')]"));
    private final Button RECIPE_INFO = new Button($x( "(//div[contains(@class,'product__info__desc')])[6]"));


    //Методы

    @Step("Пользователь нажимает на кнопку 'в корзину'")
    public ProductCardPage clickAddCartButton() {
        ADD_TO_CARD_BUTTON.click();
     //   logger.info("Пользователь нажимает на кнопку 'в корзину'");
        return this;
    }

/*    @Step("Запоминаем цену товара")
    public ProductCardPage getProductPrice() {
        int price = PRICE_LABEL.formatElementToValue();
       // logger.info("Запоминаем цену товара");
        return this;
    }*/

    @Step("Пользователь нажимает на кнопку 'Купить в 1 клик'")
    public ProductCardPage buyOneClick() {
        ONE_CLICK.click();
       // logger.info("Пользователь нажимает на кнопку 'Купить в 1 клик'");
        return this;
    }

/*    @Step("Пользователь проверяет отображении карты на странице")
    public ProductCardPage checkVisibilityMap() {
        PHARMACY_MAP.elementIsVisibility();
       // logger.info("Пользователь проверяет отображении карты на странице");
        return this;
    }*/

    @Step("Пользователь вводит адрес - {address}")
    public ProductCardPage setInputSearchAddress(String address) {
        PHARMACY_ADDRESS_INPUT.sendKeys(address);
        PHARMACY_ADDRESS_INPUT.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки")
    public ProductCardPage clickBuyOneClick() {
        ONE_CLICK_PHARMACY_BUTTONS.click();
       // logger.info("Пользователь нажимает на {number} - ую кнопку 'Купить в 1 клик' напротив выбранной аптеки");
        return this;
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public ProductCardPage clickIncreaseQuantity() {
        INCREASE_QUANTITY.click();
       // logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
        return this;
    }

/*    @Step("Сохранение количества товара")
    public ProductCardPage getQuantityProduct() {
        int quantity = QUANTITY_PRODUCT.formatElementToValue();
       // logger.info("Запоминаем количество товара");
        return this;
    }*/

    @Step("Пользователь нажимает на иконку корзины")
    public ProductCardPage clickToCartButton() {
        CARD_BUTTON.click();
        //logger.info("Пользователь нажимает на иконку корзины");
        return this;
    }

    @Step("Пользователь нажимает на иконку главная")
    public ProductCardPage clickMainButton() {
        MAIN_BUTTON.click();
       // logger.info("Пользователь нажимает на иконку главная");
        return this;
    }

    @Step("Пользователь проверяет переход по банеру")
    public ProductCardPage clickBanner() {
        BANNER.click();
       // logger.info("Пользователь проверяет переход по банеру");
        return this;
    }

/*    @Step("Пользователь проверяет выбранный регион на странице")
    public ProductCardPage checkSelectedRegion(String regionName) {
        REGION_TEXT(String.format(REGION_TEXT, regionName)).isElementDisplayed();
        //logger.info("Пользователь проверяет выбранный регион на странице");
        return this;
    }

    @Step("Пользователь проверяет содержание {titleName} : в блоке Основная информация")
    public ProductCardPage checkSomeMainInformation(String titleName) {
        BASE_INPUT_CHECK_MAIN_INFORMATION(String.format(BASE_INPUT_CHECK_MAIN_INFORMATION, titleName)).isElementDisplayed();
        //logger.info("Пользователь проверяет содержание {titleName} : в блоке Основная информация");
        return this;
    }*/

}
