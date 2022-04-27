package autorization;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.PropertiesReader;
import core.TestBase;
import io.qameta.allure.Step;
import okhttp3.*;
import okhttp3.internal.JavaNetCookieJar;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class Authorization extends TestBase {
    final String CALENDAR_URL = "https://tt-develop.quality-lab.ru/calendar/";
    final String COOKIE = "PHPSESSID=6d7e7a307156309ec41a3f21508d7aa0";

    @Step("Авторизация на сайте и переход на страницу календаря: " + CALENDAR_URL)
    public void logInToQualityLabTT() {
        open(PropertiesReader.baseUrl);
        loginpage.enterName()
                .enterPassword()
                .clickSubmitButton();
        open(CALENDAR_URL);
        ((SelenideElement) calendarPage.CALENDAR_DOWNLOADING_MESSAGE.getWrappedElement()).shouldNotBe(Condition.visible);
        Assert.assertEquals(CALENDAR_URL, WebDriverRunner.url(), "AssertionFailedError");
    }

    @Step("Авторизация через API на сайте и переход на страницу календаря: " + CALENDAR_URL)
    public void logIntoQualityLabByAPI() throws IOException {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        JavaNetCookieJar cookieJar = new JavaNetCookieJar(cookieManager);

        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .followRedirects(false)
                .readTimeout(5, TimeUnit.SECONDS)
                .build();

        RequestBody formBody = new FormBody.Builder()
                .add("_csrf_token", "")
                .add("_username", "Сергей Оралов")
                .add("_password", "pwd4hotelRA")
                .add("_submit", "Войти")
                .build();

        Request request = new Request.Builder()
                .url(PropertiesReader.baseUrl + "/login_check")
                .addHeader("cookie", COOKIE)
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        Assert.assertEquals(302, response.code());

        open(PropertiesReader.baseUrl + "/login");
        Selenide.clearBrowserCookies();
        WebDriver driver = WebDriverRunner.getWebDriver();

        driver.manage().deleteAllCookies();
        cookieManager.getCookieStore().getCookies().forEach(httpCookie -> {

            Cookie cookie = new Cookie(httpCookie.getName(),
                    httpCookie.getValue(),
                    httpCookie.getDomain(),
                    httpCookie.getPath(),
                    null);

            driver.manage().addCookie(cookie);
            open(PropertiesReader.baseUrl + "/calendar");
        });
    }
}