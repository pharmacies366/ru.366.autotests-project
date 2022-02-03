package pages.web;

import core.MainTestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.util.HashSet;
import java.util.Set;

public class CookiePage extends MainTestBase {


    //конструктор
    public CookiePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Пользователь авторизовывается через Cookie")
    public void cookieAuthorization() {
        logger.info("ПРОИЗОШЛА АВТОРИЗАЦИЯ ПОЛЬЗОВАТЕЛЯ ЧЕРЕЗ COOKIE");


    // S1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "fd327da881f1f239f5c6bcfe2253ac95f6f92cb8"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "OTMxMzYwMDk0MToxNjQ2NDc1NTE1Mzg3OjRhNWUxZjIzOGNiYWMwNDA3N2ZkODBhMDU1YmI2NTEz"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-569ff799ff-lbxgk"));


}
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));//кука для обхода каптчи
    }


/*
        // D1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "16ea6cf91e935cba1204795f042c197272e8972e"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "OTMxMzYwMDk0MToxNjQ2NDcwNzE4NTIxOmI3MjE4YzQ5ZjdmMmU3ZDc3MmNmNzg0M2FmODQzNDFk"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-5885446974-zv94f"));


    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "16ea6cf91e935cba1204795f042c197272e8972e"));//кука для обхода каптчи
    }

*/




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
