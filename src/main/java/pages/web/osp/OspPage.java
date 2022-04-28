package pages.web.osp;

import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class OspPage {

    //элементы
    private final Button PRODUCT_NAME = new Button($x( "//a[@href='/g/nurofen']"));
    private final Button BANNER = new Button($x( "//img[@class='b-bnr--responsive__img ']"));

    //Методы

    @Step("Пользователь нажимает на товар 'Нурофен'")
    public OspPage clickProductName() {
        PRODUCT_NAME.click();
        //logger.info("Пользователь нажимает на товар 'Нурофен'");
        return this;
    }

    @Step("Пользователь проверяет и переходит по банеру")
    public OspPage clickBanner() {
        BANNER.click();
        //logger.info("Пользователь проверяет и переходит по банеру");
        return this;
    }

}