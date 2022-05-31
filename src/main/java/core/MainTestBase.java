package core;

import actions.PageActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import listener.RetryRule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;
import utils.WebDriverFactory;

public class MainTestBase {

    public static PageActions pageActions;
    public static String nameOfPackage;
    public WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();
    protected Logger logger = LogManager.getLogger(MainTestBase.class);
    /**
     * Управление действиями, при различных исходах теста
     */

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            logger.info("Тест упал");
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("Тест успешно завершен");
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }

        @Override
        protected void starting(Description description) {
            nameOfPackage = description.getTestClass().getPackage().getName();
            logger.info("Тест старт " + description.getMethodName());
        }

    };
    private WebDriverFactory driverFactory;

    @Step("Пользователь переходит в карточку товара")
    protected void openUrl(String url) {
        driver.get(url);
        saveAllureScreenshot();
    }

    @Before
    @Step("Открывается Главная страница сайта")
    public void beforeClass_StartBrowser() {
        driverFactory = new WebDriverFactory();
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        driver.get(propertiesManager.getProperty("baseurl"));
        logger.info("Открывается главная страница сайта 36.6");

    }



    /*
     * Повторный запуск тестов при падении
     */


/*
    @Rule
    public RetryRule rule = new RetryRule(3);

*/


    @After
    public void finish() {
        driver.quit();
    }

    /**
     * @return - скриншот
     */
    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * Прикрепить строку к отчету
     *
     * @param string - Входящая строка
     * @return - строка к отчету
     */
    @Attachment(value = "строка")
    public String returnString(String string) {
        return string;
    }

    @Attachment(value = "Result")
    public String returnAttachment() {
        return "Все хорошо";
    }
}
