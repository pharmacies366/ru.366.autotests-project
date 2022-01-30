package pages.mobile;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MobileThankForTheOrderPage extends MainTestBase {

    private Logger logger = LogManager.getLogger(MobileThankForTheOrderPage.class);


    //элементы
    private static final String ERROR_PAYMENT_XPATH = "xpath;//a[contains(.,'Вернуться в магазин')]";



    //конструктор
    public MobileThankForTheOrderPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами
    public PageElementActions getErrorPayment() {
        return new PageElementActions(ERROR_PAYMENT_XPATH, driver);
    }



    //Методы

    @Step("Пользователь после отлаты тестовой картой получает ошибку об оплате")
    public void checkPaymentError(){
        getErrorPayment().elementIsVisibility();
        logger.info("Пользователь получает ошибку об оплате");
        saveAllureScreenshot();
    }


}
