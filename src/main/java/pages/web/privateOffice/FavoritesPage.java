package pages.web.privateOffice;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;


public class FavoritesPage {


    //элементы
    private final Button ADD_TO_CART_BUTTON = new Button($x( "(//span[contains(.,'В корзину')])[1]"));
    //private final Button REMOVE_PRODUCT_BUTTON = new Button($x("//div[@class='b-btn-remove js-favorites__remove-button']"));
    private final Button REMOVE_PRODUCT_BUTTON = new Button($x( "//div[@class='b-btn-remove js-favorites__remove-button']"));
    private final Button BASE_INPUT_DELETE_PRODUCT = new Button($x( "(//div[@class='b-btn-remove js-favorites__remove-button'])['%s']"));
    private final Button GO_TO_MAIN_PAGE_BUTTON = new Button($x( "//a[contains(@class,'b-btn')]"));
    private final Button COUNT = new Button($x( "//h3[contains(@class,'b-text-subtitle i-mg0')]"));
    private final Button LIST = new Button($x( "//div[@class='c-prod-item c-prod-item--grid c-prod-item--grid-favorites']"));
    private final Button INCREASE_QUANTITY = new Button($x( "(//div[contains(@class,'btn btn_count_plus')])[1]"));
    private final Button DECREASE_QUANTITY = new Button($x( "(//div[contains(@class,'btn btn_count_minus')])[1]"));
    private final Button QUANTITY_MATERIALS = new Button($x( "(//div[contains(@class,'product_counter__qty')])[1]"));


    //Методы

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public FavoritesPage clickAddToCardButton() {
        ADD_TO_CART_BUTTON.click();
       // logger.info("Пользователь нажимает на кнопку 'В корзину'");
        return this;
    }

/*
    @Step("Пользователь проверяет наличие товара на странице")
    public FavoritesPage checkButtonAddToCart() {
        ADD_TO_CART_BUTTON.isElementVisible();
      //  logger.info("Пользователь проверяет наличие товара на странице");
        return this;
    }
*/

/*    @Step("Сохранение количества товаров")
    public FavoritesPage getQuantityMaterials() {
        int quantity = QUANTITY_MATERIALS.formatElementToValue();
       // logger.info("Запоминаем количество товара");
        return this;
    }*/

    @Step("Пользователь нажимает '+' увеличивая количество шт. товара")
    public FavoritesPage clickIncreaseQuantity() {
        INCREASE_QUANTITY.click();
       // logger.info("Пользователь нажимает '+' увеличивая количество шт. товара");
        return this;
    }

    @Step("Пользователь нажимает '-' уменьшая количество шт. товара")
    public FavoritesPage clickDecreaseQuantity() {
        DECREASE_QUANTITY.click();
      //  logger.info("Пользователь нажимает '-' уменьшая количество шт. товара");
        return this;
    }

    @Step("Пользователь нажимает кнопку Х и удалет товар")
    public FavoritesPage deleteProductFromFavorites() {
        REMOVE_PRODUCT_BUTTON.click();
      //  logger.info("Пользователь нажимает кнопку Х и удалет товар");
        return this;
    }

/*
    @Step("Пользователь проверяет, что список товаров в избранном пуст")
    public FavoritesPage checkFavoritesPageEmpty() {
        GO_TO_MAIN_PAGE_BUTTON.isElementVisible();
       // logger.info("Пользователь проверяет, что список товаров в избранном пуст");
        return this;
    }
*/


    @Step("Пользователь нажимает на кнопку 'На главную страницу'")
    public FavoritesPage clickMainPageButton() {
        GO_TO_MAIN_PAGE_BUTTON.click();
       // logger.info("Пользователь нажимает на кнопку 'На главную страницу'");
        return this;
    }


/*
    @Step("Пользователь удаляет все товары со страницы избранное")
    public FavoritesPage deleteProductsOnFavoritesPage() {
        int par = LIST.getSize();
            for (int i = 0; i < par; i++) {
                BASE_INPUT_DELETE_PRODUCT(String.format(BASE_INPUT_DELETE_PRODUCT, 1)).click();
            }
      //  logger.info("Пользователь удаляет все товары со страницы избранное");
        return this;
        }
*/


 /*   @Step("Пользователь проверяет, есть ли на странице избранное товары")
    public FavoritesPage checkProductsOnFavoritesPage() {
       // logger.info("Пользователь проверяет, есть ли на странице избранное товары");
        while (ADD_TO_CART_BUTTON.isElementVisible()) {
        //    logger.info("Товары есть на странице избранное");
            deleteProductsOnFavoritesPage();
        }
      //  logger.info("Товаров нет");
        return this;
    }*/
}




