package pages.mobile.osp;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MobileOspPage extends MainTestBase {



    //элементы
    private static final String SHOW_ALL_BUTTON_XPATH = "xpath;//span[contains(.,'Показать все')]";
    private static final String PRODUCT_NAME_XPATH = "xpath;//a[@href='/g/nurofen']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";



    //конструктор
    public MobileOspPage(WebDriver driver) {
        this.driver = driver;
    }

    
    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getProductName() {
        return new PageElementActions(PRODUCT_NAME_XPATH, driver);
    }

    public PageElementActions getShowAllButton() {
        return new PageElementActions(SHOW_ALL_BUTTON_XPATH, driver);
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

    @Step("Пользователь нажимает на унокпу 'Показать все'")
    public void clickShowAll(){
        getShowAllButton().click();
        logger.info("Пользователь нажимает на унокпу 'Показать все'");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1500);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }
    

}
