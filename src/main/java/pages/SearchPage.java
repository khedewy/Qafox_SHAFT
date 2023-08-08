package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class SearchPage {
    private final SHAFT.GUI.WebDriver driver;
    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By FirstProductPageAssertion = By.xpath("//h1[text()='Search - iphone']");
    private final By firstProduct = By.linkText("iPhone");
    private final By firstProductAssertion = By.xpath("//h1[text()='iPhone']");
    private final By secondProduct = By.linkText("iMac");
    private final By secondProductAssertionMessage = By.xpath("//h1[text()='iMac']");
    private final By SecondProductPageAssertion = By.xpath("//h1[text()='Search - mac']");
    private final By thirdProduct = By.linkText("MacBook Air");




    public String getFirstProductPageAssertion(){
        return driver.element().getText(FirstProductPageAssertion);
    }

    public void navigateToFirstProduct(){
        driver.element().click(firstProduct);
    }
    public String getFirstProductAssertionMessage(){
        return driver.element().getText(firstProductAssertion);
    }

    public String getSecondProductPageAssertion(){
        return driver.element().getText(SecondProductPageAssertion);
    }
    public void navigateToSecondProduct(){
        driver.element().click(secondProduct);
    }

    public String getSecondProductAssertionMessage(){
        return driver.element().getText(secondProductAssertionMessage);
    }

    public void ProductToBeCheckedOut(){
        driver.element().click(thirdProduct);
    }

}
