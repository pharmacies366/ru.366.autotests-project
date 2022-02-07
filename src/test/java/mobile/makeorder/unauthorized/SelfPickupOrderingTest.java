package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story(value = "оформление заказа самовывозом")
@DisplayName("Оформление заказа самовывозом")
public class SelfPickupOrderingTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        pageActions.waitPageLoad();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.waitPageLoad();
        mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.reloadPage();
        mobileCartPage.сlickAddCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToCartButton();
        pageActions.waitPageLoad();
        mobileCartPage.clickToMakeOrder();
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickChangeAptekaList();
        pageActions.waitPageLoad();
        mobileCheckOutPage.ckickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        pageActions.waitPageLoad();
        mobileCheckOutPage.clickMakeOrder();
        pageActions.waitPageLoad();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }

}
