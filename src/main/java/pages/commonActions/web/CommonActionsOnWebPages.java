package pages.commonActions.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class CommonActionsOnWebPages extends MainTestBase {


    //элементы
    private static final String PRODUCT_BUTTON_XPATH = "xpath;//a[@data-gtm-position='%s']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String SLIDER_FROM_XPATH = "xpath;//span[@class='irs-slider from']";
    private static final String SLIDER_TO_XPATH = "xpath;//span[@class='irs-slider to']";
    private static final String PRICE_RANGE_FROM_XPATH = "xpath;//input[@class='b-range__input js-range-from']";
    private static final String PRICE_RANGE_TO_XPATH = "xpath;//input[@class='b-range__input js-range-to']";
    private static final String PRODUCT_PRICES_RANGE_LIST_XPATH = "xpath;//div[@class='listing_product__price']";
    private static final String BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH = "xpath;(//div[@class='listing_product__price']//child::span)[%s]";
    private static final String BASE_INPUT_CHECK_PRODUCT_DELIVERY_METHOD_XPATH = "xpath;(//span[@class='b-prod-label b-prod-label_delivery'])[%s]";
    private static final String CHECKBOX_DELIVERY_XPATH = "xpath;//span[@class='b-trim-str'][contains(.,'Доставка')]";
    private static final String GET_SELECTED_CHECKBOX_XPATH = "xpath;//div[@class='filters_selected'][contains(.,'%s')]";
    private static final String CLOSE_CHECKBOX_DELIVERY_XPATH = "xpath;(//a[@class='b-icn--close c-facets__close-button'])[2]";
    private static final String PRODUCTS_WITHOUT_DELIVERY_METHOD_XPATH = "xpath;//span[@class='b-prod-label b-prod-label_delivery' and not(@type='b-prod-label b-prod-label_delivery')]";
    private static final String RESET_CHECKBOXES_XPATH = "xpath;//form[@class='filters_reset']//child::button";
    private static final String SHOW_ALL_XPATH = "xpath;(//a[contains(@class,'i-fw-b js-show-all-facets')])[%s]";
    private static final String BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH = "xpath;//div[@class='product__info__desc'][contains(.,'%s')]";
    private static final String OPTION_COUNT_XPATH = "xpath;//div[@class='overview']";
    private static final String PAGE_NUMBER_OPEN_XPATH = "xpath;//span[@class='active b-pagination__item']";
    private static final String PAGE_NUMBER_TITLE_OPEN_XPATH = "xpath;//h1[contains(@class,'js-category-title')]";
    private static final String NEXT_PAGINATION_BUTTON_XPATH = "xpath;//a[@class='b-pagination__item js-pager-next']";
    private static final String PREV_PAGINATION_BUTTON_XPATH = "xpath;//a[@class='b-pagination__item']//child::i";
    private static final String BASE_INPUT_CHECKBOX_OPTION_XPATH = "xpath;(//span[@class='b-custom-input'])[%s]";
    private static final String ON_RECIPE_XPATH = "xpath;//span[@class='b-trim-str'][contains(.,'Отпуск по рецепту')]";
    private static final String WITHOUT_RECIPE_XPATH = "xpath;//span[contains(.,'Отпуск без рецепта')]";


    //конструктор
    public CommonActionsOnWebPages(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getProductButton(String xpath) {
        return new PageElementActions(xpath, driver);
    }

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

    public PageElementActions getProductList() {
        return new PageElementActions(PRODUCT_PRICES_RANGE_LIST_XPATH, driver);
    }

    public PageElementActions getBaseInputCheckProductPrice(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputCheckSelectedCheckbox(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getCheckboxDelivery() {
        return new PageElementActions(CHECKBOX_DELIVERY_XPATH, driver);
    }

    public PageElementActions getDeliveryMethod(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getCloseCheckboxDelivery() {
        return new PageElementActions(CLOSE_CHECKBOX_DELIVERY_XPATH, driver);
    }

    public PageElementActions getProductsWithoutDeliveryMethod() {
        return new PageElementActions(PRODUCTS_WITHOUT_DELIVERY_METHOD_XPATH, driver);
    }

    public PageElementActions getResetCheckboxes() {
        return new PageElementActions(RESET_CHECKBOXES_XPATH, driver);
    }

    public PageElementActions getCheckboxOption(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getShowAll(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getMainInformation(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getOptionCount() {
        return new PageElementActions(OPTION_COUNT_XPATH, driver);
    }

    public PageElementActions getPageNumberOpen() {
        return new PageElementActions(PAGE_NUMBER_OPEN_XPATH, driver);
    }

    public PageElementActions getPageNumberOpenTitle() {
        return new PageElementActions(PAGE_NUMBER_TITLE_OPEN_XPATH, driver);
    }

    public PageElementActions getNexPaginationButton() {
        return new PageElementActions(NEXT_PAGINATION_BUTTON_XPATH, driver);
    }

    public PageElementActions getPrevPaginationButton() {
        return new PageElementActions(PREV_PAGINATION_BUTTON_XPATH, driver);
    }

    public PageElementActions getOnRecipeCheckbox() {
        return new PageElementActions(ON_RECIPE_XPATH, driver);
    }

    public PageElementActions getWithoutRecipeCheckbox() {
        return new PageElementActions(WITHOUT_RECIPE_XPATH, driver);
    }


    //Методы
    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь изменяет нижный и верхний диапозон цены")
    public void changePricesRangeWithSlider() {
        getSliderFrom().drugAndDropToOffSet(50, 0);
        getSliderTo().drugAndDropToOffSet(-50, 0);
        logger.info("Пользователь изменяет нижный и верхний диапозон цены");
    }

    @Step("Пользователь получает значение начального диапазона цены")
    public int getFromPriceRange() {
        logger.info("Пользователь получает значение начального диапазона цены");
        String priseRangeFrom = getPriceRangeFrom().getAttribute("placeholder");
        return Integer.parseInt(priseRangeFrom);
    }

    @Step("Пользователь получает значение конечного диапазона цены")
    public int getToPriceRange() {
        logger.info("Пользователь получает значение конечного диапазона цены");
        String priseRangeTo = getPriceRangeTo().getAttribute("placeholder");
        return Integer.parseInt(priseRangeTo);
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
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            int price = getBaseInputCheckProductPrice(String.format(BASE_INPUT_CHECK_PRODUCT_PRICE_XPATH, i)).formatElementToValue();
            Assert.assertTrue(price >= fromPrice);
            Assert.assertTrue(price <= toPrice);
        }
        logger.info("Пользователь проверяет что после установки диапазона цен, цены на товары показываются в верном диапазоне");
    }

    @Step("Пользователь выбирает чекбокс с доставкой")
    public void clickCheckboxDelivery() {
        getCheckboxDelivery().click();
        logger.info("Пользователь выбирает чекбокс с доставкой");
    }

    @Step("Пользователь проверяет установку чекбокса - {checkboxName}")
    public void checkSelectedCheckbox(String checkboxName) {
        getBaseInputCheckSelectedCheckbox(String.format(GET_SELECTED_CHECKBOX_XPATH, checkboxName)).isElementDisplayed();
        logger.info("Пользователь проверяет установку чекбокса");
    }

    @Step("Пользователь проверяет что после установки чекбокса Доставка, все товары показываются только с доставкой")
    public void checkSelectedProductsWithDeliveryMethod() {
        int par = getProductList().getSize();
        for (int i = 1; i <= par; i++) {
            getDeliveryMethod(String.format(BASE_INPUT_CHECK_PRODUCT_DELIVERY_METHOD_XPATH, i)).isElementDisplayed();
        }
        logger.info("Пользователь проверяет что после установки чекбокса Доставка, все товары показываются только с доставкой");
    }

    @Step("Пользователь снимает чекбокс Доставка")
    public void clickCloseCheckboxDelivery() {
        getCloseCheckboxDelivery().click();
        logger.info("Пользователь снимает чекбокс Доставка");
    }

    @Step("Пользователь проверяет что после снятия чекбокса Доставка, товары показываются со всеми методами получения")
    public void checkSelectedProductsWithAllMethods() {
        int par = getProductList().getSize();
        int countDelivery = getProductsWithoutDeliveryMethod().getSize();
        Assert.assertTrue(par > countDelivery);
        logger.info("Пользователь проверяет что после снятия чекбокса Доставка, товары показываются со всеми методами получения");
    }

    @Step("Пользователь нажимает: 'Сбросить всё'")
    public void clickResetCheckboxes() {
        getResetCheckboxes().click();
        logger.info("Пользователь нажимает: 'Сбросить всё'");
    }

    @Step("Пользователь нажимает: Показать все")
    public void clickShowAll(int index) {
        getShowAll(String.format(SHOW_ALL_XPATH, index)).click();
        logger.info("Пользователь нажимает: Показать все");
    }

    @Step("Пользователь выбирает одну из опций и проверяет содержание выбранной опции: в блоке Основная информация")
    public void clickAndCheckCheckboxes(int index) {
        String stringCount = getOptionCount().getAttribute("childElementCount");
        int count = Integer.parseInt(stringCount);
        int randomNumber = (new Random()).ints(1, count).iterator().nextInt();
        logger.info("Пользователь рандомом выбирает опцию из чекбоксов чекбокс: форма выпуска, бредн, теги, для кого, производители");
        getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).moveToElementJs();
        String optionName = getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).getText();
        getCheckboxOption(String.format(BASE_INPUT_CHECKBOX_OPTION_XPATH, randomNumber + index)).click();
        logger.info("Пользователь нажимает на выбранную опцию");

        int par = getProductList().getSize();
        int randomNumberProduct;
        if (par == 1) {//данный if выполняется для того чтобы не получать Exception: bound must be greater than origin
            randomNumberProduct = 1;
        } else {
            randomNumberProduct = (new Random()).ints(1, par).iterator().nextInt();
        }
        getProductButton(String.format(PRODUCT_BUTTON_XPATH, randomNumberProduct)).click();
        logger.info("Пользователь проверяет содержание выбранной опции: в блоке Основная информация");
        getMainInformation(String.format(BASE_INPUT_CHECK_MAIN_INFORMATION_XPATH, optionName)).isElementDisplayed();
        pageActions.returnBackPage();
    }


    @Step("Пользователь выбирает опцию: по рецепту - и проверяет содержание выбранной опции в блоке: Основная информация")
    public void checkCheckboxWithRecipe() {
        getOnRecipeCheckbox().click();
        logger.info("Пользователь нажимает на выбранную опцию");

        int par = getProductList().getSize();
        int randomNumberProduct;
        if (par == 1) {//данный if выполняется для того чтобы не получать Exception: bound must be greater than origin
            randomNumberProduct = 1;
        } else {
            randomNumberProduct = (new Random()).ints(1, par).iterator().nextInt();
        }
        getProductButton(String.format(PRODUCT_BUTTON_XPATH, randomNumberProduct)).click();
        logger.info("Пользователь проверяет содержание опции - По рецепту в блоке: Основная информация");
    }

    @Step("Пользователь выбирает опцию: без рецепта - и проверяет содержание выбранной опции в блоке: Основная информация")
    public void checkCheckboxWithoutRecipe() {
        getWithoutRecipeCheckbox().click();
        logger.info("Пользователь нажимает на выбранную опцию");

        int par = getProductList().getSize();
        int randomNumberProduct;
        if (par == 1) {//данный if выполняется для того чтобы не получать Exception: bound must be greater than origin
            randomNumberProduct = 1;
        } else {
            randomNumberProduct = (new Random()).ints(1, par).iterator().nextInt();
        }
        getProductButton(String.format(PRODUCT_BUTTON_XPATH, randomNumberProduct)).click();
        logger.info("Пользователь выбирает опцию: без рецепта - и проверяет содержание выбранной опции в блоке: Основная информация");
    }

    @Step("Пользователь проверяет номер текущей станицы")
    public void checkOpenPageNumber(int pageExpectedNumber) {
        String stringPageOpenNumber = getPageNumberOpen().getAttribute("innerHTML");
        int pageOpenNumber = Integer.parseInt(stringPageOpenNumber);
        Assert.assertEquals(pageOpenNumber, pageExpectedNumber);
        logger.info("Пользователь проверяет номер текущей станицы");
    }

    @Step("Пользователь листает вперёд страницы и проверяет релевантный переход")
    public void clickNextPage() {
        for (int i = 1; i <= 4; i++) {
            getNexPaginationButton().click();
            String stringPageOpenNumber = getPageNumberOpen().getAttribute("innerHTML");
            int pageOpenNumber = Integer.parseInt(stringPageOpenNumber);
            int pageOpenTitle = getPageNumberOpenTitle().formatElementToValue();
            Assert.assertEquals(pageOpenTitle, pageOpenNumber);
        }
        logger.info("Пользователь листает вперёд страницы и проверяет релевантный переход");
    }

    @Step("Пользователь листает назад страницы и проверяет релевантный переход")
    public void clickPrevPage() {
        for (int i = 4; i >= 2; i--) {
            getPrevPaginationButton().click();
            String stringPageOpenNumber = getPageNumberOpen().getAttribute("innerHTML");
            int pageOpenNumber = Integer.parseInt(stringPageOpenNumber);
            int pageOpenTitle = getPageNumberOpenTitle().formatElementToValue();
            Assert.assertEquals(pageOpenTitle, pageOpenNumber);
        }
        logger.info("Пользователь листает назад страницы и проверяет релевантный переход");

    }


}
