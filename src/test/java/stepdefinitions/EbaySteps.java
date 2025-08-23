package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pageObjects.EbayHomePage;
import org.example.pageObjects.EbaySearchPage;
import io.cucumber.java.Scenario;

public class EbaySteps {

    private Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    EbayHomePage ebayHomePage = new EbayHomePage();
    EbaySearchPage ebaySearchPage = new EbaySearchPage();

    @Given("I search with {string}")
    public void iSearchWith(String searchString) {
        ebayHomePage.searchWithKeyword(searchString);
    }

    @Then("I should see search results containing all or partial search Keyword {string}")
    public void iShouldSeeSearchResultsContainingAllOrPartialSearchKeyword(String searchKeyword) {
        ebaySearchPage.validateResultsDisplayed(searchKeyword);
    }

    @And("I notice the count of results displayed")
    public void iNoticeTheCountOfResultsDisplayed() {
        this.scenario.log("Results count: " + ebaySearchPage.getDisplayedResultsCount());
    }

    @And("I filter under {string} with {string}")
    public void iFilterUnderWith(String filterName, String filterValue) {
        ebaySearchPage.filterSearchResults(filterName, filterValue);
    }
}
