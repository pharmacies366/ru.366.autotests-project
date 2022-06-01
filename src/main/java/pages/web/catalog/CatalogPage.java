package pages.web.catalog;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends MainTestBase {


    //элементы

    //категории
    private static final String BASE_INPUT_CATEGORYS_BUTTON_XPATH = "xpath;(//a[@href='%s'])[1]";
    private static final String MEDICATIONS = "/c/lekarstva/";

    //подкатегории
    private static final String ALLERGY = "/c/allergija/";


    //конструктор
    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputCategorysButton(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы
    @Step("Пользователь нажимает на категорию лекарства")
    public void clickMedicationsButtons() {
        getBaseInputCategorysButton(String.format(BASE_INPUT_CATEGORYS_BUTTON_XPATH, MEDICATIONS)).click();
        logger.info("Пользователь нажимает на категорию лекарства");
    }
}

