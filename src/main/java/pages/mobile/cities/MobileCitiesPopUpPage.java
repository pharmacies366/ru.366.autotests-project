package pages.mobile.cities;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileCitiesPopUpPage extends MainTestBase {

    //элементы
    private static final String SELECT_REGION_BUTTON_XPATH = "xpath;(//span[contains(@class,'ui-selectmenu-text')])[2]";
    private static final String MSK_BUTTON_XPATH = "xpath;(//a[@data-name='Москва'])[4]";
    private static final String SPB_REGION_BUTTON_XPATH = "xpath;(//li[@class='ui-menu-item'])[2]";
    private static final String MSK_REGION_BUTTON_XPATH = "xpath;(//li[@class='ui-menu-item'])[1]";
    private static final String SPB_BUTTON_XPATH = "xpath;(//a[@href='/_s/city?urlcode=spb'])[4]";



    //конструктор
    public MobileCitiesPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getSelectRegionButton() {
        return new PageElementActions(SELECT_REGION_BUTTON_XPATH, driver);
    }

    public PageElementActions getSpbRegionButton() {
        return new PageElementActions(SPB_REGION_BUTTON_XPATH, driver);
    }

    public PageElementActions getMskRegionButton() {
        return new PageElementActions(MSK_REGION_BUTTON_XPATH, driver);
    }

    public PageElementActions getSpbButton() {
        return new PageElementActions(SPB_BUTTON_XPATH, driver);
    }

    public PageElementActions getMskButton() {
        return new PageElementActions(MSK_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Пользователь нажимает на кнопку для выбора города")
    public void clickSelectRegionButton() {
        getSelectRegionButton().click();
        logger.info("Пользователь нажимает на кнопку для выбора города");
    }

    @Step("Пользователь нажимает на регион Санкт-Петербург")
    public void selectRegionSpb() {
        getSpbRegionButton().click();
        logger.info("Пользователь нажимает на регион Санкт-Петербург");
    }

    @Step("Пользователь нажимает на город Санкт-Петербург")
    public void selectSpbCity() {
        getSpbButton().click();
        logger.info("Пользователь нажимает на город Санкт-Петербург");
    }

    @Step("Пользователь нажимает на регион Москва")
    public void selectRegionMsk() {
        getMskRegionButton().click();
        logger.info("Пользователь нажимает на регион Москва");
    }

    @Step("Пользователь нажимает на город Москва")
    public void selectMskCity() {
        getMskButton().click();
        logger.info("Пользователь нажимает на город Москва");
    }
}
