package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.HomePage;
import pages.SearchResultPage;
import utils.DriverFactory;

public class SearchDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage =new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    BasketPage basketPage = new BasketPage();

    @When("Search for a product called {string} using the search bar.")
    public void click_search_button(String searchItem) {
        homePage.searchSomeValue(searchItem);

    }
    @When("Verify that the search results are displayed.")
    public void writeToSearchInput() {
        searchResultPage.checkSearchResultPage();
    }

    @Then("Validate that the results contain the searched keyword.")
    public void checkText() {
        searchResultPage.checkResultText("kablosuz kulaklik");
    }

    @When("From the search results, click on a product to open its details page.")
    public void clickOnFirstProduct() {
        searchResultPage.saveFirstProductInfo();
        searchResultPage.clickOnFirstProduct();
    }
    @Then("Verify that the product name, price, and availability status are displayed correctly.")
    public void checkFirstProductName() {
        searchResultPage.switchToNewTab();
        searchResultPage.closeUnderStandButtonIfexist();
        searchResultPage.checkFirstProductInfo();
    }
    @When("Add the selected product to the cart.")
    public void clickAddToBasket() throws InterruptedException {
        searchResultPage.saveFirstProductInfo();
        searchResultPage.switchToNewTab();
        searchResultPage.closeUnderStandButtonIfexist();
        searchResultPage.addToBasket();
    }

    @Then("Verify that the product appears in the cart with the correct details")
    public void checkProductInBasket() throws InterruptedException {
        homePage.goToBasket();
        basketPage.checkFirstProductInfo();
    }

    @When("Add multiple items to the cart.")
    public void addMultipleItemsToCart() throws InterruptedException {
        searchResultPage.saveFirstProductInfo();
        searchResultPage.saveSecondProductInfo();
        searchResultPage.switchToNewTab();
        searchResultPage.addToTwoProductToBasket();
    }
    @Then("Verify that the total price in the cart matches the sum of individual product prices.")
    public void checkTotalPrice() throws InterruptedException {
        homePage.goToBasket();
        searchResultPage.checkTotalPriceOnBasket();
    }

    @When("Remove an item from the cart.")
    public void removeItemFromCart() throws InterruptedException {
        homePage.goToBasket();
        basketPage.clickToAnladimButton();
        basketPage.removeFirstProduct();
    }
    @Then("Verify that the item is no longer listed in the cart and that the total price is updated correctly.")
    public void checkItemIsRemoved() throws InterruptedException {
        basketPage.checkTheBasketIsEmpty();
    }
}
