package pages.web.main;

import core.MainTestBase;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта https://366.ru/
 */

public class MainPage extends MainTestBase {

    private final Button POP_UP_BUTTON = new Button($x( "//button[contains(.,'Спасибо, понятно')]"));
    private final Button LETTER_N = new Button($x( "//a[@href='/littera-Н/']"));
    private final Button ADD_TO_CART_BUTTON = new Button($x( "(//span[contains(.,'В корзину')])[1]"));
    private final Button QUANTITY_MATERIALS = new Button($x( "(//div[contains(@class,'product_counter__qty')])[1]"));
    private final Button INCREASE_QUANTITY = new Button($x( "(//div[contains(@class,'btn btn_count_plus')])[1]"));
    private final Button DECREASE_QUANTITY = new Button($x( "(//div[contains(@class,'btn btn_count_minus')])[1]"));
    private final Button FAVORITES_ICON = new Button($x( "(//button[contains(@class,'button b-star')])[1]"));
    private final Button BANNER_LIST = new Button($x( "(//button[@type='button'])"));
    private final Button CHECK_START_BANNER = new Button($x( "//li[@class='slick-active' and @aria-controls='navigation00']"));
    private final Button PREV_BANNER = new Button($x( "//button[@class='slick-prev slick-arrow']"));
    private final Button NEXT_BANNER = new Button($x( "//button[@class='slick-next slick-arrow']"));
    private final Button BANNER_PIN_BUTTONS = new Button($x( "//button[@type='button'][contains(.,'%s')]"));
    private final Button BANNERS_BUTTONS = new Button($x( "xpath;(//div[@class='yCmsContentSlot'])[1]"));
    private final Button MAIN_BUTTON = new Button($x( "//div[@class='breadcrumbs__item']"));
    private final Button QUANTITY_BANNERS = new Button($x( "//ul[contains(@role,'tablist')]"));
    private final Button CLOSE_POP_UP_NEWS_BUTTON = new Button($x( "//div[@class='popmechanic-close']"));
    private final Button CATALOG_BUTTON = new Button($x( "//div[@class='catalog_menu js-switch-menu']"));
    private final Button PRODUCT_BUTTON = new Button($x( "(//img[@class=' lazyloaded'])[1]"));
    private final Button BOT_CONSULTANT_BUTTON = new Button($x( "//jdiv[@id='jvlabelWrap']"));





    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public MainPage clickClosePopUp() {
        POP_UP_BUTTON.click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
        return this;
    }

    @Step("Пользователь нажимает закрыть новосной попап")
    public MainPage ClickClosePopUpNewsButton() {
        CLOSE_POP_UP_NEWS_BUTTON.click();
        logger.info("Пользователь нажимает закрыть новосной попап");
        return this;
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public MainPage clickLetterN() {
        LETTER_N.click();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
        return this;
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public MainPage clickAddToCardButton() {
        ADD_TO_CART_BUTTON.click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
        return this;
    }

/*    @Step("Сохранение количества товаров")
    public MainPage getQuantityMaterials() {
        int quantity = getMaterialsQuantity().formatElementToValue();
       // logger.info("Запоминаем количество товара");
        return quantity;
    }*/

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public MainPage clickIncreaseQuantity() {
        INCREASE_QUANTITY.click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
        return this;
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public MainPage clickDecreaseQuantity() {
        DECREASE_QUANTITY.click();
        logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
        return this;
    }

    @Step("Пользователь добавляет товар в избранное")
    public MainPage clickFavoritesIcon() {
        FAVORITES_ICON.click();
        logger.info("Пользователь добавляет товар в избранное");
        return this;
    }


/*    @Step("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому")
    public MainPage checkNextBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getNextBannerButton().click();
            pageActions.staticWait(500);
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
      //  logger.info("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому");
    }*/

/*
    @Step("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому")
    public MainPage checkPrevBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getPrevBannerButton().click();
            pageActions.staticWait(500);
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
       // logger.info("Пользователь кликает по стрелке назад, переключает банеры и проверяет, что возвращается к первому");
    }


    @Step("Пользователь переключает банеры по пинам")
    public MainPage checkNextBannerButtons() {
        String sizeAllLi = QUANTITY_BANNERS.getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS, i)).click();
        }
        logger.info("Пользователь переключает банеры по пинам");
        return this;
    }
*/



/*
    @Step("Пользователь переключает банеры по пинам и возвращается на главную страницу")
    public MainPage checkBannersClickable() {
        String sizeAllLi = QUANTITY_BANNERS.getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS, i)).click();
            BANNERS_BUTTONS.click();
            MAIN_BUTTON.click();
        }
        logger.info("Пользователь переключает банеры по пинам и возвращается на главную страницу");
        return this;
    }
*/



    @Step("Пользователь нажимает на кнопку каталог")
    public MainPage clickCatalogButton() {
        CATALOG_BUTTON.click();
        logger.info("Пользователь нажимает на кнопку каталог");
        return this;
    }

    @Step("Пользователь нажимает на первый товар в списке на главной странице")
    public MainPage clickFirstProductOnMainPage() {
        PRODUCT_BUTTON.click();
        logger.info("Пользователь нажимает на первый товар в списке на главной странице");
        return this;
    }

    @Step("Пользователь нажимает на иконку консультант бота")
    public MainPage clickBotConsultantButton() {
        BOT_CONSULTANT_BUTTON.click();
        logger.info("Пользователь нажимает на иконку консультант бота");
        return this;
    }
}
