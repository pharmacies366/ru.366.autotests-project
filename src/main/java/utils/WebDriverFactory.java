package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;


public class WebDriverFactory {
    private Logger logger = LogManager.getLogger(WebDriverFactory.class);
    private RemoteWebDriver driver;

    @Step("Получение типа драйвера")
    public WebDriver getDriver() {
        DriverType driverType = DriverType.valueOf(System.getProperty("driver").toUpperCase());
        switch (driverType) {
            case LOCAL:
                setupLocalDriver();
                break;
            case REMOTE:
                setupRemoteDriver();
                break;
        }
        return driver;
    }

    @Step("Настройка удаленного драйвера")
    private void setupRemoteDriver() {
        logger.info("setup remote driver");
        String driverURL = System.getProperty("driverurl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("97.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        try {
            driver = new RemoteWebDriver(
                    URI.create(driverURL).toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        configureDriver();
        logger.info("ЗАПУЩЕН УДАЛЕННЫЙ ДРАЙВЕР");
    }

    @Step("Настройка локального драйвера")
    public void setupLocalDriver() {
        logger.info("setup local web driver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        configureDriver();
        logger.info("ЗАПУЩЕН ЛОКАЛЬНЫЙ ДРАЙВЕР");
    }

    @Step("Конфигурация драйвера")
    private void configureDriver() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}
