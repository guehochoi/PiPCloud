package nicebank;

public class Account {
	private Money balance = new Money();
	
	public void deposit(Money amount) {
		balance.dollars += amount.dollars;
		balance.cents += amount.cents;
	}

	public Money getBalance() {
		return balance;
	}
}