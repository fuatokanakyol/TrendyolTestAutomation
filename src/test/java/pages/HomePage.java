package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import utils.ElementHelper;
import java.time.Duration;

public class HomePage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By search_input = By.xpath("//input[@data-testid='suggestion']");
    static By search_Button=By.xpath("//i[@data-testid='search-icon']");
    static By modal_close_button = By.xpath("//div[@class=\"modal-close\"]");
    static By myBasketButton = By.xpath("//a[@class=\"link account-basket\"]");

    public HomePage(){
        driver = utils.DriverFactory.getDriver();
        elementHelper = new ElementHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void searchSomeValue(String searchItem){
        elementHelper.writeToElement(search_input, searchItem);
        elementHelper.click(search_Button);
    }
    public void closeTheFirstVisitModal(){
        if (elementHelper.checkElement(modal_close_button)){
            elementHelper.click(modal_close_button);
        }
        else {
            Logger.getLogger(getClass()).info("Modal is not displayed");
        }
    }
    public void goToBasket() throws InterruptedException {
        elementHelper.waitAndClick(myBasketButton);
    }
}
