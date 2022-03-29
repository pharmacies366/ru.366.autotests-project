package pages.web.cart;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CartPage extends MainTestBase {

    //элементы
    private static final String CARD_COUNT_XPATH = "xpath;//div[contains(@class,'count js-mini-cart-count')]";
    private static final String CLEAR_ALL_FROM_CARD_XPATH = "xpath;//a[contains(.,'Очистить все')]";
    private static final String CONFIRM_CLEAN_ALL_XPATH = "xpath;//input[@value='Да, подтверждаю']";
    private static final String TOTAL_PRICE_XPATH = "xpath;//div[@class='cart-summary_value js-revenue']";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    private static final String MAKE_ORDER_XPATH = "xpath;//a[@href='/cart/checkout']";
    private static final String PRODUCT_CARD_XPATH = "xpath;//a[@data-gtm-source='search list']";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_plus')])[1]";
    private static final String QUANTITY_PRODUCT_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";
    private static final String DELETE_PRODUCT_XPATH = "xpath;//button[@class='js-remove-entry-button b-btn--clean']";
    private static final String FAVORITES_BUTTON_XPATH = "xpath;//button[@data-gtm-source='cart']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";
    private static final String TEXT_DO_NOT_ADD_TO_CART_XPATH = "xpath;//div[@class='c-gallery__header js-products__tabs__item active']//child::h2";
    private static final String DO_NOT_ADD_TO_CART_PRODUCTS_LIST_XPATH = "xpath;//div[@class='owl-wrapper c-gallery__content-wrapper active']";

    //конструктор
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getTotalPrice() {
        return new PageElementActions(TOTAL_PRICE_XPATH, driver);
    }

    public PageElementActions getClearAllFromCart() {
        return new PageElementActions(CLEAR_ALL_FROM_CARD_XPATH, driver);
    }

    public PageElementActions getConfirmCleanAll() {
        return new PageElementActions(CONFIRM_CLEAN_ALL_XPATH, driver);
    }

    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_XPATH, driver);
    }

    public PageElementActions getClickAddCartButton() {
        return new PageElementActions(ADD_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getMakeOrder() {
        return new PageElementActions(MAKE_ORDER_XPATH, driver);
    }

    public PageElementActions getProductCard() {
        return new PageElementActions(PRODUCT_CARD_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getProductQuantity() {
        return new PageElementActions(QUANTITY_PRODUCT_XPATH, driver);
    }

    public PageElementActions getDeleteMaterials() {
        return new PageElementActions(DELETE_PRODUCT_XPATH, driver);
    }

    public PageElementActions getFavoritesButton() {
        return new PageElementActions(FAVORITES_BUTTON_XPATH, driver);
    }

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }

    public PageElementActions getDoNotAddToCart() {
        return new PageElementActions(TEXT_DO_NOT_ADD_TO_CART_XPATH, driver);
    }

    public PageElementActions getDoNotAddToCartProductsList() {
        return new PageElementActions(DO_NOT_ADD_TO_CART_PRODUCTS_LIST_XPATH, driver);
    }



    //Методы
    @Step("Проверка состояния корзины: Если корзина не пустая, удаляем все содержимое")
    public void checkAndClearCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        if (quantity != 0) {
            logger.info("В КОРЗИНЕ ЕСТЬ ТОВАРЫ");
            driver.get(propertiesManager.getProperty("baseurl") + "/cart");
            deleteAllMaterials();
            logger.info("ТОВАРЫ В КОРЗИНЕ УДАЛЕНЫ");
            saveAllureScreenshot();
        }
    }

    @Step("Проверка количества товаров в корзине")
    public int checkCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        return Integer.parseInt(stringCartQuantity);
    }

    @Step("Удаение всех товаров из корзины")
    public void deleteAllMaterials() {
        getClearAllFromCart().click();
        getConfirmCleanAll().click();
        logger.info("Удаение всех товаров из корзины");
    }


    @Step("Сохранение итоговой суммы в корзине")
    public int getPriceTotal() {
        int price = getTotalPrice().formatElementToValue();
        logger.info("Запоминаем цену товара");
        return price;
    }

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void clickAddCartButton() {
        getClickAddCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Пользователь нажимае на кнопку 'Оформить заказ'")
    public void clickToMakeOrder() {
        getMakeOrder().click();
        logger.info("Пользователь нажимае на кнопку 'Оформить заказ'");
    }

    @Step("Пользователь нажимает на товар")
    public void clickProductCard() {
        getProductCard().click();
        logger.info("Пользователь нажимает на товар");
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public void clickIncreaseQuantity() {
        getIncreaseQuantity().click();
        logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
    }

    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getProductQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
    }

    @Step("Пользователь нажимает на иконку удаления товара")
    public void clickDeleteMaterials() {
        getDeleteMaterials().clickIndex(1);
        logger.info("Пользователь нажимает на иконку удаления товар");
    }

    @Step("Пользователь нажимает на звёздочку и добавляет товар в избранное")
    public void clickFavoritesButton() {
        getFavoritesButton().click();
        logger.info("Пользователь нажимает на звёздочку и добавляет товар в избранное");
    }

    @Step("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном")
    public void checkActiveFavoritesButton() {
        getFavoritesButton().checkAttribute("class", "btn btn_favorites js-favorites-add__button active");
        logger.info("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном");
    }

    @Step("Пользователь проверяет, что кнопка избраное присутствует на странице и не активна")
    public void checkNotActiveFavoritesButton() {
        getFavoritesButton().checkAttribute("class", "btn btn_favorites js-favorites-add__button");
        logger.info("Пользователь проверяет, что кнопка избраное присутствует на странице и не активна");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину")
    public String checkTextDoNotAddToCart() {
        logger.info("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину");
        return getDoNotAddToCart().getText();
    }

    @Step("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину")
    public int checkDoNotAddToCartProductsList() {
        logger.info("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину");
        return getDoNotAddToCartProductsList().getSize();
    }
}
