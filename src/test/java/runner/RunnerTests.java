package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/testsBBC.feature", "src/main/resources/testsLoremipsum.feature"},
        glue = "stepdefinitions"
)
public class RunnerTests {



}
