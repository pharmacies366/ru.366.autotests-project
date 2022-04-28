package pages.web.sber;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;
import static com.codeborne.selenide.Selenide.$x;


public class SberPage {

    //элементы
    private final Button BASE_INPUT_BANK_CARD_DETAILS = new Button($x( "//input[@id='%s']"));
    private final String CARD_NUMBER = "pan";
    private final String MONTH_YEAR = "expiry";
    private final String CVV = "cvc";
    private final Button SUBMIT_BUTTON = new Button($x( "//*[@class='styles_button__1M9-J styles_solid__1fLFs']"));

    //Методы
/*    @Step("Заполнение данных банковской карты")
    public SberPage bankCardDetails(String cardNumber, String monthYear, String cvv) {
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS, CARD_NUMBER)).sendKeys(cardNumber);
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS, MONTH_YEAR)).sendKeys(monthYear);
        getInputbankCardDetails(String.format(BASE_INPUT_BANK_CARD_DETAILS, CVV)).sendKeys(cvv);
        return this;
    }*/

    @Step("Пользователь нажимает на кнопку 'Оплатить'")
    public SberPage clickOnSubmitButton() {
        SUBMIT_BUTTON.click();
        return this;
    }
}
