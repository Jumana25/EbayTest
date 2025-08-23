package stepdefinitions;

import io.cucumber.java.en.Given;
import org.example.utils.BrowserActions;

public class BrowserSteps {

    BrowserActions browserActions = new BrowserActions();

    @Given("I open url {string}")
    public void iOpenUrl(String url) {
        browserActions.openURL(url);
    }

}
