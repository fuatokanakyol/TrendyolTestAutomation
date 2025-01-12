package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import utils.ElementHelper;

import java.time.Duration;
import java.util.Set;

public class BasketPage {
    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By basketPagePrice = By.xpath("//div[@class=\"pb-basket-item-price\"]");
    static By remove_first_product_Button = By.xpath("//i[@class=\"i-trash\"]");
    static By understandButton = By.xpath("//button[text()='Anladım']");
    static By messagesForEmptyBasket = By.xpath("//div[i[contains(@class, 'i-bagg')]]/span");

    public BasketPage(){
        driver = utils.DriverFactory.getDriver();
        elementHelper = new ElementHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void checkFirstProductInfo(){
        elementHelper.checkerMethod(basketPagePrice,"firstProductPrice");
    }

    public void removeFirstProduct()  {
        elementHelper.click(remove_first_product_Button);
        driver.navigate().refresh(); // Sayfayı yeniler

    }

    public void checkTheBasketIsEmpty() {

        elementHelper.checkText(messagesForEmptyBasket, "Sepetinizde ürün bulunmamaktadır.");
    }
    public void clickToAnladimButton() throws InterruptedException {
        if (elementHelper.checkElement(understandButton)){
            elementHelper.waitAndClick(understandButton);
        }
        else {
            Logger.getLogger(getClass()).info("Understand button is not displayed");
        }

    }
}
