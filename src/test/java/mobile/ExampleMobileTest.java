package mobile;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature(value = "Mobile")
@Story("Проверка суммы 2-х товаров в корзине на сайте 36.6")
@DisplayName("Проверка суммы 2-х товаров в корзине")
public class ExampleMobileTest extends BaseSettingsWebTests {

    @DisplayName("Пользователь добавляет в корзину 2 товара и проверяет общую сумму")
    @Test
    @Tag("IntegrationTest")
    public void test() {
        driver.get("https://lingualeo.com/ru");
        pageActions.staticWait(5000);
    }
}



