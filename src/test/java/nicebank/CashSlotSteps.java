package nicebank;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import config.TestConfiguration;
import cucumber.api.java.en.Then;
import support.KnowsTheDomain;

@ContextConfiguration(classes = TestConfiguration.class)
public class CashSlotSteps {
	@Autowired
	private KnowsTheDomain helper;
	
	public CashSlotSteps() {
		helper = new KnowsTheDomain();
	}
	
	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
		assertEquals("Incorrect amount dispensed -", dollars, helper.getCashSlot().getContents());
	}
}
