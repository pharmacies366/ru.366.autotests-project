package pages.web.bonusCard;

import actions.PageElementActions;
import core.MainTestBase;
import org.openqa.selenium.WebDriver;

public class BonusCardPopUpPage extends MainTestBase {
    //элементы
    private static final String CHECKBOX_I_HAVE_BOBUS_CARD_XPATH = "xpath;(//span[@class='b-custom-input--special'])[2]";
    private static final String CHECKBOX_GET_A_BOBUS_CARD_XPATH = "xpath;(//span[@class='b-custom-input--special'])[3]";
    private static final String MALE_BUTTON_XPATH = "xpath;//input[@value='MALE']";
    private static final String FEMALE_BUTTON_XPATH = "xpath;//input[@value='FEMALE']";
    private static final String LINK_BUTTON_XPATH = "xpath;//button[@class='b-btn  b-btn--full']";
    private static final String CLOSE_BUTTON_XPATH = "xpath;//button[contains(@class,'close')]";
    private static final String CLOSE_POP_UP_BUTTON_XPATH = "xpath;//span[@class='b-icn--close']";



    //конструктор
    public BonusCardPopUpPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getIHaveBonusCard() {
        return new PageElementActions(CHECKBOX_I_HAVE_BOBUS_CARD_XPATH, driver);
    }

    public PageElementActions getBonusCard() {
        return new PageElementActions(CHECKBOX_GET_A_BOBUS_CARD_XPATH, driver);
    }

    public PageElementActions getMaleButton() {
        return new PageElementActions(MALE_BUTTON_XPATH, driver);
    }

    public PageElementActions getFemaleButton() {
        return new PageElementActions(FEMALE_BUTTON_XPATH, driver);
    }

    public PageElementActions getLinkButton() {
        return new PageElementActions(LINK_BUTTON_XPATH, driver);
    }

    public PageElementActions getCloseButton() {
        return new PageElementActions(CLOSE_BUTTON_XPATH, driver);
    }

    public PageElementActions getClosePopUpButton() {
        return new PageElementActions(CLOSE_POP_UP_BUTTON_XPATH, driver);
    }


    //Методы

   /* @Step("Пользователь заполняет контактные данные")
    public void contactDetails(String fio, String phoneNumber, String email ) {
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Fio)).sendKeys(fio);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, PhoneNumber)).sendKeys(phoneNumber);
        getBaseInputContactDetails(String.format(BASE_INPUT_CONTACT_DETAILS_XPATH, Email)).sendKeys(email);
        logger.info("Пользователь заполнил контактные данные");
    }*/
}
