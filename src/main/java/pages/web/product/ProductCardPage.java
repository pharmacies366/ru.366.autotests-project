package pages.web.product;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class ProductCardPage extends MainTestBase {


    //элементы
    private static final String PRICE_LABEL_XPATH = "xpath;(//span[@class='product_price__val'])[1]";
    private static final String ADD_TO_CARD_BUTTON_XPATH = "xpath;(//span[contains(.,'Купить')])[1]";
    private static final String ONE_CLICK_XPATH = "xpath;(//div[@class='btn btn_secondary js-order-quick-navigate'])[1]";
    private static final String PHARMACY_MAP_XPATH = "xpath;//*[@id='store-finder-map']";
    private static final String PHARMACY_ADDRESS_INPUT_XPATH = "xpath;//input[@name='q']";
    private static final String ONE_CLICK_PHARMACY_BUTTONS_XPATH = "xpath;(//button[contains(.,'Купить в 1 клик')])";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//span[contains(@class, 'product_counter_short__plus')])[1]";
    private static final String QUANTITY_PRODUCT_XPATH = "xpath;(//span[contains(@class,'product_counter_short__qty')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String MAIN_BUTTON_XPATH = "xpath;//div[@class='breadcrumbs__item']";
    private static final String BANNER_XPATH = "xpath;//img[@class='b-bnr--responsive__img ']";
    private static final String REGION_TEXT_XPATH = "xpath;//h2[contains(.,'%s')]";
    private static final String BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH = "xpath;//div[@class='product__info__desc'][contains(.,'%s')]";
    private static final String RECIPE_INFO_XPATH = "xpath;(//div[contains(@class,'product__info__desc')])[6]";

    private static final String BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;(//div[@class='card-balance--inner js-show-bonus'])[4]";
    private static final String PRODUCT_GALLERY_BONUSES_BUTTON_XPATH = "xpath;(//span[@class='card-balance--inner-text-quantity'])[4]";

    private static final String PLUS_ON_BONUS_BUTTON_XPATH = "xpath;(//div[@class='c-card-balance__text c-card-balance__text--list'])[1][contains(.,'+')]";
    private static final String COUNT_BONUSES_XPATH = "xpath;(//span[@class='card-balance--inner-text-quantity'])[1]";
    private static final String TEXT_WORD_BONUSES_XPATH = "xpath;(//span[@class='card-balance--inner-text-bonus'])[1]";
    private static final String PLUS_BUTTON_WITH_COUNT_BONUSES_XPATH = "xpath;(//div[@class='card-balance--inner-icon'])[1]";
    private static final String CASH_BACK_INFO_POP_UP_XPATH = "xpath;//div[@class='hint__title']";
    private static final String LINK_MORE_ABOUT_BONUSES_XPATH = "xpath;//a[@href='/pravila_programmy/'][contains(.,'Подробнее о бонусах')]";


    public PageElementActions getBackgroundColorProductGalleryButton() {
        return new PageElementActions(BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getProductGalleryBonusesButton() {
        return new PageElementActions(PRODUCT_GALLERY_BONUSES_BUTTON_XPATH, driver);
    }

    public PageElementActions getPlusOnBonusButton() {
        return new PageElementActions(PLUS_ON_BONUS_BUTTON_XPATH, driver);
    }
    public PageElementActions getCashBackInfoPopUp() {
        return new PageElementActions(CASH_BACK_INFO_POP_UP_XPATH, driver);
    }

    public PageElementActions getMoreAboutBonuses() {
        return new PageElementActions(LINK_MORE_ABOUT_BONUSES_XPATH, driver);
    }




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

    public PageElementActions getCountBonuses() {
        return new PageElementActions(COUNT_BONUSES_XPATH, driver);
    }

    public PageElementActions getTextWordBonuses() {
        return new PageElementActions(TEXT_WORD_BONUSES_XPATH, driver);
    }
    public PageElementActions getcolorPlusOnMainProductAboutBonuses() {
        return new PageElementActions(PLUS_BUTTON_WITH_COUNT_BONUSES_XPATH, driver);
    }

    //Методы

    @Step("Пользователь нажимает на кнопку 'Купить'")
    public void clickAddCartButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'Купить");
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


    @Step("Получение цвета начисляемых бонусов")
    public String getColorCountBonuses() {
        String colorCountBonuses = getCountBonuses().getColor();
        logger.info("Получение цвета начисляемых бонусов");
        return colorCountBonuses;
    }

    @Step("Получение цвета текста кнопки с расчётом бонусов")
    public String getColorTextProductGalleryButton() {
        String colorButton = getProductGalleryBonusesButton().getColor();
        logger.info("Получение цвета текста кнопки с расчётом бонусов");
        return colorButton;
    }

    @Step("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'")
    public void checkPlusOnBonusButton() {
        getPlusOnBonusButton().isElementDisplayed();
        logger.info("Пользователь проверяет, что на шильдике с количеством бонусов присутствует значок '+'");
    }
    @Step("Получение цвета теста слова бонусов")
    public String checkColorTextWordBonuses() {
        String colorTextWordBonuses = getTextWordBonuses().getColor();
        logger.info("Получение цвета теста слова бонусов");
        return colorTextWordBonuses;
    }

    @Step("Пользователь проверяет, что в тексте об информации о начисляемых бонусах присутствует значок '+'")
    public void checkPlusOnMainProductAboutBonuses() {
        getcolorPlusOnMainProductAboutBonuses().isElementDisplayed();
        logger.info("Пользователь проверяет, что в тексте об информации о начисляемых бонусах присутствует значок '+'");
    }

    @Step("Пользователь проверяет, что в тексте об информации о начисляемых бонусах значок '+' синего цвета")
    public void checkPlusColorOnMainProductAboutBonuses() {
        getcolorPlusOnMainProductAboutBonuses().getColor();
        logger.info("Пользователь проверяет, что в тексте об информации о начисляемых бонусах значок '+' синего цвета");
    }

    @Step("Получение цвета кнопки")
    public String getColorBackgroundProductGalleryButton() {
        String colorButton = getBackgroundColorProductGalleryButton().getColor();
        logger.info("Получение цвета кнопки");
        return colorButton;
    }

    @Step("Получение текста загаловка с попапом информации про -  Cash back за покупку")
    public String getTextAboutCashBack() {
        String text = getCashBackInfoPopUp().getText();
        logger.info("Получение текста загаловка с попапом информации про -  Cash back за покупку");
        return text;
    }

    @Step("Пользователь переходит по ссылке: Подробнее о бонусах")
    public void clickOnLinkMoreAboutBonuses() {
        getMoreAboutBonuses().click();
        logger.info("ользователь переходит по ссылке: Подробнее о бонусах");
    }
}