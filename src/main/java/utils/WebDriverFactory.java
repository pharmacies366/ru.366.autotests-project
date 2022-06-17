package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static core.MainTestBase.nameOfPackage;


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
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--dns-prefetch-disable");
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        prefs.put("googlegeolocationaccess.enabled", true);
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 1:allow 2:block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        prefs.put("profile.managed_default_content_settings", 1);
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);


        if (nameOfPackage.contains("mobile")) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X");
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }


        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        String driverURL = System.getProperty("driverurl");
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("91.0");

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
        logger.info("setup local driver");
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome(); //в чем разница?


        chromeOptions.addArguments("--incognito");
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));//оставить
        // или chromeOptions.addArguments("enable-automation");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--dns-prefetch-disable");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disabled-popup-blocking");
        //chromeOptions.addArguments("--headless");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //  chromeOptions.setPageLoadStrategy(PageLoadStrategy.eager);
        Map<String, Object> prefs = new HashMap<String, Object>();
        Map<String, Object> profile = new HashMap<String, Object>();
        prefs.put("googlegeolocationaccess.enabled", true);
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 1:allow 2:block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        prefs.put("profile.managed_default_content_settings", 1);
        chromeOptions.setExperimentalOption("prefs", prefs);


        if (nameOfPackage.contains("mobile")) {
            WebDriverManager.chromedriver().setup();
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", "iPhone X");
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(capabilities);
        //driver = new ChromeDriver(chromeOptions);
        configureDriver();
        logger.info("ЗАПУЩЕН ЛОКАЛЬНЫЙ ДРАЙВЕР");
    }


    @Step("Конфигурация драйвера")
    private void configureDriver() {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }


}
