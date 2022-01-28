package api;/*
package api;


import httpsteps.ApiSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Feature(value = "API")
@Story("Регистрация пользователя через API")
@DisplayName("Регистрация пользователя через API")
public class ApiRegistrationTest {
    ApiSteps apiSteps = new ApiSteps();
    @DisplayName("Регистрация пользователя через API")
    @Test
    public void regUser(){
        String characters = "abcdefghijklmnopqrstuvwxyz";
        String randomString = "";
        int lenght = 5;
        Random random = new Random();
        //int lenght = random.nextInt(15);
        char[] text = new char[lenght];
        for(int i = 0; i < text.length; i++){
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        for (int i = 0; i < text.length; i++){
            randomString += text[i];
        }

        int num = random.nextInt(999);
        System.out.println(num);
        System.out.println(randomString);


        Map<String, String> params = new HashMap<String, String>();
        params.put("birthDate", "19900515");
        params.put("firstName", "ТестовыйЮзер");
        params.put("email",  randomString + "test@test.ru");
        params.put("middleName", "Тестович");
        params.put("lastName", "Тестов");
        params.put("password", "123456");
        params.put("gender", "male");
        params.put("phone", "9403394" + num);
        apiSteps.post("gorzdrav/77-gz/users/simple", params);

//        String number = apiSteps.getCardNumber();
        String uid = apiSteps.getPhoneNumber();

        uid = uid.replaceAll("[^\\d.]", "");
        Map<String, String> params1 = new HashMap<String, String>();
        params1.put("uid", "[gorzdrav]" + uid);
        apiSteps.post("gorzdrav/77-gz/cards/activate/virtual", params1);

        Map<String, String> params2 = new HashMap<String, String>();
        apiSteps.get("gorzdrav/77-gz/users/" + uid + "/cart", params2);
        String id = apiSteps.getCartId();

        Map<String, String> params3 = new HashMap<String, String>();
        params3.put("qty", "1");
        params3.put("code", "10016");
        apiSteps.post("gorzdrav/77-gz/users/" + uid + "/cart/" + id + "/entries", params3);

        Map<String, String> params4 = new HashMap<String, String>();
        params4.put("pointOfServiceName", "50572");
        params4.put("customerName", "Ivan");
        params4.put("customerEmail", "test@test.ru");
        params4.put("customerPhone", "9313600941");
        params4.put("cartId", id);

        apiSteps.post("gorzdrav/77-gz/users/" + uid + "/orders/booking", params4);
    }

}
*/
