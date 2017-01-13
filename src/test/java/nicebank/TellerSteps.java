package nicebank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import config.TestConfiguration;
import cucumber.api.java.en.When;
import support.KnowsTheDomain;

@ContextConfiguration(classes = TestConfiguration.class)
public class TellerSteps {
	@Autowired
	private KnowsTheDomain helper;
	public TellerSteps() {
		helper = new KnowsTheDomain();
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int dollars) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}
}
