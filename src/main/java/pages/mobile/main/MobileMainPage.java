package pages.mobile.main;

import actions.PageActions;
import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMainPage extends MainTestBase {

    PageActions pageActions = new PageActions(driver);

    //элементы
    private static final String SITE_LOGO_XPATH = "xpath;//img[@alt='9477014323230.png']";
    private static final String POP_UP_BUTTON_XPATH = "xpath;//button[contains(.,'Спасибо, понятно')]";
    private static final String CLOSE_POP_UP_NEWS_BUTTON_XPATH = "xpath;//div[@class='popmechanic-close']";
    private static final String MOBILE_APP_POP_UP_BUTTON_XPATH = "xpath;//div[@class='b-apps-flyer--close js-apps-flyer--close']";
    private static final String LETTER_N_XPATH = "xpath;//a[@href='/littera-Н/']";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'Купить')])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[@data-autotest='plus_button'])[1]";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;(//div[@data-autotest='minus_button'])[1]";
    private static final String QUANTITY_MATERIALS_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String FAVORITES_ICON_XPATH = "xpath;(//button[contains(@class,'button b-star')])[1]";
    private static final String QUANTITY_BANNERS_XPATH = "xpath;//ul[contains(@role,'tablist')]";
    private static final String BANNER_PIN_BUTTONS_XPATH = "xpath;//button[@type='button'][contains(.,'%s')]";
    private static final String BANNERS_BUTTONS_XPATH = "xpath;(//div[@class='yCmsContentSlot'])[1]";
    private static final String PRODUCT_BUTTON_XPATH = "xpath;(//img[@class=' lazyloaded'])[1]";
    private static final String ADD_TO_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'Купить')])[1]";
    private static final String BOT_CONSULTANT_BUTTON_XPATH = "xpath;//jdiv[contains(@class,'iconWrap')]";
    private static final String BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;(//div[@class='card-balance--inner js-show-bonus'])[1]";
    private static final String COLOR_TEXT_PRODUCT_GALLERY_BUTTON_XPATH = "xpath;(//span[@class='card-balance--inner-text-quantity'])[1]";
    private static final String CASH_BACK_INFO_POP_UP_XPATH = "xpath;//div[@class='popup__title'][contains(.,'Cash back за покупку')]";
    private static final String LINK_MORE_ABOUT_BONUSES_XPATH = "xpath;//a[@href='/pravila_programmy/'][contains(.,'Подробнее о бонусах')]";
    private static final String BUTTON_BONUSES_XPATH = "xpath;(//div[@class='card-balance--inner-icon'])[1]";
    private static final String MAIN_BUTTON_XPATH = "xpath;//div[@class='breadcrumbs__item']";


    //конструктор
    public MobileMainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getSiteLogo() {
        return new PageElementActions(SITE_LOGO_XPATH, driver);
    }

    public PageElementActions getPopUpButton() {
        return new PageElementActions(POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getClosePopUpNewsButton() {
        return new PageElementActions(CLOSE_POP_UP_NEWS_BUTTON_XPATH, driver);
    }

    public PageElementActions getLetterN() {
        return new PageElementActions(LETTER_N_XPATH, driver);
    }

    public PageElementActions getMobileAppPopUpButton() {
        return new PageElementActions(MOBILE_APP_POP_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getClickAddCartButton() {
        return new PageElementActions(ADD_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getDecreaseQuantity() {
        return new PageElementActions(DECREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getMaterialsQuantity() {
        return new PageElementActions(QUANTITY_MATERIALS_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getFavoritesIcon() {
        return new PageElementActions(FAVORITES_ICON_XPATH, driver);
    }

    public PageElementActions getStringQuantityBanners() {
        return new PageElementActions(QUANTITY_BANNERS_XPATH, driver);
    }

    public PageElementActions getBaseInputBannersPinLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getBannersLocators() {
        return new PageElementActions(BANNERS_BUTTONS_XPATH, driver);
    }

    public PageElementActions getProductButton() {
        return new PageElementActions(PRODUCT_BUTTON_XPATH, driver);
    }

    public PageElementActions getBotConsultantButton() {
        return new PageElementActions(BOT_CONSULTANT_BUTTON_XPATH, driver);
    }

    public PageElementActions getBackgroundColorProductGalleryButton() {
        return new PageElementActions(BACKGROUND_COLOR_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getTextColorProductGalleryButton() {
        return new PageElementActions(COLOR_TEXT_PRODUCT_GALLERY_BUTTON_XPATH, driver);
    }

    public PageElementActions getCashBackInfoPopUp() {
        return new PageElementActions(CASH_BACK_INFO_POP_UP_XPATH, driver);
    }

    public PageElementActions getMoreAboutBonuses() {
        return new PageElementActions(LINK_MORE_ABOUT_BONUSES_XPATH, driver);
    }

    public PageElementActions getButtonBonuses() {
        return new PageElementActions(BUTTON_BONUSES_XPATH, driver);
    }

    public PageElementActions getMainButton() {
        return new PageElementActions(MAIN_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь закрывает попап куки: 'Спасибо, понятно")
    public void clickClosePopUp(){
        getPopUpButton().click();
        logger.info("Пользователь закрывает попап куки: 'Спасибо, понятно'");
    }

    @Step("Пользователь нажимает закрыть новосной попап")
    public void ClickClosePopUpNewsButton() {
        getClosePopUpNewsButton().click();
        logger.info("Пользователь нажимает закрыть новосной попап");
    }

    @Step("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'")
    public void clickCloseMobileAppPopUp(){
        getMobileAppPopUpButton().click();
        logger.info("Пользователь закрывает попап мобильного приложения: 'Приложение 36.6'");
    }

    @Step("Проверка отображения логотипа сайта на главной странице")
    public void checkElementIsCorrect(){
        getSiteLogo().elementIsVisibility();
        logger.info("Лого отображается");
    }

    @Step("Пользователь нажимает на иконку 36.6 и переходит на главную страницу")
    public void clickSiteLogo(){
        getSiteLogo().click();
        logger.info("Пользователь нажимает на иконку 36.6 и переходит на главную страницу");
    }

    @Step("Пользователь нажимает на букву 'Н' Русского алфавита")
    public void clickLetterN(){
        getLetterN().clickJs();
        logger.info("Пользователь нажимает на букву 'Н' Русского алфавита");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void AddToCartClick(){
        getClickAddCartButton().clickJs();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity(){
        getIncreaseQuantity().clickJs();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public void clickDecreaseQuantity(){
        getDecreaseQuantity().clickJs();
        logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
    }

    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getMaterialsQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().clickJs();
        logger.info("Пользователь нажимает на иконку корзины");
    }

    @Step("Пользователь добавляет товар в избранное")
    public void clickFavoritesIcon() {
        getFavoritesIcon().click();
        logger.info("Пользователь добавляет товар в избранное");
    }

    @Step("Пользователь нажимает на первый товар в списке на главной странице")
    public void clickFirstProductOnMainPage() {
        getProductButton().click();
        logger.info("Пользователь нажимает на первый товар в списке на главной странице");
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void clickAddToCardButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }



/*    @Step("Пользователь переключает вперед банеры и проверяет, что возвращается к первому")
    public void checkNextBannerList() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBannersLocators().drugAndDrop(By.xpath(""));
            getBannerList().isElementDisplayedWithIndex(i);
        }
        getCheckStartBanner().isElementDisplayed();
        logger.info("Пользователь кликает по стрелке вперед, переключает банеры и проверяет, что возвращается к первому");
    }*/


    @Step("Пользователь переключает банеры по пинам")
    public void checkNextBannerButtons() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
        }
        logger.info("Пользователь переключает банеры по пинам");
    }

    @Step("Пользователь переключает банеры по пинам, нажимает на текущий банер, после перехода возвращается на главную страницу")
    public void checkBannersClickable() {
        String sizeAllLi = getStringQuantityBanners().getAttribute("childElementCount");
        getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, 1)).click();
        int quantity = Integer.parseInt(sizeAllLi);
        for (int i = 1; i <= quantity; i++) {
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, i)).click();
            pageActions.staticWait(1000);
            getBannersLocators().click();
            getMainButton().click();
            getBaseInputBannersPinLocators(String.format(BANNER_PIN_BUTTONS_XPATH, 1)).moveToElement();

        }
        logger.info("Пользователь переключает банеры по пинам и возвращается на главную страницу");
    }


    @Step("Пользователь нажимает на иконку консультант бота")
    public void clickBotConsultantButton() {
        getBotConsultantButton().click();
        logger.info("Пользователь нажимает на иконку консультант бота");
    }

    @Step("Получение цвета кнопки")
    public String getColorBackgroundProductGalleryButton() {
        String colorButton = getBackgroundColorProductGalleryButton().getColor();
        logger.info("Получение цвета кнопки");
        return colorButton;
    }

    @Step("Получение цвета текста кнопки с расчётом бонусов")
    public String getColorTextProductGalleryButton() {
        String colorButton = getTextColorProductGalleryButton().getColor();
        logger.info("Получение цвета текста кнопки с расчётом бонусов");
        return colorButton;
    }

    @Step("Получение текста загаловка с попапом информации про -  Cash back за покупку")
    public String getTextAboutCashBack() {
        String text = getCashBackInfoPopUp().getText();
        logger.info("Получение текста загаловка с попапом информации про -  Cash back за покупку");
        return text;
    }

    @Step("Пользователь нажимает на шильдик с бонусными баллами")
    public void clickOnButtonBonuses() {
        getButtonBonuses().clickJs();
        logger.info("Пользователь нажимает на шильдик с бонусными баллами");
    }

    @Step("Пользователь переходит по ссылке: Подробнее о бонусах")
    public void clickOnLinkMoreAboutBonuses() {
        getMoreAboutBonuses().click();
        logger.info("ользователь переходит по ссылке: Подробнее о бонусах");
    }

}
