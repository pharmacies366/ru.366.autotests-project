/*
package web.makeorder.authorized;

import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story("Покупка дисконтного товар")
@DisplayName("Оформление дисконтного товара в 1клик")
public class DiscountOrderingTest extends BaseSettingsWebTests {

    @DisplayName("Неавторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        mainPage.getPopUpButton().click();
        cookiePage.cookieAuthorization();
        cartPage.checkCartQuantity();
        mainPage.checkCatalogButton();
        catalogPage.clickMedicationsButton();
        medicationsPage.clickMedicationsButton();
        pageActions.waitPageLoad();
        medicationsPage.clickSomeProduct();
        pageActions.waitPageLoad();
        int usuallyPrice= productCardPage.getPriceValue().formatElementToValue();
        productCardPage.getDiscountPriceButton().clickIndex(3);
        pageActions.waitPageLoad();
        productCardPage.getAptekaMap().elementIsVisibility();
        int discountPrice = productCardPage.getPriceValue().formatElementToValue();
        Assert.assertTrue(usuallyPrice > discountPrice);
        productCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        productCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        productCardPage.buyOneClick();
        pageActions.waitPageLoad();
        productCardPage.clickBuyOneClick();
        checkOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        checkOutPage.clickBookingButton();
        pageActions.waitPageLoad();
        thankForTheOrderPage.checkSuccessMessage();
        cookiePage.deleteAllCookie();
    }

}
*/
