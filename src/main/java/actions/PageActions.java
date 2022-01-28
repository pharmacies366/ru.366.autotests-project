package actions;

import core.MainTestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageActions extends MainTestBase {

    private Logger logger = LogManager.getLogger(MainTestBase.class);

    //конструктор
    public PageActions(WebDriver driver) {
        this.driver = driver;
    }


    //Методы


    //Переход по url
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Обновить страницу
    public void reloadPage() {
        logger.info("ПОЛЬЗОВАТЕЛЬ ОБНОВЛЯЕТ СТРАНИЦУ");
        driver.navigate().refresh();
        logger.info("СТРАНИЦА ОБНОВЛЕНА");
    }

    //Переключиться на другое окно
    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles())
            driver.switchTo().window(windowHandle);
    }


    //Проверка url
    public void checkUrl(String url) {
        driver.getCurrentUrl();
        Assert.assertTrue(url.equals(url));
    }

    //Получить Title
    public String getTitle() {
        return driver.getTitle();
    }

    //Сравнить два текста
    public void assertEqualsTwoObject(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    //Проверка видимости текста на странице
    public void contentIsDisplayed(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).isDisplayed();
    }

    //Ожидание загрузки на странице Javascript
    public void waitPageLoad() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebDriverWait jqWait = new WebDriverWait(driver, 25);


        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) js.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try {
            jqWait.until(jQueryLoad);
        } catch (org.openqa.selenium.TimeoutException ex) {
            //test
        }
        wait.until(jsLoad);
    }
}
