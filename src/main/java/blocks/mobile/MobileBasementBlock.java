package blocks.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MobileBasementBlock extends MainTestBase {
    //элементы
    private static final String BASE_INPUT_XPATH = "xpath;(//a[@href='%s'])";
    private static final String HELP_BUTTON_XPATH = "xpath;//label[contains(@for,'0')]";
    private static final String SERVICE_BUTTON_XPATH = "xpath;//label[@for='ch_FooterNav2Node_1']";
    private static final String ABOUT_COMPANY_BUTTON_XPATH = "xpath;//label[@for='ch_FooterNav3Node_2']";

    //конструктор
    public MobileBasementBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getBaseInputBasementLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getHelpButton() {
        return new PageElementActions(HELP_BUTTON_XPATH, driver);
    }

    public PageElementActions getServiceButton() {
        return new PageElementActions(SERVICE_BUTTON_XPATH, driver);
    }

        public PageElementActions getAboutCompanyButton() {
        return new PageElementActions(ABOUT_COMPANY_BUTTON_XPATH, driver);
    }

    public PageElementActions getBaseInput(String format) {
        return new PageElementActions(BASE_INPUT_XPATH, driver);
    }


    //Методы

    @Step("Клик по кнопки Помощь")
    public void clickHelpButton() {
        getHelpButton().click();
    }

    @Step("Клик по кнопки Сервис")
    public void clickServiceButton() {
        getServiceButton().click();
    }

    @Step("Клик по кнопки О Компании")
    public void clickAboutCompanButton() {
        getAboutCompanyButton().click();
    }

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
