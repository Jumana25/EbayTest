package org.example.pageObjects;

import org.example.utils.JsUtil;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

public class DashboardPage {

    SeleniumActions seleniumActions = new SeleniumActions();
    JsUtil jsUtil = new JsUtil();

    private final String TAB = "//*[contains(@class, 'main-menu-item') and text()='@Txt']";
    private final By EXISTINGUSERSNUMBER_TXT = By.xpath("//span[contains(normalize-space(.), 'Records Found')]");
    private final By ADD_BTN = By.xpath("//button[normalize-space()='Add']");
    private final By USERNAME_SEARCH_FIELD = By.xpath("(//label[text()='Username']/following::input)[1]");
    private final By SEARCH_BTN = By.xpath("//button[normalize-space()='Search']");
    private final String USER_CHECKBOX = "(//*[text()='@Txt']/preceding::*[contains(@class, 'checkbox-input-icon')])[last()]/..";
    private final By DELETE_USER_BTN = By.xpath("//*[normalize-space()='Delete Selected']");
    private final By DELETE_USER_CONFIRMATION_BTN = By.xpath("//*[normalize-space()='Yes, Delete']");
    private final By RESET_BTN = By.xpath("//button[normalize-space()='Reset']");

    public void openTab(String tabName) {
        seleniumActions.clickOnElement(By.xpath(TAB.replace("@Txt", tabName)));
        jsUtil.waitForDocumentReady(seleniumActions.getTimeout(30));
    }

    public String getNumberOfExistingUsers() {
        return seleniumActions.getPatternFromElementText(EXISTINGUSERSNUMBER_TXT, "\\d+", 15);
    }

    public void clickAddButton() {
        seleniumActions.clickOnElement(ADD_BTN, 20);
    }
    public void clickResetButton() {
        seleniumActions.clickOnElement(RESET_BTN, 20);
    }

    public void searchWithUsername(String userName) {
        seleniumActions.writeInELement(USERNAME_SEARCH_FIELD, userName, 20);
        seleniumActions.clickOnElement(SEARCH_BTN, 20);
    }

    public void deleteUser(String userName) {
        seleniumActions.clickOnElement(By.xpath(USER_CHECKBOX.replace("@Txt", userName)), 20);
        seleniumActions.clickOnElement(DELETE_USER_BTN, 20);
        seleniumActions.clickOnElement(DELETE_USER_CONFIRMATION_BTN, 20);
    }


}
