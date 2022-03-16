package pages.mobile.categorys.medicationsCategorys;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileMedicationsCategorysPopUpPage extends MainTestBase {



    //элементы
    private static final String ALLERGY_BUTTON_XPATH = "xpath;(//a[@href='/c/allergija/'])[2]";


    //конструктор
    public MobileMedicationsCategorysPopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getAllergyButton() {
        return new PageElementActions(ALLERGY_BUTTON_XPATH, driver);
    }


    //Методы
    @Step("Пользователь нажимает на подкатегорию Аллергия")
    public void clickAllergyButton() {
        getAllergyButton().click();
        logger.info("Пользователь нажимает на подкатегорию Аллергия");
    }
}


