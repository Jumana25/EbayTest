package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageObjects.AddUserPage;
import org.example.pageObjects.DashboardPage;
import org.junit.Assert;


public class OrangeHRMSteps {

    DashboardPage dashboardPage = new DashboardPage();
    AddUserPage addUserPage = new AddUserPage();

    static String numberOfUsersBeforeCreate = "";
    static String numberOfUsersAfterCreate = "";
    static String numberOfUsersAfterDelete = "";

    @And("I open tab named {string}")
    public void iOpenTabNamed(String tabNAme) {
        dashboardPage.openTab(tabNAme);
    }

    @And("I read the number of existing user records")
    public void iReadTheNumberOfExistingUserRecords() {
        numberOfUsersBeforeCreate = dashboardPage.getNumberOfExistingUsers();
        System.out.println("Number of users found = " + numberOfUsersBeforeCreate);
    }

    @When("I add new user")
    public void iAddNewUser(DataTable dataTable) {
        dashboardPage.clickAddButton();
        addUserPage.fillNewUserDetails(dataTable);
        addUserPage.clickSave();
    }

    @Then("Number of existing users will be increased by 1")
    public void numberOfExistingUsersWillBeIncreasedBy1() {
        numberOfUsersAfterCreate = dashboardPage.getNumberOfExistingUsers();
        System.out.println("Number of users found = " + numberOfUsersAfterCreate);
        Assert.assertEquals(Integer.parseInt(numberOfUsersAfterCreate), (Integer.parseInt(numberOfUsersBeforeCreate) + 1));
    }

    @When("I search for user with username {string}")
    public void iSearchForUserWithUsername(String username) {
        dashboardPage.searchWithUsername(username);
    }

    @And("I delete user {string}")
    public void iDeleteUser(String userName) {
        dashboardPage.deleteUser(userName);
    }

    @And("Reset search")
    public void resetSearch() {
        dashboardPage.clickResetButton();
    }

    @Then("Original number of users will be displayed")
    public void originalNumberOfUsersWillBeDisplayed() {
        numberOfUsersAfterDelete = dashboardPage.getNumberOfExistingUsers();
        Assert.assertEquals(numberOfUsersBeforeCreate, numberOfUsersAfterDelete);
    }


}
