package blocks.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMainPopUpBlock extends MainTestBase {
    //элементы
    private static final String LOGIN_ICON_XPATH = "xpath;(//a[contains(.,'Войти')])[3]";
    private static final String PERSONAL_ACCOUNT_XPATH = "xpath;(//span[@class='js-check-user-status'])[3]";
    private static final String MY_ORDERS_XPATH = "xpath;(//a[@href='/my-account/orders'])[3]";
    private static final String TITLE_IFRAME_POP_UP = "uxfb_form";
    private static final String CLOSE_POP_UP_XPATH = "xpath;//button[@class='uxf-close sc-bZQynM bYZQSZ']";
    private static final String TEST_TAGNAME = "tagName;iframe";
    private static final String LOGOUT_BUTTON_XPATH = "xpath;(//a[@href='/logout/'])[3]";
    private static final String PERSONAL_DATA_XPATH = "xpath;(//a[@href='/my-account/profile'])[3]";
    private static final String MEDICATIONS_BUTTON_XPATH = "xpath;(//a[@href='/c/lekarstva/'])[3]";
    private static final String CITIES_BUTTON_XPATH = "xpath;(//span[contains(@class,'b-login-link i-fw-b')])[3]";



    //конструктор
    public MobileMainPopUpBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getLoginIcon() {
        return new PageElementActions(LOGIN_ICON_XPATH, driver);
    }

    public PageElementActions getPersonalAccount() {
        return new PageElementActions(PERSONAL_ACCOUNT_XPATH, driver);
    }

    public PageElementActions getMyOrders() {
        return new PageElementActions(MY_ORDERS_XPATH, driver);
    }

    public PageElementActions getClosePopUp() {
        return new PageElementActions(CLOSE_POP_UP_XPATH, driver);
    }

    public PageElementActions getTest() {
        return new PageElementActions(TEST_TAGNAME, driver);
    }

    public PageElementActions getLogOutButton() {
        return new PageElementActions(LOGOUT_BUTTON_XPATH, driver);
    }

    public PageElementActions getPersonalData() {
        return new PageElementActions(PERSONAL_DATA_XPATH, driver);
    }

    public PageElementActions getMedicationsButton() {
        return new PageElementActions(MEDICATIONS_BUTTON_XPATH, driver);
    }

    public PageElementActions getCitiesButton() {
        return new PageElementActions(CITIES_BUTTON_XPATH, driver);
    }

    //Методы
    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToLoginIcon(){
        getLoginIcon().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

/*
     @Step("Пользователь нажимает на иконку личного кабинета")
    public void clickToPersonalAccount() {
         if (getTest().isElementVisible()) {
             clickClosePopUp();
             getPersonalAccount().click();
         }
         else {
             getPersonalAccount().click();
         }
         logger.info("Пользователь нажимает на иконку личного кабинета");
    }*/

    @Step("Пользователь нажимает на иконку личного кабинета")
    public void clickToPersonalAccount() {
             getPersonalAccount().click();
         logger.info("Пользователь нажимает на иконку личного кабинета");
    }


    @Step("Пользователь закрывает попап с оценкой приложения")
    public void clickClosePopUp() {
        pageActions.switchToiFrame(TITLE_IFRAME_POP_UP);
        getClosePopUp().click();
        logger.info("Пользователь закрывает попап с оценкой приложения");
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickMyOrders() {
        getMyOrders().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickLogOut() {
        getLogOutButton().click();
        logger.info("Пользователь нажимает на иконку авторизации");
    }

    @Step("Пользователь нажимает на кнопку Личные данные")
    public void clickPersonalData() {
        getPersonalData().click();
        logger.info("Пользователь нажимает на кнопку Личные данные");
    }

    @Step("Пользователь нажимает на категорию лекарства")
    public void clickMedicationsButtons() {
        getMedicationsButton().click();
        logger.info("Пользователь нажимает на категорию лекарства");
    }

    @Step("Пользователь нажимает на кнопку для выбора города")
    public void clickCitiesButton(){
        getCitiesButton().click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
    }
}
