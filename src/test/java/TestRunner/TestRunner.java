package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summary", "html:target/cucumber", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
        tags = "@AllTest",
        features = "src/test/resources/Features",
        glue = "Test"
)
public class TestRunner {
}
