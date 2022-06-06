package core;

import actions.PageActions;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import utils.PropertiesManager;
import utils.WebDriverFactory;

public class MainTestBase {

    protected WebDriver driver;
    protected PropertiesManager propertiesManager = new PropertiesManager();
    protected PageActions pageActions;
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
        WebDriverFactory driverFactory = new WebDriverFactory();
        starting(testInfo);
        driver = driverFactory.getDriver();
        pageActions = new PageActions(driver);
        openStartPage();
        logger.info("Открывается главная страница сайта 36.6");
        //driver.manage().deleteAllCookies();
    }

    @AfterEach
    public void finish() {
        driver.close();
        driver.quit();
    }


    private void starting(TestInfo testInfo) {
        nameOfPackage = testInfo.getTestClass().get().getPackage().getName();
        logger.info("Тест старт " + testInfo.getDisplayName());
    }

    private void openStartPage() {
        try {
            driver.get(propertiesManager.getProperty("baseurl"));
            // pageActions.checkUrl(propertiesManager.getProperty("baseurl"));
        } catch (org.openqa.selenium.TimeoutException ex) {
            driver.navigate().refresh();
        }
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
