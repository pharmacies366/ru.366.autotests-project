package base;

import actions.PageElementActions;
import core.MainTestBase;
import org.junit.Before;
import pages.web.*;

public class BaseSettingsWebTests extends MainTestBase {

    protected MainPage mainPage;
    protected PageElementActions pageElementActions;
    protected CookiePage cookiePage;
    protected TopPanelPage topPanelPage;
    protected AuthPopUpPage authPopUpPage;
    protected ProductCardPage productCardPage;
    protected CartPage cartPage;
    protected CheckOutPage checkOutPage;
    protected SberPage sberPage;
    protected ThankForTheOrderPage thankForTheOrderPage;
    protected OspPage ospPage;
 /*
    protected CatalogPage catalogPage;
    protected MedicationsPage medicationsPage;*/


    @Before
    public void PagesInitialization() {
        mainPage = new MainPage(driver);
        pageElementActions = new PageElementActions(driver);
        cookiePage = new CookiePage(driver);
        topPanelPage = new TopPanelPage(driver);
        authPopUpPage = new AuthPopUpPage(driver);
        productCardPage = new ProductCardPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        sberPage = new SberPage(driver);
        thankForTheOrderPage = new ThankForTheOrderPage(driver);
        ospPage = new OspPage(driver);
   /*
        catalogPage = new CatalogPage(driver);
        medicationsPage = new MedicationsPage(driver);*/

    }

}






