package tests;

import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOuTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    SearchPage searchPage;
    AddToCartPage add;
    CheckoutPage checkoutPage;
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON checkData;
    String currentTime = String.valueOf(System.currentTimeMillis());


    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getRegisterPageAssertionMessage(),"Register Account");
    }

    @Test(priority = 1)
    public void enterRegisterData(){
        registerData = new SHAFT.TestData.JSON("registerData.json");
        registerPage = new RegisterPage(driver);

        registerPage.enterRegisterData(registerData.getTestData("firstName"),registerData.getTestData("lastName"),
                registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("telephone"),registerData.getTestData("password"));
        Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(),"Your Account Has Been Created!");

    }
    @Test(priority = 2)
    public void searchForSecondProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("mac");
        Assert.assertEquals(searchPage.getSecondProductPageAssertion(),"Search - mac");
        searchPage.ProductToBeCheckedOut();
    }

    @Test(priority = 3)
    public void addSecondProductToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
    }

    @Test(priority = 4)
    public void navigateAndEnterAddressDetails(){
        checkData = new SHAFT.TestData.JSON("checkoutData.json");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.navigateToCheckOutPage();
        checkoutPage.enterAddressDetails(checkData.getTestData("firstName"),checkData.getTestData("lastName"),
                checkData.getTestData("company"),checkData.getTestData("addressOne"),
                checkData.getTestData("addressTow"),
                        checkData.getTestData("city"),
                checkData.getTestData("postCode"),checkData.getTestData("country"),
                checkData.getTestData("region"));
    }
    @Test(priority = 5)
    public void completeCheckOut(){
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.setConfirmShoppingAddress();
        checkoutPage.setConfirmShoppingMethode();
        checkoutPage.setConfirmPaymentMethode();
        checkoutPage.confirmOrder();
        Assert.assertEquals(checkoutPage.getAssertionMessage(),"Your order has been placed!");
    }
}
