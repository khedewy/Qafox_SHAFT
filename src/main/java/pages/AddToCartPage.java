package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddToCartPage {

    private final SHAFT.GUI.WebDriver driver;
    public AddToCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By addToCartButton = By.id("button-cart");
    private final By showCartButton = By.linkText("shopping cart");
    private final By continueShoppingButton = By.linkText("Continue Shopping");


    private final By firstProductAddedToCartAssertionMessage = By.xpath("//td[text()='product 11']");
    private final By secondProductAddedToCartAssertionMessage = By.xpath("//td[text()='Product 14']");

    public void addProductToCart(){
        driver.element().click(addToCartButton);
        driver.element().click(showCartButton);
    }

    public void ContinueShopping(){
        driver.element().click(continueShoppingButton);
    }

    public String getFirstProductAddedToCartAssertionMessage(){
        return driver.element().getText(firstProductAddedToCartAssertionMessage);
    }

    public String getSecondProductAddedToCartAssertionMessage(){
        return driver.element().getText(secondProductAddedToCartAssertionMessage);
    }
}
