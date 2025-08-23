package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.pageObjects.LoginPage;
import org.example.utils.JsonUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    String usersFile = "Users.json";

    @Given("I login with {string} user")
    public void iLoginWithUser(String userType) throws IOException, ParseException {
        JSONObject credentialsObject = JsonUtil.getJsonObjectFromFile(usersFile, userType);
        loginPage.login(credentialsObject.get("UserName").toString(), credentialsObject.get("Password").toString());
    }

}
