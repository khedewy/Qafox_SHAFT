package tests;

import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class TestBase {
    public static SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://tutorialsninja.com/demo/");

    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
