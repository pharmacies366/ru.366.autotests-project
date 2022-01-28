package api;/*
package api;

import httpsteps.ApiSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;


import java.util.HashMap;
import java.util.Map;


@Feature(value = "API")
@Story("Оформление заказа через API")
@DisplayName("Оформление заказа через API")
public class ApiTest {
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
        params3.put("pointOfServiceName", "45691");
        params3.put("customerName", "Ivan");
        params3.put("customerEmail", "test@test.ru");
        params3.put("customerPhone", "9313600941");
        params3.put("cartId", id);

        apiSteps.post("gorzdrav/77-gz/orders/booking", params3);

    }

}*/
