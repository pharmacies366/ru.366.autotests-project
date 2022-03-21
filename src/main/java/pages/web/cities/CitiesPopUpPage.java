package pages.web.cities;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CitiesPopUpPage extends MainTestBase {

    //элементы
    private static final String MSK_BUTTON_XPATH = "xpath;(//a[contains(.,'Москва и МО')])[3]";
    private static final String SPB_UP_BUTTON_XPATH = "xpath;(//a[contains(.,'Санкт-Петербург и ЛО')])[3]";



    //конструктор
    public CitiesPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getSpbButton() {
        return new PageElementActions(SPB_UP_BUTTON_XPATH, driver);
    }

    public PageElementActions getMskButton() {
        return new PageElementActions(MSK_BUTTON_XPATH, driver);
    }



    //Методы
    @Step("Пользователь нажимает на город Санкт-Петербург")
    public void selectSpbCity() {
        getSpbButton().click();
        logger.info("Пользователь нажимает на город Санкт-Петербург");
    }
    @Step("Пользователь нажимает на город Москва")
    public void selectMskCity() {
        getMskButton().click();
        logger.info("Пользователь нажимает на город Москва");
    }
}
