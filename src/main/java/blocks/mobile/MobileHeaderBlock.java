package blocks.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileHeaderBlock extends MainTestBase {
    //элементы
    private static final String BURGER_BUTTON_XPATH = "xpath;//div[contains(@class,'toggle js-toggle-sm-navigation')]";
    private static final String LOGIN_ICON_XPATH = "xpath;(//a[contains(.,'Войти')])[3]";
    private static final String MEDICATIONS_BUTTON_XPATH = "xpath;(//a[contains(.,'Лекарства')])[3]";
    private static final String PERSONAL_ACCOUNT_XPATH = "xpath;(//span[@class='js-check-user-status'])[3]";
    private static final String MY_ORDERS_XPATH = "xpath;(//a[@href='/my-account/orders'])[3]";



    //конструктор
    public MobileHeaderBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBurgerButton() {
        return new PageElementActions(BURGER_BUTTON_XPATH, driver);
    }

    public PageElementActions getLoginIcon() {
        return new PageElementActions(LOGIN_ICON_XPATH, driver);
    }

    public PageElementActions getMedicationsPageButton() {
        return new PageElementActions(MEDICATIONS_BUTTON_XPATH, driver);
    }

    public PageElementActions getPersonalAccount() {
        return new PageElementActions(PERSONAL_ACCOUNT_XPATH, driver);
    }

    public PageElementActions getMyOrders() {
        return new PageElementActions(MY_ORDERS_XPATH, driver);
    }


    //Методы
    @Step("Пользователь нажимает на иконку выпадающего списка")
    public void clickBurgerButton(){
        getBurgerButton().click();
        logger.info("Пользователь нажимает на иконку выпадающего списка");
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToLoginIcon(){
        getLoginIcon().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Пользователь нажимает на категорию 'Лекарства")
    public void clickMedicationsButton() {
        getMedicationsPageButton().click();
        logger.info("Пользователь нажимает на категорию 'Лекарства'");
    }

    @Step("Пользователь нажимает на иконку личного кабинета")
    public void clickToPersonalAccount() {
        getPersonalAccount().click();
        logger.info("Пользователь нажимает на иконку личного кабинета");
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickMyOrders() {
        getMyOrders().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }
}
