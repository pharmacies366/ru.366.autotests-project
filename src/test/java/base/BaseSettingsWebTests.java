package base;

import actions.PageElementActions;
import blocks.web.WebBasementBlock;
import blocks.web.WebHeaderBlock;
import core.MainTestBase;
import org.junit.Before;
import pages.commonActions.web.CommonActionsOnWebPages;
import pages.web.authorization.AuthPopUpPage;
import pages.web.bonusCard.BonusCardPopUpPage;
import pages.web.botConsultant.BotConsultantPopUpPage;
import pages.web.cart.CartPage;
import pages.web.catalog.CatalogPage;
import pages.web.categories.MedicationsCategoryPage;
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
    protected WebHeaderBlock headerBlock;
    protected WebBasementBlock basementBlock;
    protected PersonalDataPage personalDataPage;
    protected BonusCardPopUpPage bonusCardPopUpPage;
    protected ChangePasswordPage changePasswordPage;
    protected FavoritesPage favoritesPage;
    protected CatalogPage catalogPage;
    protected MedicationsCategoryPage medicationsCategoryPage;
    protected CitiesPopUpPage citiesPopUpPage;
    protected BotConsultantPopUpPage botConsultantPopUpPage;



    @Before
    public void PagesInitialization() {
        commonActionsOnWebPages = new CommonActionsOnWebPages(driver);
        mainPage = new MainPage(driver);
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
        headerBlock = new WebHeaderBlock(driver);
        basementBlock = new WebBasementBlock(driver);
        personalDataPage = new PersonalDataPage(driver);
        bonusCardPopUpPage = new BonusCardPopUpPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        favoritesPage = new FavoritesPage(driver);
        catalogPage = new CatalogPage(driver);
        medicationsCategoryPage = new MedicationsCategoryPage(driver);
        citiesPopUpPage = new CitiesPopUpPage(driver);
        botConsultantPopUpPage = new BotConsultantPopUpPage(driver);
    }

}






