package pages.web.osp;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class OspPage extends MainTestBase {


    //элементы
    private static final String PRODUCT_NAME_XPATH = "xpath;//a[@href='/g/nurofen']";
    private static final String BANNER_XPATH = "xpath;//img[@class='b-bnr--responsive__img ']";


    //конструктор
    public OspPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getProductName() {
        return new PageElementActions(PRODUCT_NAME_XPATH, driver);
    }

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }


    //Методы

    @Step("Пользователь нажимает на товар 'Нурофен'")
    public void clickProductName() {
        getProductName().click();
        logger.info("Пользователь нажимает на товар 'Нурофен'");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }

}