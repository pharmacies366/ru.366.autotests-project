package blocks.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class WebBasementBlock extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_XPATH = "xpath;//div[@class='b-section--as-content']//child::a[@href='%s']";


    //конструктор
    public WebBasementBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getBaseInputBasementLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getBaseInputBasementLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы

    @Step("Кликает по локатору {LOCATOR}")
    public void selectBasementButtons(String LOCATOR) {
        getBaseInputBasementLocators(String.format(BASE_INPUT_XPATH, LOCATOR)).click();
    }

    @Step("Проверка видимости и названия ссылки => {LINK_TEXT}")
    public void checkLinksValidation(String LOCATOR, String LINK_TEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_XPATH, LOCATOR)).contentIsDisplayed(LINK_TEXT);
    }

}
