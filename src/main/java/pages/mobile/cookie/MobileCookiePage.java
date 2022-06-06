package pages.mobile.cookie;

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


        // P1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "ef9e825869b9e6e0cb5ffbbce9fd0d0c47cbdec2"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "OTMxMzYwMDk0MToxNjQ2ODQxMzYwMDU3OjQ0ZTJkYWE3Mjg5OTIxOTZlMmNhM2RhOWViNDY5MDEx"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-5f97bcbc9d-959b9"));


    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "23b3b99c12da43c02b8967f11d0f9dff2516fcbe"));//кука для обхода каптчи
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
