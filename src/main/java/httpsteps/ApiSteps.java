//package httpsteps;
//
//import io.qameta.allure.Step;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import utils.SimpleJSONMather;
//
//import java.util.Map;
//
//import static io.restassured.RestAssured.given;
//
//public class ApiSteps {
//    public ApiSteps() {
//        setToken();
//    }
//
//    private Response response;
//    private String authToken; //переменная в которой хранится токен авторизации
//
//    RequestSpecification requestSpecificationAuth = new RequestSpecBuilder()
//            .setBaseUri("https://api.cwzw6gg24a-llcapteka1-p1-public.model-t.cc.commerce.ondemand.com/")
//            .setBasePath("authorizationserver/oauth/")
//            .addHeader("Content-Type", "application/json")
//            .build();
//
//    RequestSpecification requestSpecification = new RequestSpecBuilder()
//            .setBaseUri("https://api.cwzw6gg24a-llcapteka1-p1-public.model-t.cc.commerce.ondemand.com/")
//            .setBasePath("rest/v2/")
//            .addHeader("Content-Type", "application/json")
//            .build();
//
//    @Step("Получение токена Matador")
//    private void setToken() {
//        Response response = given()
//                .spec(requestSpecificationAuth)
//                .queryParam("client_id", "matador")
//                .queryParam("client_secret", "Matador19")
//                .queryParam("grant_type", "password")
//                .queryParam("username", "matador_customer")
//                .queryParam("password", "Matador19")
//                .when()
//                .post("token");
//
//        authToken = response.path("access_token").toString();
//    }
//
////    @Step("Получение токена 'Megaapteka'")
////    private void megaAptekaToken() {
////        Response response = given()
////                .spec(requestSpecificationAuth)
////                .queryParam("client_id", "megapteka_client")
////                .queryParam("client_secret", "Vf2XCnWdV4odWGwp")
////                .queryParam("grant_type", "password")
////                .queryParam("username", "megapteka_ave")
////                .queryParam("password", "2nfwTbUXiGxj23Uz")
////                .when()
////                .post("token");
////
////        authToken = response.path("access_token").toString();
////    }
//
//    @Step("Пользователь делает GET-запрос на эндпоинт {endpoint} с параметрами {params}")
//    public void get(String endpoint, Map<String, String> queryParams) {
//        response = given().spec(requestSpecification).queryParams(queryParams)
//                .header("Authorization", "bearer " + authToken)
//                .when().get(endpoint);
//        System.out.println(response.body().asString());
//    }
//
//    @Step("Пользователь делает POST-запрос на эндпоинт {endpoint} с параметрами {params}")
//    public void post(String endpoint, Map<String, String> queryParams) {
//        response = given().spec(requestSpecification).queryParams(queryParams)
//                .header("Authorization", "bearer " + authToken)
//                .log()
//                .all()
//                .when().post(endpoint);
//        System.out.println(response.body().asString());
//
//    }
//
//
//    @Step("Пользователь получает id корзины")
//    public String getCartId() {
//        return response.path("code").toString();
//
//    }
//
//    @Step("Пользователь получает номер телефона")
//    public String getPhoneNumber() {
//        return response.path("uid").toString();
//    }
//
//    @Step("Пользователь проверяет, что ответ соответствует {filePath}")
//    public void assertResponse(String filePath) {
//        new SimpleJSONMather().assertResponseByFile(response.asString(), filePath);
//    }
//
//}
//