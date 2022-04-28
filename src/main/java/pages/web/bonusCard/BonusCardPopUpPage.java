package pages.web.bonusCard;

import ru.yandex.qatools.htmlelements.element.Button;

import static com.codeborne.selenide.Selenide.$x;

public class BonusCardPopUpPage {
    //элементы
    private final Button CHECKBOX_I_HAVE_BOBUS_CARD = new Button($x("xpath;(//span[@class='b-custom-input--special'])[2]"));
    private final Button CHECKBOX_GET_A_BOBUS_CARD = new Button($x( "(//span[@class='b-custom-input--special'])[3]"));
    private final Button MALE_BUTTON = new Button($x(  "//input[@value='MALE']"));
    private final Button FEMALE_BUTTON = new Button($x(  "//input[@value='FEMALE']"));
    private final Button LINK_BUTTON = new Button($x(  "//button[@class='b-btn  b-btn--full']"));
    private final Button CLOSE_BUTTON = new Button($x(  "//button[contains(@class,'close')]"));
    private final Button CLOSE_POP_UP_BUTTON = new Button($x(  "//span[@class='b-icn--close']"));


}
