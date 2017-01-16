package nicebank;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import config.TestConfiguration;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

@ContextConfiguration(classes = TestConfiguration.class)
public class AccountSteps {
	@Autowired
	private KnowsTheDomain helper;
	
	public AccountSteps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^my account has been credited with \\$(\\d+\\.\\d+) in my account$")
	public void myAccountHasBeenCreditedWith$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		helper.getMyAccount().credit(amount);
	}
	
	@Then("^the balance of my account should be \\$(\\d+\\.\\d+)$")
	public void theBalanceOfMyAccountShouldBe$(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		assertEquals("Incorrect account balance", amount, helper.getMyAccount().getBalance());
	}

}
