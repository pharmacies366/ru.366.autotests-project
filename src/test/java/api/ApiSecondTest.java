package api;/*
package api;

import httpsteps.ApiSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


@Feature(value = "API")
@Story("Оформление заказа через API")
@DisplayName("Оформление заказа через API")
public class ApiSecondTest {
    ApiSteps apiSteps = new ApiSteps();
    @DisplayName("Неавторизованный пользователь оформляет заказ через API")
    @Test
    public void postGetAuthToken() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("fields", "FULL");
        apiSteps.get("gorzdrav/77-gz/cart", params);
        String id = apiSteps.getCartId();

        Map<String, String> params2 = new HashMap<String, String>();
        params2.put("qty", "1");
        params2.put("code", "29992");
        apiSteps.post("gorzdrav/77-gz/cart/" + id + "/entries", params2);

        Map<String, String> params3 = new HashMap<String, String>();
        params3.put("productCodes", "29992");
        apiSteps.get("gorzdrav/77-gz/products/stock", params3);


        Map<String, String> params4 = new HashMap<String, String>();
        params4.put("cartId", id);
        apiSteps.get("gorzdrav/77-gz/stores/booking", params4);

        Map<String, String> params5 = new HashMap<String, String>();
        params5.put("pointOfServiceName", "45691");
        params5.put("customerName", "Ivan");
        params5.put("customerEmail", "test@test.ru");
        params5.put("customerPhone", "9313600941");
        params5.put("cartId", id);

        apiSteps.post("gorzdrav/77-gz/orders/booking", params5);

    }
}
*/
