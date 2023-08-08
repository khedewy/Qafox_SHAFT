package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class CheckoutPage {
    private final SHAFT.GUI.WebDriver driver;


    public CheckoutPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By checkOutButton = By.xpath("//a[text()='Checkout']");
    private final By firstNameTxt = By.id("input-payment-firstname");
    private final By lasNameTxt = By.id("input-payment-lastname");
    private final By companyTxt = By.id("input-payment-company");
    private final By addressOneTxt = By.id("input-payment-address-1");
    private final By addressTowTxt = By.id("input-payment-address-2");
    private final By cityTxt = By.id("input-payment-city");
    private final By postCodeTxt = By.id("input-payment-postcode");
    private final By countryTxt = By.id("input-payment-country");
    private final By regionTxt = By.id("input-payment-zone");
    private final By confirmAddress = By.id("button-payment-address");
    private final By confirmShippingAddress = By.id("button-shipping-address");
    private final By confirmShippingMethode = By.id("button-shipping-method");
    private final By agreeServices = By.name("agree");
    private final By confirmPaymentMethode = By.id("button-payment-method");
    private final By confirmOrder = By.id("button-confirm");
    private final By assertionMessage = By.xpath("//h1[text()='Your order has been placed!']");



    public void navigateToCheckOutPage(){
        driver.element().click(checkOutButton);
    }

    public void enterAddressDetails(String firstName, String lastName,
                                     String company, String address1, String address2,
                                     String city, String postCode, String country, String region){

        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lasNameTxt,lastName);
        driver.element().type(companyTxt,company);
        driver.element().type(addressOneTxt,address1);
        driver.element().type(addressTowTxt,address2);
        driver.element().type(cityTxt,city);
        driver.element().type(postCodeTxt,postCode);
        driver.element().select(countryTxt,country);
        driver.element().select(regionTxt,region);
        driver.element().click(confirmAddress);

    }

    public void setConfirmShoppingAddress(){
        driver.element().click(confirmShippingAddress);
    }

    public void setConfirmShoppingMethode(){
        driver.element().click(confirmShippingMethode);
    }

    public void setConfirmPaymentMethode(){
        driver.element().click(agreeServices);
        driver.element().click(confirmPaymentMethode);
    }

    public void confirmOrder(){
        driver.element().click(confirmOrder);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
