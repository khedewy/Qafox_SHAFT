package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddToWishListPage {
    private final SHAFT.GUI.WebDriver driver;
    public AddToWishListPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By addToWishListButton = By.xpath("//button[@data-original-title='Add to Wish List']");
    private final By showWishList = By.linkText("wish list");
    private final By firstProductAddedToWishListAssertionMessage = By.xpath("//td[text()='product 11']");


    public void addToWishList(){
        driver.element().click(addToWishListButton);
        driver.element().click(showWishList);
    }

    public String getFirstProductAddedToWishListAssertionMessage(){
        return driver.element().getText(firstProductAddedToWishListAssertionMessage);
    }

}


