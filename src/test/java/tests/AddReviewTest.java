package tests;


import com.shaft.driver.SHAFT;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddReviewPage;
import pages.HomePage;
import pages.SearchPage;


public class AddReviewTest extends TestBase{
    HomePage homePage;
    SearchPage searchPage;
    AddReviewPage add;
    SHAFT.TestData.JSON reviewData;

    @Test
    public void searchForProduct(){
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.searchForProducts("iphone");
        Assert.assertEquals(searchPage.getFirstProductPageAssertion(),"Search - iphone");
        searchPage.navigateToFirstProduct();
        Assert.assertEquals(searchPage.getFirstProductAssertionMessage(),"iPhone");

    }

    @Test(priority = 1)
    public void addReview() {
        reviewData = new SHAFT.TestData.JSON("reviewData.json");
        add = new AddReviewPage(driver);
        add.moveToReviewFields();
        add.enterReviewData(reviewData.getTestData("name"),reviewData.getTestData("review"));
        Assert.assertEquals(add.getReviewAssertionMessage(),"Thank you for your review. It has been submitted to the webmaster for approval.");
    }
}
