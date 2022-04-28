package pages.web.cities;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class CitiesPopUpPage {

    //элементы
    private final Button MSK_BUTTON = new Button($x( "(//a[contains(.,'Москва и МО')])[3]"));
    private final Button SPB_UP_BUTTON = new Button($x( "(//a[contains(.,'Санкт-Петербург и ЛО')])[3]"));


    //Методы
    @Step("Пользователь нажимает на город Санкт-Петербург")
    public CitiesPopUpPage selectSpbCity() {
        SPB_UP_BUTTON.click();
       // logger.info("Пользователь нажимает на город Санкт-Петербург");
        return this;
    }
    @Step("Пользователь нажимает на город Москва")
    public CitiesPopUpPage selectMskCity() {
        MSK_BUTTON.click();
        //logger.info("Пользователь нажимает на город Москва");
        return this;
    }
}
