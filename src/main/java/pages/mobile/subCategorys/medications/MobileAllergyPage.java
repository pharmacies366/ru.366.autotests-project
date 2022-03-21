package pages.mobile.subCategorys.medications;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileAllergyPage extends MainTestBase {


    //элементы
    private static final String ALLERGY_TITLE_XPATH = "xpath;//h1[@class='js-category-title']";
    private static final String BANNER_XPATH = "xpath;(//img[contains(@class,'img js-responsive-image  lazyloaded')])[1]";


    //конструктор
    public MobileAllergyPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getAllergyTitle() {
        return new PageElementActions(ALLERGY_TITLE_XPATH, driver);
    }

    public PageElementActions getBanner() {
        return new PageElementActions(BANNER_XPATH, driver);
    }



    //Методы
    @Step("Пользователь проверяет заголовок страницы -  Лекарства от аллергии")
    public void checkAllergyPage() {
        getAllergyTitle().isElementDisplayed();
        logger.info("Пользователь проверяет заголовок страницы -  Лекарства от аллергии");
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public void clickBanner() {
        pageActions.staticWait(1500);
        getBanner().click();
        logger.info("Пользователь проверяет и переходит по банеру");
    }
}

