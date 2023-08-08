package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddReviewPage {
    private final SHAFT.GUI.WebDriver driver;
    public AddReviewPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By addReviewButton = By.linkText("Write a review");
    private final By nameTxt = By.id("input-name");
    private final By reviewTxt = By.id("input-review");
    private final By rateButton = By.xpath("//input[@value='3']");
    private final By submitButton = By.id("button-review");
    private final By reviewAssertion = By.xpath("//div[@class='alert alert-success alert-dismissible']");


    public void moveToReviewFields(){
        driver.element().click(addReviewButton);
    }

    public void enterReviewData(String name, String review){
       driver.element().type(nameTxt,name);
       driver.element().type(reviewTxt,review);
       driver.element().click(rateButton);
       driver.element().click(submitButton);
    }

    public String getReviewAssertionMessage(){
        return driver.element().getText(reviewAssertion);
    }
}
