package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import base.BaseSettingsWebTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;

@Feature(value = "Мобильная версия")
@Story(value = "Покупка в 1 клик")
@DisplayName("Оформление основного товара в 1 клик")
public class OneClickPurchaseTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        openUrl(propertiesManager.getProperty("baseurl") + "p/29992");
        //mobileMainPage.setSearchInput(propertiesManager.getProperty("productcode1"));
       // mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        pageElementActions.scrollElementIntoView(By.xpath("(//span[contains(@class,'product_price__val')])[1]"));
       // mobileMainPage.clickClosePopUp();
        mobileProductCardPage.buyOneClick();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
        //mobileCheckOutPage.clickBookingButton();
       // pageActions.waitPageLoad();
       // mobileThankForTheOrderPage.checkSuccessMessage();
    }


}
