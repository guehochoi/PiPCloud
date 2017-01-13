package skeletons;

public class Money {
	public int dollars;
	public int cents;
	public Money() {
	}
	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}
	@Override
	public boolean equals(Object obj) {
		Money target = (Money) obj;
		return dollars == target.dollars && cents == target.cents;
	}
}