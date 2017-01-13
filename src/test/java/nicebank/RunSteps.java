package nicebank;

import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import config.TestConfiguration;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber"},
		snippets = SnippetType.CAMELCASE,
		features = "classpath:cucumber",
		dryRun = false)
@ContextConfiguration(classes = TestConfiguration.class)
public class RunSteps {
	
}
