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



    //Методы
    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToLoginIcon(){
        getLoginIcon().click();
        logger.info("Пользователь нажимает на иконку авторизации");
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
