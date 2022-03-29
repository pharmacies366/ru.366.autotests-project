package pages.web.main;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MainPage extends MainTestBase {

    //элементы
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";
    private static final String ADD_TO_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String QUANTITY_MATERIALS_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_plus')])[1]";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_minus')])[1]";
    private static final String FAVORITES_ICON_XPATH = "xpath;(//button[contains(@class,'button b-star')])[1]";
    private static final String BANNER_LIST_XPATH = "xpath;(//button[@type='button'])";
    private static final String CHECK_START_BANNER_XPATH = "xpath;//li[@class='slick-active' and @aria-controls='navigation00']";
    private static final String PREV_BANNER_XPATH = "xpath;//button[@class='slick-prev slick-arrow']";
    private static final String NEXT_BANNER_XPATH = "xpath;//button[@class='slick-next slick-arrow']";
    private static final String BANNER_PIN_BUTTONS_XPATH = "xpath;//button[@type='button'][contains(.,'%s')]";
    private static final String BANNERS_BUTTONS_XPATH = "xpath;(//div[@class='yCmsContentSlot'])[1]";
    private static final String MAIN_BUTTON_XPATH = "xpath;//div[@class='breadcrumbs__item']";
    private static final String QUANTITY_BANNERS_XPATH = "xpath;//ul[contains(@role,'tablist')]";
    private static final String CLOSE_POP_UP_NEWS_BUTTON_XPATH = "xpath;//div[@class='popmechanic-close']";
    private static final String CATALOG_BUTTON_XPATH = "xpath;//div[@class='catalog_menu js-switch-menu']";
    private static final String PRODUCT_BUTTON_XPATH = "xpath;(//img[@class=' lazyloaded'])[1]";
    private static final String BOT_CONSULTANT_BUTTON_XPATH = "xpath;//jdiv[@id='jvlabelWrap']";

    //конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getPopUpButton() {
        return new PageElementActions(POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getLetterN() {
        return new PageElementActions(LETTER_N_XPATH, driver);
    }

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getMaterialsQuantity() {
        return new PageElementActions(QUANTITY_MATERIALS_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getDecreaseQuantity() {
        return new PageElementActions(DECREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getFavoritesIcon() {
        return new PageElementActions(FAVORITES_ICON_XPATH, driver);
    }

    public PageElementActions getBannerList() {
        return new PageElementActions(BANNER_LIST_XPATH, driver);
    }

    public PageElementActions getCheckStartBanner() {
        return new PageElementActions(CHECK_START_BANNER_XPATH, driver);
    }

    public PageElementActions getPrevBannerButton() {
        return new PageElementActions(PREV_BANNER_XPATH, driver);
    }

    public PageElementActions getNextBannerButton() {
        return new PageElementActions(NEXT_BANNER_XPATH, driver);
    }

    public PageElementActions getBaseInputBannersPinLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBannersLocators() {
        return new PageElementActions(BANNERS_BUTTONS_XPATH, driver);
    }

    public PageElementActions getMainButton() {
        return new PageElementActions(MAIN_BUTTON_XPATH, driver);
    }


    public PageElementActions getStringQuantityBanners() {
        return new PageElementActions(QUANTITY_BANNERS_XPATH, driver);
    }

    public PageElementActions getClosePopUpNewsButton() {
        return new PageElementActions(CLOSE_POP_UP_NEWS_BUTTON_XPATH, driver);
    }

    public PageElementActions getCatalogButton() {
        return new PageElementActions(CATALOG_BUTTON_XPATH, driver);
    }

    public PageElementActions getProductButton() {
        return new PageElementActions(PRODUCT_BUTTON_XPATH, driver);
    }

    public PageElementActions getBotConsultantButton() {
        return new PageElementActions(BOT_CONSULTANT_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp() {
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь нажимает закрыть новосной попап")
    public void ClickClosePopUpNewsButton() {
        getClosePopUpNewsButton().click();
        logger.info("Пользователь нажимает закрыть новосной попап");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN() {
        getLetterN().click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void clickAddToCardButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getMaterialsQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity() {
        getIncreaseQuantity().click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public void clickDecreaseQuantity() {
        getDecreaseQuantity().click();
        logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
    }

    @Step("Пользователь добавляет товар в избранное")
    public void clickFavoritesIcon() {
        getFavoritesIcon().click();
        logger.info("Пользователь добавляет товар в избранное");
    }


    @Step("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому")
    public void checkNextBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getNextBannerButton().click();
            pageActions.staticWait(500);
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
        logger.info("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому");
    }

    @Step("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому")
    public void checkPrevBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getPrevBannerButton().click();
            pageActions.staticWait(500);
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
        logger.info("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому");
    }


    @Step("Пользователь переключает банеры по пинам")
    public void checkNextBannerButtons() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            pageActions.staticWait(500);
        }
        logger.info("Пользователь переключает банеры по пинам");
    }


    @Step("Пользователь переключает банеры по пинам и возвращается на главную страницу")
    public void checkBannersClickable() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            pageActions.staticWait(1000);
            getBannersLocators().click();
            getMainButton().click();
        }
        logger.info("Пользователь переключает банеры по пинам и возвращается на главную страницу");
    }


    @Step("Пользователь нажимает на кнопку каталог")
    public void clickCatalogButton() {
        getCatalogButton().click();
        logger.info("Пользователь нажимает на кнопку каталог");
    }

    @Step("Пользователь нажимает на первый товар в списке на главной странице")
    public void clickFirstProductOnMainPage() {
        getProductButton().click();
        logger.info("Пользователь нажимает на первый товар в списке на главной странице");
    }

    @Step("Пользователь нажимает на иконку консультант бота")
    public void clickBotConsultantButton() {
        getBotConsultantButton().click();
        logger.info("Пользователь нажимает на иконку консультант бота");
    }


}
