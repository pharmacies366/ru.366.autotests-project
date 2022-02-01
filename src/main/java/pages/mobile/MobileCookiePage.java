package pages.mobile;

import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public class MobileCookiePage extends MainTestBase {


    //конструктор
    public MobileCookiePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Пользователь авторизовывается через Cookie")
    public void cookieAuthorization() {
        logger.info("ПРОИЗОШЛА АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ ЧЕРЕЗ COOKIE");
        //stg1
//        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "9b05b8068651765e8437cc2a75de9dc37589c1c7"));
//        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTk0MDMzOTQ1NTU6MTYzMTI3MzMxMDMzMTo5OGRmMTViMDUzMWM2MTM5OGFjYzFhMTU2MzI4MTlhMQ"));
//        driver.manage().addCookie(new Cookie("JSESSIONID", "B1149196AB51CDBE16C43E6A13E07A76.stg-hybris-app-03"));

        // D1
//        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "332091cf3bcec54cf1a586a85ac2aeac70a285d4"));
//        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTk0MDc4Nzg1NTM6MTYzMTcwOTExNjY5MzpmZDVkZWU2MzJjNmU0YmVkMzgzN2U3NWEwZDFmYmI3MA"));
//        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-595bfb867d-ppvx8"));

//        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe")); //кука для обхода каптчи
        // S1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "3eb864fcbd666984c5bd8109917b78e5ed4d1c53"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTk0MDEyMTMxNDQ6MTYzNDY0MTE3Mzc4ODo4NWQ2ODNjN2EyOGYzNzZmZmNhMjFmYzk0ZWZhMmU0Ng"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-8f8fc67f4-txp2g"));

        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));
//        print();

        //P1
//        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "43f1f64d87a81b03107e775ddad83cee45395e48"));
//        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "W2dvcnpkcmF2XTk0MDMzOTQ0NDQ6MTYzMzc3NTk3Nzk2OTpkMDM2M2FmNGIyM2E3OTA5MTU5OGI4ZGYzZTk0ZWE3ZQ"));
//        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-86875989fb-9srpz"));
//
//        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));

    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));
    }

    @Step("Получение всех кук и вывод их в консоль")
    public void printAllCookie() {
        Set<Cookie> cookies = new HashSet<>();
        cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            System.out.println("Имя куки - " + cookieName + " значение  куки - " + cookie.getValue());
        }
    }

    @Step("Пользователь очищает Cookie")
    public void deleteAllCookie() {
        driver.manage().deleteAllCookies();
        logger.info("ПОЛЬЗОВАТЕЛЬ ОЧИСТИЛ COOKIE");
        logger.info("ПОЛЬЗОВАТЕЛЬ РАЗЛОГИНЕН");
    }

}
