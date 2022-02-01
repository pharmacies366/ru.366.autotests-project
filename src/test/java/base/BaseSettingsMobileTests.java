package base;

import actions.PageElementActions;
import core.MainTestBase;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.mobile.*;
import java.util.HashMap;
import java.util.Map;

public class BaseSettingsMobileTests extends MainTestBase {

    /*@Override
    public void beforeClass_StartBrowser() {
        super.beforeClass_StartBrowser();

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 6");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(chromeOptions);

    }*/


    protected PageElementActions pageElementActions;
    protected MobileTopPanelPage mobileTopPanelPage;
    protected MobileAuthPopUpPage mobileAuthPopUpPage;
    protected MobileCartPage mobileCartPage;
    protected MobileCheckOutPage mobileCheckOutPage;
    protected MobileProductCardPage mobileProductCardPage;
    protected MobileMainPage mobileMainPage;
    protected MobileOspPage mobileOspPage;
    protected MobileSberPage mobileSberPage;
    protected MobileThankForTheOrderPage mobileThankForTheOrderPage;
    protected MobileCatalogPage mobileCatalogPage;
    protected MobileCookiePage mobileCookiePage;
    protected MobileMedicationsCategoryPage mobileMedicationsCategoryPage;


    @Before
    public void PagesInitialization() {
        pageElementActions = new PageElementActions(driver);
        mobileTopPanelPage = new MobileTopPanelPage(driver);
        mobileCheckOutPage = new MobileCheckOutPage(driver);
        mobileCartPage = new MobileCartPage(driver);
        mobileAuthPopUpPage = new MobileAuthPopUpPage(driver);
        mobileProductCardPage = new MobileProductCardPage(driver);
        mobileMainPage = new MobileMainPage(driver);
        mobileOspPage = new MobileOspPage(driver);
        mobileSberPage = new MobileSberPage(driver);
        mobileThankForTheOrderPage = new MobileThankForTheOrderPage(driver);
        mobileCatalogPage = new MobileCatalogPage(driver);
        mobileCookiePage = new MobileCookiePage(driver);
        mobileMedicationsCategoryPage = new MobileMedicationsCategoryPage(driver);
    }

}