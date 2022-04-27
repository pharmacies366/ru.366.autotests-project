package pages.web.main;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

/*    public final Button CHOOSE_MONTH_BUTTON = new Button($x("(//span[@class='input-group-addon'])[1]"));
    public final Button APPLY_CHANGES_BUTTON = new Button($x("//button[@class='btn btn-brand m-btn m-btn--icon btn_do_filter']"));
    public final Button NEXT_MONTH = new Button($x("(//span[@class='month focused active']/following::span)[1]"));
    public final TextBlock CURRENT_MONTH = new TextBlock($x("//span[@id='schedule-month-title']"));
    public final TextBlock CALENDAR_DOWNLOADING_MESSAGE = new TextBlock($x("//div[@id='schedule-overlay']//child::span"));
    public final String CALENDAR_ALL_WORKING_DAYS = "//td[@class='fc-event-container']//child::a";
    public final Table CALENDAR_TABLE = new Table($x("(//div[@class='fc-view fc-month-view fc-basic-view']//child::table)[1]"));
    public final Button ANOTHER_WORKER_BUTTON = new Button($x("(//span[@class='select2-selection__rendered'])[1]"));
    public final Button ANOTHER_WORKER = new Button($x("//li[@class='select2-results__option']"));*/


    private final Button POP_UP_BUTTON = new Button($x( "xpath;//button[contains(.,'Спасибо, понятно')]"));
    private final Button LETTER_N = new Button($x( "xpath;//a[@href='/littera-Н/']"));
    private final Button ADD_TO_CART_BUTTON = new Button($x( "xpath;(//span[contains(.,'В корзину')])[1]"));
    private final Button QUANTITY_MATERIALS = new Button($x( "xpath;(//div[contains(@class,'product_counter__qty')])[1]"));
    private final Button INCREASE_QUANTITY = new Button($x( "xpath;(//div[contains(@class,'btn btn_count_plus')])[1]"));
    private final Button DECREASE_QUANTITY = new Button($x( "xpath;(//div[contains(@class,'btn btn_count_minus')])[1]"));
    private final Button FAVORITES_ICON = new Button($x( "xpath;(//button[contains(@class,'button b-star')])[1]"));
    private final Button BANNER_LIST = new Button($x( "xpath;(//button[@type='button'])"));
    private final Button CHECK_START_BANNER = new Button($x( "xpath;//li[@class='slick-active' and @aria-controls='navigation00']"));
    private final Button PREV_BANNER = new Button($x( "xpath;//button[@class='slick-prev slick-arrow']"));
    private final Button NEXT_BANNER = new Button($x( "xpath;//button[@class='slick-next slick-arrow']"));
    private final Button BANNER_PIN_BUTTONS = new Button($x( "xpath;//button[@type='button'][contains(.,'%s')]"));
    private final Button BANNERS_BUTTONS = new Button($x( "xpath;(//div[@class='yCmsContentSlot'])[1]"));
    private final Button MAIN_BUTTON = new Button($x( "xpath;//div[@class='breadcrumbs__item']"));
    private final Button QUANTITY_BANNERS = new Button($x( "xpath;//ul[contains(@role,'tablist')]"));
    private final Button CLOSE_POP_UP_NEWS_BUTTON = new Button($x( "xpath;//div[@class='popmechanic-close']"));
    private final Button CATALOG_BUTTON = new Button($x( "xpath;//div[@class='catalog_menu js-switch-menu']"));
    private final Button PRODUCT_BUTTON = new Button($x( "xpath;(//img[@class=' lazyloaded'])[1]"));
    private final Button BOT_CONSULTANT_BUTTON = new Button($x( "xpath;//jdiv[@id='jvlabelWrap']"));





    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public MainPage clickClosePopUp() {
        POP_UP_BUTTON.click();
        return this;
      //  logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь нажимает закрыть новосной попап")
    public MainPage ClickClosePopUpNewsButton() {
        CLOSE_POP_UP_NEWS_BUTTON.click();
        return this;
       // logger.info("Пользователь нажимает закрыть новосной попап");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public MainPage clickLetterN() {
        LETTER_N.click();
        return this;
      //  logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public MainPage clickAddToCardButton() {
        ADD_TO_CART_BUTTON.click();
        return this;
       // logger.info("Пользователь нажимает на кнопку 'В корзину'");
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
        return this;
       // logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public MainPage clickDecreaseQuantity() {
        DECREASE_QUANTITY.click();
        return this;
      //  logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
    }

    @Step("Пользователь добавляет товар в избранное")
    public MainPage clickFavoritesIcon() {
        FAVORITES_ICON.click();
        return this;
      //  logger.info("Пользователь добавляет товар в избранное");
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
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            pageActions.staticWait(500);
        }
      //  logger.info("Пользователь переключает банеры по пинам");
    }
*/


/*
    @Step("Пользователь переключает банеры по пинам и возвращается на главную страницу")
    public MainPage checkBannersClickable() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            pageActions.staticWait(1000);
            getBannersLocators().click();
            getMainButton().click();
        }
       // logger.info("Пользователь переключает банеры по пинам и возвращается на главную страницу");
    }
*/


    @Step("Пользователь нажимает на кнопку каталог")
    public MainPage clickCatalogButton() {
        CATALOG_BUTTON.click();
        return this;
       // logger.info("Пользователь нажимает на кнопку каталог");
    }

    @Step("Пользователь нажимает на первый товар в списке на главной странице")
    public MainPage clickFirstProductOnMainPage() {
        PRODUCT_BUTTON.click();
        return this;
      //  logger.info("Пользователь нажимает на первый товар в списке на главной странице");
    }

    @Step("Пользователь нажимает на иконку консультант бота")
    public MainPage clickBotConsultantButton() {
        BOT_CONSULTANT_BUTTON.click();
        return this;
      //  logger.info("Пользователь нажимает на иконку консультант бота");
    }








   /* public MainPage getCurrentWorkMonthAndYear() {
        CURRENT_MONTH.getText();
        return this;
    }

    public MainPage getCurrentDate() {
        LocalDate.now().format(DateTimeFormatter.ofPattern("LLLL yyyy"));
        return this;
    }

    public int getWorkingDays() {
        ((SelenideElement) CALENDAR_DOWNLOADING_MESSAGE.getWrappedElement()).shouldNotBe(Condition.visible);
        List<WebElement> days = CALENDAR_TABLE.findElements(By.xpath(CALENDAR_ALL_WORKING_DAYS));
        days.removeIf(day -> day.getCssValue("background-color").equals("rgba(234, 234, 234, 1)"));
        return days.size();
    }


    public int getWeekends() {
        ((SelenideElement) CALENDAR_DOWNLOADING_MESSAGE.getWrappedElement()).shouldNotBe(Condition.visible);
        List<WebElement> days = CALENDAR_TABLE.findElements(By.xpath(CALENDAR_ALL_WORKING_DAYS));
        days.removeIf(day -> day.getCssValue("background-color").equals("rgba(52, 191, 163, 1)"));
        return days.size();
    }

    public MainPage chooseNextMonth() {
        CHOOSE_MONTH_BUTTON.click();
        NEXT_MONTH.click();
        APPLY_CHANGES_BUTTON.click();
        ((SelenideElement) CALENDAR_DOWNLOADING_MESSAGE.getWrappedElement()).shouldNotBe(Condition.visible);
        return this;
    }

    public MainPage chooseAnotherWorker() {
        ANOTHER_WORKER_BUTTON.click();
        ANOTHER_WORKER.click();
        APPLY_CHANGES_BUTTON.click();
        ((SelenideElement) CALENDAR_DOWNLOADING_MESSAGE.getWrappedElement()).shouldNotBe(Condition.visible);
        return this;
    }*/
}
