package mobile.orders.makeorders;

import base.BaseSettingsMobileTests;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature(value = "Мобильная версия")
@Story("Оформление заказа на сайте 36.6")
@DisplayName("Оформление заказа для неавторизованного пользователя")
public class MakeOrdersUnauthorizedMobileTest extends BaseSettingsMobileTests {

    //Отключили на проде, так как формируется реальная заявка на доставку и курьеры едут за заказами

/*    @DisplayName("Оформление заказа доставкой. Неавторизованный пользователь")
    @Test
    public void delivery() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
        mobileCheckOutPage.clickDeliveryMethod();
        mobileCheckOutPage.addressDelivery("Сиреневый бульвар 68", "2", "3", "34");
        mobileCheckOutPage.clickMakeOrder();
        mobileSberPage.bankCardDetails(
                propertiesManager.getProperty("cardnumber"),
                propertiesManager.getProperty("monthyear"),
                propertiesManager.getProperty("cvv"));
        mobileSberPage.clickOnSubmitButton();
        mobileThankForTheOrderPage.checkPaymentError();
    }*/

    @DisplayName("Неавторизованный пользователь покупает товар в 1клик")
    @Test
    public void oneClick() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode4"));
        pageActions.waitPageLoad();
        mobileCartPage.clickProductCard();
        pageActions.waitPageLoad();
        mobileProductCardPage.checkVisibilityMap();
        mobileProductCardPage.setInputSearchAddres("метро Фили");
        mobileProductCardPage.buyOneClick();
        pageActions.waitPageLoad();
        mobileProductCardPage.clickChangeAptekaList();
        mobileProductCardPage.clickBuyOneClick();
        mobileCheckOutPage.setInputOneClickPhoneNumber(propertiesManager.getProperty("phonenumber"));
       // mobileCheckOutPage.clickBookingButton();
       // mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со страниц ОСП")
    @Test
    public void checkOsp() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        pageActions.reloadPage();
        pageActions.waitPageLoad();
        mobileMainPage.clickLetterN();
        pageActions.waitPageLoad();
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
      //  mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь покупает товар со способом доставки - 'Самовывоз'")
    @Test
    public void pickup() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        pageActions.reloadPage();
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.ckickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
     //   mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }

    @DisplayName("Неавторизованный пользователь оформляет заказ содержащий Партнерский товар + Не партнерский")
    @Test
    public void split() {
        mobileCookiePage.reCaptchaKey();
        mobileMainPage.clickClosePopUp();
        mobileMainPage.clickCloseMobileAppPopUp();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode1"));
        mobileCartPage.сlickAddCartButton();
        mobileMainPage.clickSiteLogo();
        mobileHeaderBlock.setSearchInput(propertiesManager.getProperty("productcode2"));
        mobileCartPage.сlickAddCartButton();
        mobileCartPage.clickToCartButton();
        mobileCartPage.clickToMakeOrder();
        mobileCheckOutPage.clickSelectApteka();
        mobileProductCardPage.checkVisibilityMap();
        mobileCheckOutPage.setInputSearchAddres("метро Фили");
        mobileCheckOutPage.clickChangeAptekaList();
        mobileCheckOutPage.ckickSelect();
        pageActions.waitPageLoad();
        mobileCheckOutPage.contactDetails(
                propertiesManager.getProperty("username"),
                propertiesManager.getProperty("phonenumber"),
                propertiesManager.getProperty("usermail"));
     //   mobileCheckOutPage.clickMakeOrder();
      //  mobileThankForTheOrderPage.checkSuccessMessage();
    }
}
