package pages.mobile.privateOffice;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class MobilePersonalAccountPage extends MainTestBase {


    //элементы
    private static final String BASE_INPUT_OPTIONS_XPATH = "xpath;(//a[@href='%s'])[3]";
    private static final String MY_ORDERS_BUTTON = "/my-account/orders";
    private static final String PROFILE_BUTTON_XPATH = "xpath;(//a[@class='b-login-link js-register-ext__button'])[1]";
    private static final String CHANGE_PASSWORD_BUTTON = "/my-account/update-password";
    private static final String FAVORITES_BUTTON_XPATH = "xpath;(//a[@class='b-login-link js-register-ext__button'])[1]";
    private static final String INVITE_FRIEND_BUTTON_XPATH = "xpath;(//a[@class='b-login-link js-register-ext__button'])[1]";
    private static final String LOGOUT_BUTTON_XPATH = "xpath;(//a[@class='b-login-link js-register-ext__button'])[1]";

    //конструктор
    public MobilePersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }




    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputBasementLinks(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    //Методы
    @Step("Проверка видимости и названия ссылки => {LINKTEXT}")
    public void checkLinksValidation(String LOCATOR, String LINKTEXT) {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, LOCATOR)).contentIsDisplayed(LINKTEXT);
    }

    @Step("Пользователь нажимает на кнопку Изменить пароль")
    public void clickChangePassword() {
        getBaseInputBasementLinks(String.format(BASE_INPUT_OPTIONS_XPATH, CHANGE_PASSWORD_BUTTON)).click();
        logger.info("Пользователь нажимает на кнопку Изменить пароль");
    }
}
