package base;

import actions.PageElementActions;
import blocks.mobile.MobileBasementBlock;
import blocks.mobile.MobileHeaderBlock;
import core.MainTestBase;
import org.junit.Before;
import pages.mobile.*;

public class BaseSettingsMobileTests extends MainTestBase {


    protected PageElementActions pageElementActions;
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
    protected MobileMyOrdersPage mobileMyOrdersPage;
    protected MobileHeaderBlock mobileHeaderBlock;
    protected MobileBasementBlock mobileBasementBlock;


    @Before
    public void PagesInitialization() {
        pageElementActions = new PageElementActions(driver);
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
        mobileMyOrdersPage = new MobileMyOrdersPage(driver);
        mobileHeaderBlock = new MobileHeaderBlock(driver);
        mobileBasementBlock = new MobileBasementBlock(driver);
    }

}