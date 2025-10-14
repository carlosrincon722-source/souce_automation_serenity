package starter.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "starter.stepdefinitions"
        ,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "timeline:build/test-results/timeline",
                "io.cucumber.core.plugin.SerenityReporterParallel"
        })
public class RunnerTest {
}
