package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class MobileTopPanelPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileTopPanelPage.class);

    //элементы
    private static final String BURGER_BUTTON_XPATH = "xpath;//div[contains(@class,'toggle js-toggle-sm-navigation')]";
    private static final String LOGIN_ICON_XPATH = "xpath;(//a[contains(.,'Войти')])[3]";



    //конструктор
    public MobileTopPanelPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getBurgerButton() {
        return new PageElementActions(BURGER_BUTTON_XPATH, driver);
    }

    public PageElementActions getLoginIcon() {
        return new PageElementActions(LOGIN_ICON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь нажимает на иконку выпадающего списка")
    public void clickBurgerButton(){
        getBurgerButton().click();
        logger.info("Пользователь нажимает на иконку выпадающего списка");
        saveAllureScreenshot();
    }

    @Step("Пользователь нажимает на иконку авторизации")
    public void clickToLoginIcon(){
        getLoginIcon().click();
        logger.info("Пользователь нажимает на иконку авторизации");
        saveAllureScreenshot();
    }


}
