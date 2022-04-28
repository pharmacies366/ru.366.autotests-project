package pages.web.catalog;

import ru.yandex.qatools.htmlelements.element.Button;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {


    //элементы

    //категории
    private final Button BASE_INPUT_CATEGORYS_BUTTON = new Button($x( "(//a[@href='%s'])[1]"));
    private final String MEDICATIONS = "/c/lekarstva/";

    //подкатегории
    private final String ALLERGY = "/c/allergija/";



/*    //Методы
    @Step("Пользователь нажимает на категорию лекарства")
    public CatalogPage clickMedicationsButtons() {
        BASE_INPUT_CATEGORYS_BUTTON(String.format(BASE_INPUT_CATEGORYS_BUTTON, MEDICATIONS)).click();
       // logger.info("Пользователь нажимает на категорию лекарства");
        return this;
    }*/
}

