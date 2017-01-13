package nicebank;

import cucumber.api.java.en.*;

import cucumber.api.PendingException;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber"},
		features = "classpath:cucumber")
public class RunStepTests {
	
}
