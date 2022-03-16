package pages.mobile.privateOffice;

import actions.PageElementActions;
import core.MainTestBase;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MobileChangePasswordPage extends MainTestBase {

    //элементы
    private static final String BASE_INPUT_PASSWORD_DATA_XPATH = "xpath;//input[@id='%s']";
    private static final String OldPassword = "currentPassword";
    private static final String NewPassword = "newPassword";
    private static final String CheckNewPassword = "checkNewPassword";
    private static final String CHANGE_BUTTON_XPATH = "xpath;//button[@class='b-btn']";
    private static final String MESSAGE_ABOUT_CHANGE_PASSWORD_XPATH = "xpath;//div[@class='alert b-global-messages b-global-messages--success']";
    private static final String Message_About_Change_Password = "Ваш пароль успешно изменен. Желаем здоровья!";


    //конструктор
    public MobileChangePasswordPage(WebDriver driver) {
        this.driver = driver;
    }


    //геттеры элементов с получением доступа к действиям с элементами

    public PageElementActions getBaseInputePrsonalDetails(String xpath) {
        return new PageElementActions(xpath, driver);
    }

    public PageElementActions getChangeButton() {
        return new PageElementActions(CHANGE_BUTTON_XPATH, driver);
    }

    public PageElementActions getMassageAboutPassword() {
        return new PageElementActions(MESSAGE_ABOUT_CHANGE_PASSWORD_XPATH, driver);
    }

    //Методы

    @Step("Пользователь вводит старый и новый пароли")
    public void clickChangePassword(String oldPassword, String newPassword, String checkNewPassword) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA_XPATH, OldPassword)).sendKeys(oldPassword);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA_XPATH, NewPassword)).sendKeys(newPassword);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA_XPATH, CheckNewPassword)).sendKeys(checkNewPassword);
        logger.info("Пользователь вводит старый и новый пароли");
    }
    @Step("Пользователь нажимает кнопку изменить")
    public void clickChangeButton() {
        getChangeButton().click();
        logger.info("Пользователь нажимает кнопку изменить");
    }

    @Step("Пользователь получает сообщение об успешной смене пароля")
    public void getMessageAboutChangePassword() {
        String message = getMassageAboutPassword().getText();
        Assert.assertEquals(Message_About_Change_Password, message);
        logger.info("Пользователь получает сообщение об успешной смене пароля");
    }

}
