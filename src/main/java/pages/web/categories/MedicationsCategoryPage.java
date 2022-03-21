package pages.web.categories;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MedicationsCategoryPage extends MainTestBase {

    //элементы
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";


    //конструктор
    public MedicationsCategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }


    //Методы
    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1000);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }
}
