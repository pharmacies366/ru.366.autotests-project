/*
package mobile.makeorder.authorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

@Feature(value = "Web")
@Story("Покупка дисконтного товар")
@DisplayName("Оформление дисконтного товара в 1клик")
public class DiscountOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар по дисконтной цене в 1клик")
    @Test
    public void discount() {
        mobileMainPage.getPopUpButton().click();
        mobileTopPanelPage.clickBurgerButton();
        mobileTopPanelPage.clickMedicationsButton();
        mobileMedicationsCategoryPage.clickAllergyCategory();
        catalogPage.clickMedicationsButton();
        mobileMedicationsPage.clickMedicationsButton();
        pageActions.waitPageLoad();
        mobileMedicationsPage.clickSomeProduct();
        pageActions.waitPageLoad();
        int usuallyPrice= productCardPage.getPriceValue().formatElementToValue();
        mobileProductCardPage.getDiscountPriceButton().clickIndex(3);
        pageActions.waitPageLoad();
        mobileProductCardPage.getAptekaMap().elementIsVisibility();
        int discountPrice = productCardPage.getPriceValue().formatElementToValue();
        Assert.assertTrue(usuallyPrice > discountPrice);
        mobileProductCardPage.setInputSearchAddres("метро Автозаводская");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickAptekaList();
        pageActions.waitPageLoad();
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        mobileCheckOutPage.clickBookingButton();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }

}
*/
