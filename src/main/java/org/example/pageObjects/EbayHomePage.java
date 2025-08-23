package org.example.pageObjects;

import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EbayHomePage {

    SeleniumActions seleniumActions = new SeleniumActions();

    By SEARCH_FIELD_TXT = By.id("gh-ac");

    public void searchWithKeyword(String searchString){
        seleniumActions.writeInELement(SEARCH_FIELD_TXT, searchString, 5);
        seleniumActions.keyPress(SEARCH_FIELD_TXT, Keys.ENTER);
    }
}
