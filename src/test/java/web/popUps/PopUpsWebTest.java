package web.popUps;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Feature(value = "Web")
@Story("Проверка попапов на сайте 36.6")
@DisplayName("Проверка попапов на сайте 36.6")
@Tag("Web")
@Tag("Regression")
public class PopUpsWebTest extends BaseSettingsWebTests {

    @DisplayName("Проверка наличия и закрытия попапа с куки файлами")
    @Test
    public void checkButtonSelectCities(){
        mainPage.clickClosePopUp();
    }

}
