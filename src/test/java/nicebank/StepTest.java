package nicebank;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import skeletons.Money;
import transforms.MoneyConverter;

public class StepTest {
	class Account {
		private Money balance = new Money();
		
		public void deposit(Money amount) {
			balance.dollars += amount.dollars;
			balance.cents += amount.cents;
		}

		public Money getBalance() {
			return balance;
		}
	}
	
	class Teller {
		private CashSlot cashSlot;
		
		public Teller(CashSlot cashSlot) {
			this.cashSlot = cashSlot;
		}
		
		public void withdrawFrom(Account account, int dollars) {
			cashSlot.dispense(dollars);
		}
	}
	
	class KnowsTheDomain {
		private Account myAccount;
		private CashSlot cashSlot;
		private Teller teller;
		public Account getMyAccount() {
			if (myAccount == null) {
				myAccount = new Account();
			}
			return myAccount;
		}
		public CashSlot getCashSlot() {
			if (cashSlot == null) {
				cashSlot = new CashSlot();
			}
			return cashSlot;
		}
		public Teller getTeller() {
			if (teller == null) {
				teller = new Teller(getCashSlot());
			}
			return teller;
		}
	}
	
	class CashSlot {
		private int contents;
		
		public int getContents() {
			return contents;
		}
		public void dispense(int dollars) {
			contents = dollars;
		}
	}
	
	KnowsTheDomain helper;
	
	public StepTest() {
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
