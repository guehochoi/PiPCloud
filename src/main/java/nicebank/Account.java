package nicebank;

public class Account {
	private Money balance = new Money();
	
	public void credit(Money amount) {
		balance.dollars += amount.dollars;
		balance.cents += amount.cents;
	}

	public Money getBalance() {
		return balance;
	}
	
	public void debit(int dollars) {
		balance = balance.minus(new Money(dollars, 0));
	}
}