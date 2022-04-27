import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.web.Main366Page;

public class FirstLessonWebTest {

    private Main366Page mainPage;

    @BeforeEach
    void setUp() {
        mainPage = Selenide.open("https://366.ru/", Main366Page.class);
    }

    @AfterEach
    void close() {
        Selenide.closeWebDriver();
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

    }
}
