package testRunner;

//import io.cucumber.junit.platform.engine.Cucumber;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.util.stream.Stream;

//@Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"
        },
        monochrome = true
)
public class TestRunner {
    // This class will automatically pick up Cucumber features and generate reports in the target directory.

}
