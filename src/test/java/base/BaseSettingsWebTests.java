package base;

import actions.PageElementActions;
import blocks.web.HeaderBlock;
import core.MainTestBase;
import org.junit.jupiter.api.BeforeEach;
import pages.web.*;
import pages.web.privateOffice.ChangePasswordPage;
import pages.web.privateOffice.FavoritesPage;
import pages.web.privateOffice.PersonalDataPage;

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

/*    protected WebBasementBlock basementBlock;
    protected BonusCardPopUpPage bonusCardPopUpPage;
    protected MedicationsCategoryPage medicationsCategoryPage;
    protected CitiesPopUpPage citiesPopUpPage;
    protected BotConsultantPopUpPage botConsultantPopUpPage;*/






    @BeforeEach
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
        headerBlock = new HeaderBlock(driver);
        changePasswordPage = new ChangePasswordPage(driver);
        favoritesPage = new FavoritesPage(driver);
   /*   basementBlock = new WebBasementBlock(driver);
        personalDataPage = new PersonalDataPage(driver);
        bonusCardPopUpPage = new BonusCardPopUpPage(driver);
        catalogPage = new CatalogPage(driver);
        medicationsCategoryPage = new MedicationsCategoryPage(driver);
        citiesPopUpPage = new CitiesPopUpPage(driver);
        botConsultantPopUpPage = new BotConsultantPopUpPage(driver);
*/
    }

}






