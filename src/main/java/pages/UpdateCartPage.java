package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class UpdateCartPage {
    private final SHAFT.GUI.WebDriver driver;
    public UpdateCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By quantityBox = By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > input");
    private final By updateButton = By.xpath("//button[@data-original-title='Update']");
    private final By UpdateAssertionMessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private final By deleteProduct = By.xpath("//button[@data-original-title='Remove']");
    private final By deleteAssertion = By.xpath("//h1[text()='Shopping Cart']");

    public void updateQuantity(String quantity){
        driver.element().clear(quantityBox);
        driver.element().type(quantityBox,quantity);
        driver.element().click(updateButton);
    }

    public String getUpdatedQuantityAssertionMessage(){
       return driver.element().getText(UpdateAssertionMessage);
    }

    public void deleteProduct(){
        driver.element().click(deleteProduct);
    }

    public String getDeletedProductAssertionMessage(){
        return driver.element().getText(deleteAssertion);
    }
}
