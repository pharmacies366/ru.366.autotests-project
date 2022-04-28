package mainPage;

import blocks.web.WebHeaderBlock;
import com.codeborne.selenide.Selenide;
import core.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.web.main.MainPage;

@Feature(value = "Web")
@Story("Проверка шапки сайта 36.6")
@DisplayName("Проверка шапки сайта")
public class HeaderBlockWebTest extends BaseTest {


    private MainPage mainPage;
    private WebHeaderBlock webHeaderBlock;

    @BeforeEach
    void setUpd() {
        webHeaderBlock = Selenide.open("https://366.ru/", WebHeaderBlock.class);
        mainPage = Selenide.page(MainPage.class);
    }

/*    @DisplayName("Проверка отображения логотипа")
    @Test
    public void checkVisibilityLogo(){
        webHeaderBlock.getSiteLogo().elementIsVisibility();
    }

    @DisplayName("Проверка кликабельности логотипа")
    @Test
    public void checkClickableLogo(){
        webHeaderBlock.getSiteLogo().elementIsClickable();

    }*/

    @DisplayName("Проверка кликабельности кнопки 'Каталог'")
    @Test
    public void checkClickableCatalogButton() {
        webHeaderBlock.clickCatalogButton();
    }

/*    @DisplayName("Проверка работы поиска")
    @Test
    public void testingTheSearch(){
        webHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));

    }*/

    @DisplayName("Проверки работы корзины")
    @Test
    public void testingTheCart(){
        mainPage.clickClosePopUp();
        mainPage.clickAddToCardButton();
        //int quantity = webHeaderBlock.checkCartQuantity();
       // Assert.assertEquals(1, quantity);
        webHeaderBlock.clickToCartButton();
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке для выбора городов")
    @Test
    public void checkButtonSelectCities() {
        webHeaderBlock.clickCitiesButton();
       // Assert.assertEquals("Выбор города", headerBlock.checkCitiesPopUp());
    }

    @DisplayName("Проверка кликабельности и корректности перехода по кнопке 'аптеки'")
    @Test
    public void checkButtonPharmacies() {
        webHeaderBlock.clickPharmaciesButton();
       // pageActions.contentIsDisplayed("Работает сейчас");
    }

    @DisplayName("Проверка кликабельности кнопки 'Войти'")
    @Test
    public void checkClickableSignIn() {
        webHeaderBlock.clickToSignInButton();
    }

    @DisplayName("Проверка кликабельности кнопки 'Зарегистрироваться'")
    @Test
    public void checkClickableSignUp(){
        webHeaderBlock.clickToSignUpButton();
    }

/*    @DisplayName("Проверка кликабельности номера телефона")
    @Test
    public void checkClickablePhoneNumber(){
        webHeaderBlock.getPhoneNumber().elementIsClickable();
    }*/



}
