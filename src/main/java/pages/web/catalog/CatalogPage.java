package pages.web.catalog;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends MainTestBase {


    //элементы
    private static final String MEDICATIONS_BUTTON_XPATH = "xpath;(//a[contains(.,'Лекарства')])[1]";


    //конструктор
    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getMedicationsButton() {
        return new PageElementActions(MEDICATIONS_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь нажимает на категорию лекарства")
    public void clickMedicationsButtons() {
        getMedicationsButton().click();
        logger.info("Пользователь нажимает на категорию лекарства");
    }
}

