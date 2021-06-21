package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features= "src/test/resources/features/manualRegistration.feature", glue={"stepDefinition"},dryRun = false,plugin = { "pretty" }, snippets = SnippetType.CAMELCASE)
public class TestRunner {
	
}
