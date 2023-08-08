package tests;

import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;



public class LoginTest extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;
    String currentTime = String.valueOf(System.currentTimeMillis());
    LoginPage loginPage;
    SHAFT.TestData.JSON registerData;

    @Test
    public void navigateToRegisterPage(){
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        registerPage = new RegisterPage(driver);
        Assert.assertEquals(registerPage.getRegisterPageAssertionMessage(),"Register Account");
    }

    @Test(priority = 1)
    public void enterRegisterData() {
        registerData = new SHAFT.TestData.JSON("registerData.json");
        registerPage = new RegisterPage(driver);

        registerPage.enterRegisterData(registerData.getTestData("firstName"),registerData.getTestData("lastName"),
                registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("telephone"),registerData.getTestData("password"));
        Assert.assertEquals(registerPage.getSuccessfulRegisterMessage(),"Your Account Has Been Created!");

    }

    @Test(priority = 2)
    public void logOutAndNavigateToLogin(){
        homePage = new HomePage(driver);
        homePage.logOut();
        homePage.navigateToLoginPage();
        loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginPageAssertionMessage(),"New Customer");
    }

    @Test(priority = 3)
    public void login() {
        registerData = new SHAFT.TestData.JSON("registerData.json");
        loginPage = new LoginPage(driver);
        loginPage.enterLoginData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("password"));
        Assert.assertEquals(loginPage.getSuccessfulLoginAssertionMessage(),"My Account");
    }
}
