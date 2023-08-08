package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class HomePage {

    private final
    SHAFT.GUI.WebDriver driver;


    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By accountManager = By.xpath("//a[@title='My Account']");
    private final By registerButton = By.xpath("//a[text()='Register']");
    private final By logoutButton = By.linkText("Logout");
    private final By loginButton = By.linkText("Login");
    private final By searchBox = By.name("search");
    private final By searchButton = By.xpath("//button[@class='btn btn-default btn-lg']");

    public RegisterPage navigateToRegisterPage(){
        driver.element().click(accountManager);
        driver.element().click(registerButton);
        return new RegisterPage(driver);
    }

    public void logOut(){
        driver.element().click(accountManager);
        driver.element().click(logoutButton);
    }

    public LoginPage navigateToLoginPage(){
        driver.element().click(accountManager);
        driver.element().click(loginButton);
        return new LoginPage(driver);
    }

    public SearchPage searchForProducts(String product){
        driver.element().type(searchBox,product);
        driver.element().click(searchButton);
        return new SearchPage(driver);
    }
}
