package nicebank;

public class AutomatedTellerImpl {
	private CashSlot cashSlot;
	
	public AutomatedTellerImpl(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account account, int dollars) {
		account.debit(dollars);
		cashSlot.dispense(dollars);
	}
}
