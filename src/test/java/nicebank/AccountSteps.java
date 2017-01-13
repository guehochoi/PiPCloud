package nicebank;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import config.TestConfiguration;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

@ContextConfiguration(classes = TestConfiguration.class)
public class AccountSteps {
	@Autowired
	private KnowsTheDomain helper;
	
	public AccountSteps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		helper.getMyAccount().deposit(amount);
		
		assertEquals("Incorrect amount", amount, helper.getMyAccount().getBalance());
	}
}
