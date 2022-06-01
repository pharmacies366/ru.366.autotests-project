package pages.mobile.sber;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;


public class MobileSberPage extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_BANK_CARD_DETAILS_XPATH = "xpath;//input[@id='%s']";
    private static final String CARD_NUMBER = "pan";
    private static final String MONTH_YEAR = "expiry";
    private static final String CVV = "cvc";
    private static final String SUBMIT_BUTTON_XPATH = "xpath;//span[contains(.,'Оплатить')]";



    //конструктор
    public MobileSberPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getInputbankCardDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getSubmitButton() {
        return new PageElementActions(SUBMIT_BUTTON_XPATH, driver);
    }


    //Методы

    @Step("Заполнение данных банковской карты")
    public void bankCardDetails(String cardNumber, String monthYear, String cvv) {
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS_XPATH, CARD_NUMBER)).sendKeys(cardNumber);
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS_XPATH, MONTH_YEAR)).sendKeys(monthYear);
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS_XPATH, CVV)).sendKeys(cvv);
        logger.info("Пользователь заполнил данные банковской карты");
    }

    @Step("Пользователь нажимает на кнопку 'Оплатить'")
    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

}
