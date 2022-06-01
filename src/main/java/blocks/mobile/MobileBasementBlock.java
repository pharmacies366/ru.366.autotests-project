package blocks.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobileBasementBlock extends MainTestBase {
    //элементы
    private static final String BASE_INPUT_XPATH = "xpath;(//a[@href='%s'])";
    private static final String HELP_BUTTON_XPATH = "xpath;(//label[@class='c-block-view-ch__label']//child::div)[1]";
    private static final String SERVICE_BUTTON_XPATH = "xpath;(//label[@class='c-block-view-ch__label']//child::div)[2]";
    private static final String ABOUT_COMPANY_BUTTON_XPATH = "xpath;(//label[@class='c-block-view-ch__label']//child::div)[3]";
    private static final String PHONE_NUMBER_XPATH = "xpath;(//a[@class='b-icn--phone i-fw-b'])[3]";

    //конструктор
    public MobileBasementBlock(WebDriver driver) {
        this.driver = driver;
    }

    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputBasementLocators(String xpath) {
        return new PageElementActions(xpath, driver);
    }

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

    public PageElementActions getPhoneNumber() {
        return new PageElementActions(PHONE_NUMBER_XPATH, driver);
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

    @Step("Кликает по локатору {LOCATOR}")
    public void selectBasementButtons(String LOCATOR) {
        getBaseInputBasementLocators(String.format(BASE_INPUT_XPATH, LOCATOR)).click();
    }

    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public void checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
    }


}
