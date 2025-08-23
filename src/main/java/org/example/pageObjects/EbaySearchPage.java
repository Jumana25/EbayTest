package org.example.pageObjects;

import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.Assert.assertTrue;

public class EbaySearchPage {

    SeleniumActions seleniumActions = new SeleniumActions();

    By SEARCH_RESULT_ITEM = By.xpath("//*[contains(@class, 'text primary default')]");
    By RESULTS_COUNT_LBL = By.xpath("//*[@class='srp-controls__count-heading']/span[1]");
    String FILTER_CHK = "//*[text()='@FilterName']/following::*[text()='@FilterValue']/preceding::input[1]";

    public String getDisplayedResultsCount() {
        return seleniumActions.getElementText(RESULTS_COUNT_LBL);
    }

    public void filterSearchResults(String filterName, String filterValue){
//        seleniumActions.clickOnElement(By.xpath(FILTER_CHK.replace("@FilterName", filterName).replace("@FilterValue", filterValue)), 15);
        seleniumActions.clickOnElement2(By.xpath(FILTER_CHK.replace("@FilterName", filterName).replace("@FilterValue", filterValue)));
    }

    public void validateResultsDisplayed(String searchKeyword) {

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> results = seleniumActions.getListOfElements(SEARCH_RESULT_ITEM);

        // Assert first and last items displayed contain part or all of the search string
        assertAll("Search results validation",
                () -> assertFalse("Results expected but not found.", results.isEmpty()),
                () -> assertTrue("First result should contain Mazda or MX-5",
                        results.get(0).getText().toLowerCase().contains((searchKeyword.contains(" ") ? searchKeyword.substring(0, searchKeyword.indexOf(" ")) : searchKeyword).toLowerCase()) || results.get(0).getText().toLowerCase().contains((searchKeyword.contains(" ") ? searchKeyword.substring(searchKeyword.indexOf(" ") + 1) : searchKeyword).toLowerCase())
                ),
                () -> assertTrue("Last result should contain Mazda or MX-5",
                        results.get(results.size() - 1).getText().toLowerCase().contains((searchKeyword.contains(" ") ? searchKeyword.substring(0, searchKeyword.indexOf(" ")) : searchKeyword).toLowerCase()) || results.get(results.size() - 1).getText().toLowerCase().contains((searchKeyword.contains(" ") ? searchKeyword.substring(searchKeyword.indexOf(" ") + 1) : searchKeyword).toLowerCase())
                )
        );
    }
}
