package tests;


import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToWishListPage;
import pages.HomePage;
import pages.RegisterPage;
import pages.SearchPage;



public class AddToWishListTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    SHAFT.TestData.JSON registerData;
    SearchPage searchPage;
    AddToWishListPage add;

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
    public void navigateToProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("iphone");
        Assert.assertEquals(searchPage.getFirstProductPageAssertion(),"Search - iphone");
        searchPage.navigateToFirstProduct();
        Assert.assertEquals(searchPage.getFirstProductAssertionMessage(),"iPhone");
    }

    @Test(priority = 3)
    public void addProductToWishList(){
        add = new AddToWishListPage(driver);
        add.addToWishList();
        Assert.assertEquals(add.getFirstProductAddedToWishListAssertionMessage(),"product 11");
    }

}
