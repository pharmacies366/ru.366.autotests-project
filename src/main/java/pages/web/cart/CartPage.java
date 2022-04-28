package pages.web.cart;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    //элементы
    private final Button CARD_COUNT = new Button($x(  "//div[contains(@class,'count js-mini-cart-count')]"));
    private final Button CLEAR_ALL_FROM_CARD = new Button($x(  "//a[contains(.,'Очистить все')]"));
    private final Button CONFIRM_CLEAN_ALL = new Button($x(  "//input[@value='Да, подтверждаю']"));
    private final Button TOTAL_PRICE = new Button($x(  "//div[@class='cart-summary_value js-revenue']"));
    private final Button ADD_CART_BUTTON = new Button($x(  "(//span[contains(.,'В корзину')])[1]"));
    private final Button MAKE_ORDER = new Button($x(  "//a[@href='/cart/checkout']"));
    private final Button PRODUCT_CARD = new Button($x(  "(//a[@data-gtm-source='search list'])[1]"));
    private final Button INCREASE_QUANTITY = new Button($x(  "(//div[contains(@class,'btn btn_count_plus')])[1]"));
    private final Button QUANTITY_PRODUCT = new Button($x(  "(//div[contains(@class,'product_counter__qty')])[1]"));
    private final Button DELETE_PRODUCT = new Button($x(  "//button[@class='js-remove-entry-button b-btn--clean']"));
    private final Button FAVORITES_BUTTON = new Button($x(  "//button[@data-gtm-source='cart']"));
    private final Button BANNER = new Button($x(  "//img[@class='b-bnr--responsive__img ']"));
    private final Button TEXT_DO_NOT_ADD_TO_CART = new Button($x(  "//div[@class='c-gallery__header js-products__tabs__item active']//child::h2"));
    private final Button DO_NOT_ADD_TO_CART_PRODUCTS_LIST = new Button($x(  "//div[@class='owl-wrapper c-gallery__content-wrapper active']"));


    //Методы
    @Step("Проверка состояния корзины: Если корзина не пустая, удаляем все содержимое")
    public CartPage checkAndClearCartQuantity() {
        String stringCartQuantity = CARD_COUNT.getText();
        int quantity = Integer.parseInt(stringCartQuantity);
        if (quantity != 0) {
          //  logger.info("В КОРЗИНЕ ЕСТЬ ТОВАРЫ");
            Selenide.open("https://366.ru/cart/");
            deleteAllMaterials();
         //   logger.info("ТОВАРЫ В КОРЗИНЕ УДАЛЕНЫ");
           // saveAllureScreenshot();
        }
        return this;
    }

    @Step("Проверка количества товаров в корзине")
    public CartPage checkCartQuantity() {
        String stringCartQuantity = CARD_COUNT.getText();
        Integer.parseInt(stringCartQuantity);
        return this;
    }

    @Step("Удаение всех товаров из корзины")
    public CartPage deleteAllMaterials() {
        CLEAR_ALL_FROM_CARD.click();
        CONFIRM_CLEAN_ALL.click();
       // logger.info("Удаение всех товаров из корзины");
        return this;
    }


/*    @Step("Сохранение итоговой суммы в корзине")
    public CartPage getPriceTotal() {
        int price = TOTAL_PRICE.formatElementToValue();
       // logger.info("Запоминаем цену товара");
        return this;;
    }*/

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public CartPage clickAddCartButton() {
        ADD_CART_BUTTON.click();
       // logger.info("Пользователь нажимает на кнопку 'В корзину'");
        return this;
    }

    @Step("Пользователь нажимае на кнопку 'Оформить заказ'")
    public CartPage clickToMakeOrder() {
        MAKE_ORDER.click();
       // logger.info("Пользователь нажимае на кнопку 'Оформить заказ'");
        return this;
    }

    @Step("Пользователь нажимает на товар")
    public CartPage clickProductCard() {
        PRODUCT_CARD.click();
        //logger.info("Пользователь нажимает на товар");
        return this;
    }

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public CartPage clickIncreaseQuantity() {
        INCREASE_QUANTITY.click();
       // logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
        return this;
    }

/*    @Step("Сохранение количества товаров")
    public CartPage getQuantityMaterials() {
        int quantity = QUANTITY_PRODUCT.formatElementToValue();
       // logger.info("Запоминаем количество товара");
        return this;;
    }*/

    @Step("Пользователь нажимает на иконку удаления товара")
    public CartPage clickDeleteMaterials() {
        DELETE_PRODUCT.click();
       // logger.info("Пользователь нажимает на иконку удаления товар");
        return this;
    }

    @Step("Пользователь нажимает на звёздочку и добавляет товар в избранное")
    public CartPage clickFavoritesButton() {
        FAVORITES_BUTTON.click();
       // logger.info("Пользователь нажимает на звёздочку и добавляет товар в избранное");
        return this;
    }

/*    @Step("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном")
    public CartPage checkActiveFavoritesButton() {
        FAVORITES_BUTTON.checkAttribute("class", "btn btn_favorites js-favorites-add__button active");
        //logger.info("Пользователь проверяет, что кнопка избраное отмечена и данный товар находиться в избранном");
        return this;
    }

    @Step("Пользователь проверяет, что кнопка избраное присутствует на странице и не активна")
    public CartPage checkNotActiveFavoritesButton() {
        FAVORITES_BUTTON.checkAttribute("class", "btn btn_favorites js-favorites-add__button");
       // logger.info("Пользователь проверяет, что кнопка избраное присутствует на странице и не активна");
        return this;
    }*/

    @Step("Пользователь проверяет и переходит по банеру")
    public CartPage clickBanner() {
        BANNER.click();
       // logger.info("Пользователь проверяет и переходит по банеру");
        return this;
    }

    @Step("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину")
    public CartPage checkTextDoNotAddToCart() {
      //  logger.info("Пользователь проверяет отображение текстового блока: Не забудьте положить в корзину");
        DO_NOT_ADD_TO_CART_PRODUCTS_LIST.getText();
        return this;
    }

    @Step("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину")
    public CartPage checkDoNotAddToCartProductsList() {
        //logger.info("Пользователь получает количество товаров в блоке: Не забудьте положить в корзину");
        DO_NOT_ADD_TO_CART_PRODUCTS_LIST.getSize();
        return this;
    }
}
