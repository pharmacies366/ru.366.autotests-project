package core;

import actions.PageActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import listener.RetryRule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;
import utils.WebDriverFactory;


public class MainTestBase {

    public WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();
    public static PageActions pageActions;
    private WebDriverFactory driverFactory;
    public static String nameOfPackage;
    protected Logger logger = LogManager.getLogger(MainTestBase.class);


    @Step("Пользователь переходит в карточку товара")
    protected void openUrl(String url) {
        driver.get(url);
        saveAllureScreenshot();
    }

    @BeforeEach
    @Step("Открывается Главная страница сайта")
    public void beforeClass_StartBrowser(TestInfo testInfo) {
        driverFactory = new WebDriverFactory();
        starting(testInfo);
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        driver.get(propertiesManager.getProperty("baseurl"));
        logger.info("Открывается главная страница сайта 36.6");
        //driver.manage().deleteAllCookies();

    }

    @AfterEach
    public void finish() {
    driver.close();
    }
    /**
     * Повторный запуск тестов при падении
     */

/*
    @Rule
    public RetryRule rule = new RetryRule(3);
*/

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
    };


    private void starting(TestInfo testInfo) {
        nameOfPackage = testInfo.getTestClass().get().getPackage().getName();
        logger.info("Тест старт " + testInfo.getDisplayName());
    }

    /**
     * @return - скриншот
     */
    @Attachment(value = "Скриншот", type = "image/png")
    public byte [] saveAllureScreenshot(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
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
