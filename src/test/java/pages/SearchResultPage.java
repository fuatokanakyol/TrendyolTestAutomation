package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementHelper;

import java.time.Duration;

public class SearchResultPage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By search_result_text = By.xpath("//div[contains(@class, 'dscrptn')]/h1\n");
    static By search_result_container = By.xpath("//div[@class=\"search-app-container\"]");


    public SearchResultPage(){
        driver = utils.DriverFactory.getDriver();
        elementHelper = new ElementHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void checkSearchResultPage(){
        elementHelper.checkElement(search_result_container);
    }

    public void checkResultText(String searchItem){
        elementHelper.checkText(search_result_text, searchItem);
    }
}
