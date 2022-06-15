package base;

import actions.PageElementActions;
import blocks.web.HeaderBlock;
import core.MainTestBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.commonActions.web.CommonActionsOnWebPages;
import pages.web.authorization.AuthPopUpPage;
import pages.web.bonusCard.BonusCardPopUpPage;
import pages.web.botConsultant.BotConsultantPopUpPage;
import pages.web.cart.CartPage;
import pages.web.catalog.CatalogPage;
import pages.web.checkout.CheckOutPage;
import pages.web.cities.CitiesPopUpPage;
import pages.web.cookie.CookiePage;
import pages.web.main.MainPage;
import pages.web.orders.MyOrdersPage;
import pages.web.osp.OspPage;
import pages.web.privateOffice.ChangePasswordPage;
import pages.web.privateOffice.FavoritesPage;
import pages.web.privateOffice.PersonalDataPage;
import pages.web.product.ProductCardPage;
import pages.web.sber.SberPage;
import pages.web.thanks.ThankForTheOrderPage;

public class BaseSettingsWebTests extends MainTestBase {

    protected CommonActionsOnWebPages commonActionsOnWebPages;
    protected MainPage mainPage;
    protected PageElementActions pageElementActions;
    protected CookiePage cookiePage;
    protected AuthPopUpPage authPopUpPage;
    protected ProductCardPage productCardPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected SberPage sberPage;
    protected ThankForTheOrderPage thankForTheOrderPage;
    protected OspPage ospPage;
    protected MyOrdersPage myOrdersPage;

    protected PersonalDataPage personalDataPage;

    protected HeaderBlock headerBlock;
    protected ChangePasswordPage changePasswordPage;
    protected FavoritesPage favoritesPage;
    protected CatalogPage catalogPage;
    protected BotConsultantPopUpPage botConsultantPopUpPage;

    protected BonusCardPopUpPage bonusCardPopUpPage;
    /*    protected WebBasementBlock basementBlock;

        protected MedicationsCategoryPage medicationsCategoryPage;*/
    protected CitiesPopUpPage citiesPopUpPage;


    @BeforeEach
    public void PagesInitialization() {
        mainPage = new MainPage(driver);
        actionsBeforeTests();

        commonActionsOnWebPages = new CommonActionsOnWebPages(driver);
        pageElementActions = new PageElementActions(driver);
        cookiePage = new CookiePage(driver);
        authPopUpPage = new AuthPopUpPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        sberPage = new SberPage(driver);
        thankForTheOrderPage = new ThankForTheOrderPage(driver);
        ospPage = new OspPage(driver);
        myOrdersPage = new MyOrdersPage(driver);
        headerBlock = new HeaderBlock(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        favoritesPage = new FavoritesPage(driver);
        botConsultantPopUpPage = new BotConsultantPopUpPage(driver);
        personalDataPage = new PersonalDataPage(driver);
        bonusCardPopUpPage = new BonusCardPopUpPage(driver);
        catalogPage = new CatalogPage(driver);
        citiesPopUpPage = new CitiesPopUpPage(driver);
     /*   medicationsCategoryPage = new MedicationsCategoryPage(driver);
        basementBlock = new WebBasementBlock(driver);*/
    }

    //данный метод выполняется перед каждым тестом
    protected void actionsBeforeTests() {
        mainPage.clickClosePopUp();
    }

    @AfterEach
    public void pagesClose() {
        driver.close();
    }
}






