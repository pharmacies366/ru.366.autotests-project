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


    // S1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "cadf2ba7f4b29a7548f2ad7aedb05f52453ab8ef"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "OTMxMzYwMDk0MToxNjQ2NDc1NjUyMjI2OjUxZWI2ZWMwNTA4NzhlNDc4ODVlZTI1YjExZmQ0OWY1"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-569ff799ff-lk62h"));


}
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "cadf2ba7f4b29a7548f2ad7aedb05f52453ab8ef"));//кука для обхода каптчи
    }



    /*    // D1
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "040b78b58009efd8a6659b9fd2c09010d52c85a0"));
        driver.manage().addCookie(new Cookie("avestorefrontRememberMe", "OTMxMzYwMDk0MToxNjQ2NDcwODY1OTU1OjY3MWYwNjNiYmYzMmU3M2JhZTM1NDk1MmVkODZjMDA2"));
        driver.manage().addCookie(new Cookie("ROUTE", ".accstorefront-5885446974-zv94f"));


    }
    public void reCaptchaKey(){
        driver.manage().addCookie(new Cookie("acceleratorSecureGUID", "040b78b58009efd8a6659b9fd2c09010d52c85a0"));
    }*/

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
