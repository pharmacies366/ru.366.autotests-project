package mobile.makeorder.unauthorized;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Пользователь покупает товар со страницы ОСП")
@DisplayName("Оформление товара со страниц ОСП")
public class OspProductListTest extends BaseSettingsMobileTests {

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        mobileMainPage.clickLetterN();
        mobileOspPage.clickShowAll();
        mobileOspPage.clickProductName();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        mobileCheckOutPage.clickSelectApteka();
        mobileCheckOutPage.setInputSearchAddres("метро Автозаводская");//возможно нужно кликнуть в пустое место
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.ckickSelect();
        mobileCheckOutPage.clickMakeOrder();
        mobileThankForTheOrderPage.checkSuccessMessage();
    }
}
