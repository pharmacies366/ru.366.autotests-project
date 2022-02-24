package base;

import actions.PageElementActions;
import blocks.web.BasementBlock;
import blocks.web.HeaderBlock;
import core.MainTestBase;
import org.junit.jupiter.api.BeforeEach;
import pages.web.*;

public class BaseSettingsWebTests extends MainTestBase {

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
    protected HeaderBlock headerBlock;
    protected BasementBlock basementBlock;



    @BeforeEach
    public void PagesInitialization() {
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
        basementBlock = new BasementBlock(driver);

    }

}






