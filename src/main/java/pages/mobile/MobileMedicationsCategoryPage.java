package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MobileMedicationsCategoryPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileMainPage.class);

    //элементы
    private static final String ALLERGY_CATEGORY_XPATH = "xpath;(//a[contains(.,'Аллергия')])[2]";



    //конструктор
    public MobileMedicationsCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getAllergyCategory() {
        return new PageElementActions(ALLERGY_CATEGORY_XPATH, driver);
    }





    //Методы

    @Step("Пользователь нажимает на подкатегорию 'Аллергия'")
    public void clickAllergyCategory() {
        getAllergyCategory().click();
        logger.info("Пользователь нажимает на подкатегорию 'Аллергия'");
        saveAllureScreenshot();
    }

}
