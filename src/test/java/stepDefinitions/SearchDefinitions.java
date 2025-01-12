package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultPage;
import utils.DriverFactory;

public class SearchDefinitions {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage =new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();


    @When("close the first popup")
    public void close_first_visit_modal() {
        homePage.closeTheFirstVisitModal();
    }
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
}
