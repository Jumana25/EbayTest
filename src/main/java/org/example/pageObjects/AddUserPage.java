package org.example.pageObjects;

import io.cucumber.datatable.DataTable;
import org.example.utils.JsUtil;
import org.example.utils.SeleniumActions;
import org.openqa.selenium.By;

import java.util.Map;

public class AddUserPage {

    SeleniumActions seleniumActions = new SeleniumActions();
    JsUtil jsUtil = new JsUtil();

    private final By USER_ROLE_DDL = By.xpath("(//*[contains(text(), 'User Role')]/following::*[text()='-- Select --'])[1]");
    private final By STATUS_DDL = By.xpath("(//*[contains(text(), 'Status')]/following::*[text()='-- Select --'])[1]");
    private final String DDL_OPTION = "//*[@role='option']/*[text()='@Txt']";
    private final String Text_FIELD = "(//label[normalize-space()='@Txt']/following::input)[1]";
    private final By SAVE_BTN = By.xpath("//button[normalize-space()='Save']");
    private final String EMPLOYEE_NAME_SUGGESTION = "//*[text()='@Txt']";
    private final By USERNAME_ERROR_MESSAGE = By.xpath("//*[text()='Should be at least 5 characters']");

    public void fillNewUserDetails(DataTable dataTable) {
        Map<String, String> userDetails = dataTable.asMap(String.class, String.class);

        seleniumActions.clickOnElement(USER_ROLE_DDL, 20);
        seleniumActions.clickOnElement(By.xpath(DDL_OPTION.replace("@Txt", userDetails.get("User Role"))), 20);

        seleniumActions.clickOnElement(STATUS_DDL, 20);
        seleniumActions.clickOnElement(By.xpath(DDL_OPTION.replace("@Txt", userDetails.get("Status"))), 20);

        seleniumActions.writeInELement(By.xpath(Text_FIELD.replace("@Txt", "Employee Name")), userDetails.get("Employee Name"), 20);
        seleniumActions.clickOnElement(By.xpath(EMPLOYEE_NAME_SUGGESTION.replace("@Txt", userDetails.get("Employee Name"))));

        seleniumActions.writeInELement(By.xpath(Text_FIELD.replace("@Txt", "Username")), userDetails.get("Username"), 20);
        seleniumActions.waitForElementToBeGone(USERNAME_ERROR_MESSAGE, 20);

        seleniumActions.writeInELement(By.xpath(Text_FIELD.replace("@Txt", "Password")), userDetails.get("Password"), 20);
        seleniumActions.writeInELement(By.xpath(Text_FIELD.replace("@Txt", "Confirm Password")), userDetails.get("Password"), 20);
    }

    public void clickSave(){
        seleniumActions.clickOnElement(SAVE_BTN, 10);
        jsUtil.waitForDocumentReady(30);
    }

}
