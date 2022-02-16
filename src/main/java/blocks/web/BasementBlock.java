package blocks.web;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasementBlock extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_XPATH = "xpath;(//a[@href='%s'])";

    //конструктор
    public BasementBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getBaseInputBasementLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }


    //Методы

    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public void checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
    }

    @Step("Кликает по локатору {LOCATOR}")
    public void selectBasementButtons(String LOCATOR) {
        this.basementButton(LOCATOR).click();
    }

    private WebElement basementButton(String LOCATOR) {
        return driver.findElement(By.xpath("(//a[@href='/" + LOCATOR + "/'])"));
    }

}
