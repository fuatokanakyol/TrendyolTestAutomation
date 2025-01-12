package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;
import utils.ElementHelper;
import java.time.Duration;
import java.util.Set;

public class SearchResultPage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By search_result_text = By.xpath("//div[contains(@class, 'dscrptn')]/h1\n");
    static By search_result_container = By.xpath("//div[@class=\"search-app-container\"]");
    static By first_product = By.xpath("(//div[@class=\"p-card-wrppr with-campaign-view add-to-bs-card\"])[1]");
    static By first_product_price = By.xpath("(//div[@class='product-price']//div[@class='prc-box-dscntd'])[1]");
    static By first_product_description = By.xpath("(//h3[@class='prdct-desc-cntnr-ttl-w']/span[@class='prdct-desc-cntnr-name hasRatings'])[1]");
    static By addToCardButtonForFirstProduct = By.xpath("(//button[@class=\"add-to-basket-button\"])[1]");

    static By second_product = By.xpath("(//div[@class=\"p-card-wrppr with-campaign-view add-to-bs-card\"])[2]");
    static By second_product_price = By.xpath("(//div[@class='product-price']//div[@class='prc-box-dscntd'])[2]");
    static By addToCardButtonForSecondProduct = By.xpath("(//button[@class=\"add-to-basket-button\"])[1]");


    static By priceOnDetailPage = By.xpath("(//span[@class='prc-dsc'])[1]");
    static By description = By.xpath("//div/h1[@class='pr-new-br']/span");
    static By understandButton = By.xpath("//button[@class=\"onboarding-popover__default-renderer-primary-button\"]");
    static By addToBasketButton = By.xpath("//button[@class=\"add-to-basket\"]");

    static By totalPriceOnBasket = By.xpath("//strong[contains(@title, 'TL')]");

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
    public void clickOnFirstProduct(){
        elementHelper.click(first_product);
    }
    public void saveFirstProductInfo(){
        elementHelper.saverMethod(first_product_description, "firstProductDescription");
        elementHelper.saverMethod(first_product_price, "firstProductPrice");
    }
    public void saveSecondProductInfo(){
        elementHelper.saverMethod(second_product_price, "secondProductPrice");
    }
    public void checkFirstProductInfo(){
        elementHelper.checkerMethod(description,"firstProductDescription");
        elementHelper.checkerMethod(priceOnDetailPage,"firstProductPrice");
    }
    public void closeUnderStandButtonIfexist(){
        if (elementHelper.checkElement(understandButton)){
            elementHelper.click(understandButton);
        }
        else {
            Logger.getLogger(getClass()).info("Understand button is not displayed");
        }
    }
    public void switchToNewTab() {
        // Mevcut pencerelerin handle'larını alıyoruz
        Set<String> windowHandles = driver.getWindowHandles();

        // Eğer birden fazla pencere varsa
        if (windowHandles.size() > 1) {
            for (String handle : windowHandles) {
                // Yeni sekme/ pencereyi bulana kadar döngü yapıyoruz
                driver.switchTo().window(handle);
            }
        }
    }
    public void addToBasket() {
        elementHelper.checkElement(addToBasketButton);
        elementHelper.click(addToBasketButton);
    }
    public void addToTwoProductToBasket() throws InterruptedException {
        elementHelper.checkElement(addToCardButtonForFirstProduct);
        elementHelper.waitAndClick(addToCardButtonForFirstProduct);
        elementHelper.checkElement(addToCardButtonForSecondProduct);
        elementHelper.waitAndClick(addToCardButtonForSecondProduct);
    }
    public void checkTotalPriceOnBasket() {

        String x = elementHelper.getValue("firstProductPrice");
        String y = elementHelper.getValue("secondProductPrice");
        double firstProductPrice = Double.parseDouble(x.replace(" TL", "").replace(",", "."));
        double secondProductPrice = Double.parseDouble(y.replace(" TL", "").replace(",", "."));
        double totalPrice = firstProductPrice + secondProductPrice;
        String totalPriceText = driver.findElement(totalPriceOnBasket).getText();
        String cleanedTotalPriceText = totalPriceText.replace(" TL", "").replace(".", "").replace(",", ".");
        double basketTotalPrice = Double.parseDouble(cleanedTotalPriceText);

        Assert.assertEquals(totalPrice, basketTotalPrice, "Toplam fiyat sepetteki fiyat ile eşleşmiyor!");
    }
}
