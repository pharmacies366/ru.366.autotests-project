package pages.mobile.cart;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileCartPage extends MainTestBase {

    //элементы
    private static final String CARD_COUNT_XPATH = "xpath;//div[contains(@class,'count js-mini-cart-count')]";
    private static final String CLEAR_ALL_FROM_CARD_XPATH = "xpath;//a[contains(.,'Очистить все')]";
    private static final String CONFIRM_CLEAN_ALL_XPATH = "xpath;//input[@value='Да, подтверждаю']";
    private static final String TOTAL_PRICE_XPATH = "xpath;//div[@class='cart-summary_value js-revenue']";
    private static final String SALE_PRICE_XPATH = "xpath;(//div[@class='cart-summary_info__value js-revenue'])[2]";
    private static final String ADD_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'Купить')])[1]";
    private static final String CARD_BUTTON_XPATH = "xpath;//div[@id='js-mini-cart-link']";
    private static final String MAKE_ORDER_XPATH = "xpath;//a[@href='/cart/checkout']";
    private static final String PRODUCT_CARD_XPATH = "xpath;//a[@data-gtm-source='search list']";
    private static final String QUANTITY_PRODUCT_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;//div[@class='btn btn_count_plus product_counter__btn product_counter__btn__plus js-qty-selector-plus-gz js-qty-selector-cart']";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;//div[@class='btn btn_count_minus product_counter__btn product_counter__btn__minus js-qty-selector-minus-gz js-qty-selector-cart']";
    private static final String DELETE_PRODUCT_XPATH = "xpath;(//form[@action='/cart/update']//child::button)[2]";
    private static final String FAVORITES_BUTTON_XPATH = "xpath;//button[@data-gtm-source='cart']";
    private static final String BANNER_XPATH = "xpath;//img[@class='b-bnr--responsive__img ']";
    private static final String TEXT_DO_NOT_ADD_TO_CART_XPATH = "xpath;//div[@class='c-gallery__header js-products__tabs__item active']//child::h2";
    private static final String DO_NOT_ADD_TO_CART_PRODUCTS_LIST_XPATH = "xpath;//div[@class='owl-wrapper c-gallery__content-wrapper active']";



    //конструктор
    public MobileCartPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getCartCount() {
        return new PageElementActions(CARD_COUNT_XPATH, driver);
    }

    public PageElementActions getClearAllFromCart() {
        return new PageElementActions(CLEAR_ALL_FROM_CARD_XPATH, driver);
    }

    public PageElementActions getConfirmCleanAll() {
        return new PageElementActions(CONFIRM_CLEAN_ALL_XPATH, driver);
    }

    public PageElementActions getTotalPrice() {
        return new PageElementActions(TOTAL_PRICE_XPATH, driver);
    }
    public PageElementActions getSalePrice() {
        return new PageElementActions(SALE_PRICE_XPATH, driver);
    }

    public PageElementActions getClickAddCartButton() {
        return new PageElementActions(ADD_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getCartButton() {
        return new PageElementActions(CARD_BUTTON_XPATH, driver);
    }

    public PageElementActions getMakeOrder() {
        return new PageElementActions(MAKE_ORDER_XPATH, driver);
    }

    public PageElementActions getProductCard() {
        return new PageElementActions(PRODUCT_CARD_XPATH, driver);
    }

    public PageElementActions getProductQuantity() {
        return new PageElementActions(QUANTITY_PRODUCT_XPATH, driver);
    }

    public PageElementActions getIncreaseQuantity() {
        return new PageElementActions(INCREASE_QUANTITY_XPATH, driver);
    }

    public PageElementActions getDecreaseQuantity() {
        return new PageElementActions(DECREASE_QUANTITY_XPATH, driver);
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
            getClearAllFromCart().click();
            getConfirmCleanAll().click();
            logger.info("ТОВАРЫ В КОРЗИНЕ УДАЛЕНЫ");
        }
    }


    @Step("Сохранение итоговой суммы в корзине")
    public int getPriceTotal() {
        int price = getTotalPrice().formatElementToValue();
        if (!getSalePrice().isElementVisible()) {
            logger.info("Запоминаем цену товара");
            return price;
        }
        else  {
            logger.info("Запоминаем цену товара");
            int sale = getSalePrice().formatElementToValue();
            return price - sale;
        }

    }

    @Step("Пользователь добавляет товар в корзину")
    public void сlickAddCartButton() {
        getClickAddCartButton().clickJs();
        logger.info("Пользователь добавляет товар в корзину");
    }

    @Step("Пользователь нажимает на иконку корзины")
    public void clickToCartButton() {
        getCartButton().clickJs();
        logger.info("Пользователь нажимает на иконку корзины");
    }

    @Step("Пользователь нажимает на кнопку 'Оформить заказ'")
    public void clickToMakeOrder() {
        getMakeOrder().clickJs();
        logger.info("Пользователь нажимает на кнопку 'Оформить заказ'");
    }

    @Step("Пользователь нажимает на товар")
    public void clickProductCard() {
        getProductCard().click();
        logger.info("Пользователь нажимает на товар");
    }
    @Step("Сохранение количества товаров")
    public int getQuantityMaterials() {
        int quantity = getProductQuantity().formatElementToValue();
        logger.info("Запоминаем количество товара");
        return quantity;
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

    @Step("Пользователь нажимает на иконку удаления товара")
    public void clickDeleteMaterials(){
        getMakeOrder().moveToElement();
        getDeleteMaterials().click();
        logger.info("Пользователь нажимает на иконку удаления товар");
    }

    @Step("Проверка количества товаров в корзине")
    public int checkCartQuantity() {
        String stringCartQuantity = getCartCount().getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        return quantity;
    }

    @Step("Удаение всех товаров из корзины")
    public void deleteAllMaterials() {
        getClearAllFromCart().click();
        getConfirmCleanAll().click();
        logger.info("Удаение всех товаров из корзины");
    }

    @Step("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном")
    public void checkActivFavoritesButton() {
        getFavoritesButton().checkAttribute("class", "btn btn_favorites js-favorites-add__button active");
        logger.info("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

    @Step("Пользователь нажимает на звёздочку и добавляет товар в избранное")
    public void clickFavoritesButton() {
        getFavoritesButton().click();
        logger.info("Пользователь нажимает на звёздочку и добавляет товар в избранное");
    }

    @Step("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину")
    public String checkTextDoNotAddToCart() {
        logger.info("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину");
        String text = getDoNotAddToCart().getText();
        return text;
    }

    @Step("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину")
    public int checkDoNotAddToCartProductsList() {
        logger.info("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину");
        int count = getDoNotAddToCartProductsList().getSize();
        return count;
    }


}
