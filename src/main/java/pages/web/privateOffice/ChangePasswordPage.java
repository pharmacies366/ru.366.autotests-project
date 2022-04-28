package pages.web.privateOffice;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class ChangePasswordPage {

    //элементы
    private final Button BASE_INPUT_PASSWORD_DATA = new Button($x( "//input[@id='%s']"));
    private final String OLD_PASSWORD = "currentPassword";
    private final String NEW_PASSWORD = "newPassword";
    private final String CHECK_NEW_PASSWORD = "checkNewPassword";
    private final Button CHANGE_BUTTON = new Button($x( "//button[@class='b-btn']"));
    private final Button LOCATOR_FOR_MESSAGE_ABOUT_CHANGE_PASSWORD = new Button($x( "//div[@class='alert b-global-messages b-global-messages--success']"));
    private final String MESSAGE_ABOUT_CHANGE_PASSWORD = "Ваш пароль успешно изменен. Желаем здоровья!";


    //Методы

/*    @Step("Пользователь вводит старый и новый пароли")
    public ChangePasswordPage clickChangePassword(String oldPassword, String newPassword, String checkNewPassword) {
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA, OLD_PASSWORD)).sendKeys(oldPassword);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA, NEW_PASSWORD)).sendKeys(newPassword);
        getBaseInputePrsonalDetails(String.format(BASE_INPUT_PASSWORD_DATA, CHECK_NEW_PASSWORD)).sendKeys(checkNewPassword);
        //logger.info("Пользователь вводит старый и новый пароли");
        return this;
    }*/

    @Step("Пользователь нажимает кнопку изменить")
    public ChangePasswordPage clickChangeButton() {
        CHANGE_BUTTON.click();
      //  logger.info("Пользователь нажимает кнопку изменить");
        return this;
    }

    @Step("Пользователь получает сообщение об успешной смене пароля")
    public ChangePasswordPage getMessageAboutChangePassword() {
        String message = LOCATOR_FOR_MESSAGE_ABOUT_CHANGE_PASSWORD.getText();
       // Assert.assertEquals(MESSAGE_ABOUT_CHANGE_PASSWORD, message);
       // logger.info("Пользователь получает сообщение об успешной смене пароля");
        return this;
    }

}
