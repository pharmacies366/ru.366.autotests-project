package base;

import actions.PageElementActions;
import core.MainTestBase;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import pages.mobile.*;

import java.util.concurrent.TimeUnit;

public class BaseSettingsMobileTests extends MainTestBase {

    @Override
    public void beforeClass_StartBrowser() {
        super.beforeClass_StartBrowser();
        driver.manage().window().setSize(new Dimension(414, 896));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

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