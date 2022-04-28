import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.web.main.MainPage;

public class FirstLessonWebTest extends BaseTest {

    private MainPage mainPage;

    @BeforeEach
    void setUpd() {
        mainPage = Selenide.open("https://366.ru/", MainPage.class);
    }


    @Test
    @DisplayName("Какая то проверка")
    void checkAboutPage() {

    }


    @ValueSource(strings = {
            "TestName",
            "TestName",
            "TestName"
    })

    @ParameterizedTest(name = "Проверка спикера {0}")
    void speakersTest(String name) {
        mainPage.clickClosePopUp();
    }


    @Test
    @DisplayName("Проверка кликабельности логотипа")
    void checkTest(){
       mainPage.clickClosePopUp();
    }




}
