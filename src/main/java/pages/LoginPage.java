package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By loginPageAssertionMessage = By.xpath("//h2[text()='New Customer']");
    private final By emailTxt = By.id("input-email");
    private final By passwordTxt = By.id("input-password");
    private final By loginButton = By.xpath("//input[@value='Login']");
    private final By LoginSuccessfullyMessage = By.xpath("//h2[text()='My Account']");

    public String getLoginPageAssertionMessage(){
        return driver.element().getText(loginPageAssertionMessage);
    }

    public void enterLoginData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(loginButton);
    }
    public String getSuccessfulLoginAssertionMessage(){
        return driver.element().getText(LoginSuccessfullyMessage);
    }
}
