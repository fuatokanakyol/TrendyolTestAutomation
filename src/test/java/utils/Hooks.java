package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

import java.util.Properties;

public class Hooks {
    WebDriver driver;
    Properties properties;
    HomePage homePage;

    @Before
    public void before() {
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver();
        homePage = new HomePage();
        homePage.closeTheFirstVisitModal();
    }
    @After
    public void after() {
        driver.quit();
    }
}