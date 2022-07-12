package base;

import actions.PageElementActions;
import blocks.mobile.MobileBasementBlock;
import blocks.mobile.MobileHeaderBlock;
import blocks.mobile.MobileMainPopUpBlock;
import core.MainTestBase;
import org.junit.jupiter.api.BeforeEach;
import pages.commonActions.mobile.CommonActionsOnMobilePages;
import pages.mobile.authorization.MobileAuthPopUpPage;
import pages.mobile.botConsultant.MobileBotConsultantPopUpPage;
import pages.mobile.cart.MobileCartPage;
import pages.mobile.categorys.medicationsCategorys.MobileMedicationsCategorysPopUpPage;
import pages.mobile.checkout.MobileCheckOutPage;
import pages.mobile.cities.MobileCitiesPopUpPage;
import pages.mobile.cookie.MobileCookiePage;
import pages.mobile.main.MobileMainPage;
import pages.mobile.orders.MobileMyOrdersPage;
import pages.mobile.osp.MobileOspPage;
import pages.mobile.privateOffice.MobileChangePasswordPage;
import pages.mobile.privateOffice.MobileFavoritesPage;
import pages.mobile.privateOffice.MobilePersonalAccountPage;
import pages.mobile.privateOffice.MobilePersonalDataPage;
import pages.mobile.product.MobileProductCardPage;
import pages.mobile.sber.MobileSberPage;
import pages.mobile.subCategorys.medications.MobileAllergyPage;
import pages.mobile.subCategorys.medications.MobileMedicationsPage;
import pages.mobile.thanks.MobileThankForTheOrderPage;

public class BaseSettingsMobileTests extends MainTestBase {


    protected CommonActionsOnMobilePages commonActionsOnMobilePages;
    protected PageElementActions pageElementActions;
    protected MobileAuthPopUpPage mobileAuthPopUpPage;
    protected MobileCartPage mobileCartPage;
    protected MobileCheckOutPage mobileCheckOutPage;
    protected MobileProductCardPage mobileProductCardPage;
    protected MobileMainPage mobileMainPage;
    protected MobileOspPage mobileOspPage;
    protected MobileSberPage mobileSberPage;
    protected MobileThankForTheOrderPage mobileThankForTheOrderPage;
    protected MobileCookiePage mobileCookiePage;
    protected MobileMedicationsCategorysPopUpPage mobileMedicationsCategoryPage;
    protected MobileMyOrdersPage mobileMyOrdersPage;
    protected MobileHeaderBlock mobileHeaderBlock;
    protected MobileBasementBlock mobileBasementBlock;
    protected MobileMainPopUpBlock mobileMainPopUpBlock;
    protected MobilePersonalAccountPage mobilePersonalAccountPage;
    protected MobileChangePasswordPage mobileChangePasswordPage;
    protected MobileFavoritesPage mobileFavoritesPage;
    protected MobilePersonalDataPage mobilePersonalDataPage;
    protected MobileMedicationsCategorysPopUpPage mobileMedicationsCategorysPopUpPage;
    protected MobileMedicationsPage mobileMedicationsPage;
    protected MobileAllergyPage mobileAllergyPage;
    protected MobileCitiesPopUpPage mobileCitiesPopUpPage;
    protected MobileBotConsultantPopUpPage mobileBotConsultantPopUpPage;


    @BeforeEach
    public void PagesInitialization() {
        mobileMainPage = new MobileMainPage(driver);
        commonActionsOnMobilePages = new CommonActionsOnMobilePages(driver);
        pageElementActions = new PageElementActions(driver);
        mobileCheckOutPage = new MobileCheckOutPage(driver);
        mobileCartPage = new MobileCartPage(driver);
        mobileAuthPopUpPage = new MobileAuthPopUpPage(driver);
        mobileProductCardPage = new MobileProductCardPage(driver);
        mobileOspPage = new MobileOspPage(driver);
        mobileSberPage = new MobileSberPage(driver);
        mobileThankForTheOrderPage = new MobileThankForTheOrderPage(driver);
        mobileCookiePage = new MobileCookiePage(driver);
        mobileMedicationsCategoryPage = new MobileMedicationsCategorysPopUpPage(driver);
        mobileMyOrdersPage = new MobileMyOrdersPage(driver);
        mobileHeaderBlock = new MobileHeaderBlock(driver);
        mobileBasementBlock = new MobileBasementBlock(driver);
        mobileMainPopUpBlock = new MobileMainPopUpBlock(driver);
        mobilePersonalAccountPage = new MobilePersonalAccountPage(driver);
        mobileChangePasswordPage = new MobileChangePasswordPage(driver);
        mobileFavoritesPage = new MobileFavoritesPage(driver);
        mobilePersonalDataPage = new MobilePersonalDataPage(driver);
        mobileAllergyPage = new MobileAllergyPage(driver);
        mobileMedicationsPage = new MobileMedicationsPage(driver);
        mobileMedicationsCategorysPopUpPage = new MobileMedicationsCategorysPopUpPage(driver);
        mobileCitiesPopUpPage = new MobileCitiesPopUpPage(driver);
        mobileBotConsultantPopUpPage = new MobileBotConsultantPopUpPage(driver);
    }

}