package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;

public class HomePage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By search_input = By.xpath("//input[@data-testid='suggestion']");
    static By search_Button=By.xpath("//i[@data-testid='search-icon'");

    public HomePage(){
        driver = utils.DriverFactory.getDriver();
        elementHelper = new ElementHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void searchSomeValue(String searchItem){
        elementHelper.writeToElement(search_input,searchItem);
        elementHelper.click(search_Button);
    }

}
