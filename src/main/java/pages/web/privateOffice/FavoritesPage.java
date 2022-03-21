package pages.web.privateOffice;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class FavoritesPage extends MainTestBase {


    //элементы
    private static final String ADD_TO_CART_BUTTON_XPATH = "xpath;(//span[contains(.,'В корзину')])[1]";
    //private static final String REMOVE_PRODUCT_BUTTON_XPATH = "xpath;//div[@class='b-btn-remove js-favorites__remove-button']";
    private static final String REMOVE_PRODUCT_BUTTON_XPATH = "xpath;//div[@class='b-btn-remove js-favorites__remove-button']";
    private static final String BASE_INPUT_DELETE_PRODUCT_XPATH = "xpath;(//div[@class='b-btn-remove js-favorites__remove-button'])['%s']";
    private static final String GO_TO_MAIN_PAGE_BUTTON_XPATH = "xpath;//a[contains(@class,'b-btn')]";
    private static final String COUNT_XPATH = "xpath;//h3[contains(@class,'b-text-subtitle i-mg0')]";
    private static final String LIST_XPATH = "xpath;//div[@class='c-prod-item c-prod-item--grid c-prod-item--grid-favorites']";
    private static final String INCREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_plus')])[1]";
    private static final String DECREASE_QUANTITY_XPATH = "xpath;(//div[contains(@class,'btn btn_count_minus')])[1]";
    private static final String QUANTITY_MATERIALS_XPATH = "xpath;(//div[contains(@class,'product_counter__qty')])[1]";



    //конструктор
    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getAddToCartButton() {
        return new PageElementActions(ADD_TO_CART_BUTTON_XPATH, driver);
    }

    public PageElementActions getRemoveProductButton() {
        return new PageElementActions(REMOVE_PRODUCT_BUTTON_XPATH, driver);
    }

    public PageElementActions getGoToMainPageButton() {
        return new PageElementActions(GO_TO_MAIN_PAGE_BUTTON_XPATH, driver);
    }

    public PageElementActions getBaseInputDeleteProduct(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getList() {
        return new PageElementActions(LIST_XPATH, driver);
    }

    public PageElementActions getCount() {
        return new PageElementActions(COUNT_XPATH, driver);
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



    //Методы

    @Step("Пользователь нажимает на кнопку 'В корзину'")
    public void clickAddToCardButton() {
        getAddToCartButton().click();
        logger.info("Пользователь нажимает на кнопку 'В корзину'");
    }

    @Step("Пользователь проверяет наличие товара на странице")
    public void checkButtonAddToCart() {
        getAddToCartButton().isElementVisible();
        logger.info("Пользователь проверяет наличие товара на странице");
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

    @Step("Пользователь нажимает кнопку Х и удалет товар")
    public void deleteProductFromFavorites() {
        getRemoveProductButton().click();
        logger.info("Пользователь нажимает кнопку Х и удалет товар");
    }

    @Step("Пользователь проверяет, что список товаров в избранном пуст")
    public void checkFavoritesPageEmpty() {
        getGoToMainPageButton().isElementVisible();
        logger.info("Пользователь проверяет, что список товаров в избранном пуст");
    }


    @Step("Пользователь нажимает на кнопку 'На главную страницу'")
    public void clickMainPageButton() {
        getGoToMainPageButton().click();
        logger.info("Пользователь нажимает на кнопку 'На главную страницу'");
    }


    @Step("Пользователь удаляет все товары со страницы избранное")
    public void deleteProductsOnFavoritesPage() {
        int par = getList().getSize();
            for (int i = 0; i < par; i++) {
                getBaseInputDeleteProduct(String.format(BASE_INPUT_DELETE_PRODUCT_XPATH, 1)).click();
            }
        logger.info("Пользователь удаляет все товары со страницы избранное");
        }


    @Step("Пользователь проверяет, есть ли на странице избранное товары")
    public void checkProductsOnFavoritesPage() {
        logger.info("Пользователь проверяет, есть ли на странице избранное товары");
        while (getAddToCartButton().isElementVisible()) {
            logger.info("Товары есть на странице избранное");
            deleteProductsOnFavoritesPage();
        }
        logger.info("Товаров нет");
    }
}




