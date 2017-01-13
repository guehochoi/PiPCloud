package nicebank;

import static org.junit.Assert.assertEquals;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.KnowsTheDomain;
import transforms.MoneyConverter;

public class Steps {
	
	KnowsTheDomain helper;
	
	public Steps() {
		helper = new KnowsTheDomain();
	}
	
	@Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
	public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) Money amount) throws Throwable {
		helper.getMyAccount().deposit(amount);
		
		assertEquals("Incorrect amount", amount, helper.getMyAccount().getBalance());
	}
	
	@When("^I withdraw \\$(\\d+)$")
	public void iWithdraw$(int dollars) throws Throwable {
		helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
	}
	
	@Then("^\\$(\\d+) should be dispensed$")
	public void $ShouldBeDispensed(int dollars) throws Throwable {
		assertEquals("Incorrect amount dispensed -", dollars, helper.getCashSlot().getContents());
	}
}
