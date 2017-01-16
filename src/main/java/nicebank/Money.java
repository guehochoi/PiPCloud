package nicebank;

public class Money {
	public int dollars;
	public int cents;
	public Money() {
		dollars = 0;
		cents = 0;
	}
	public Money(int dollars, int cents) {
		this.dollars = dollars;
		this.cents = cents;
	}
	public Money add(Money amount){
        int newCents = cents + amount.cents;
        int newDollars = dollars + amount.dollars;
        
        if (newCents >= 100){
            newCents -= 100;
            newDollars++;
        }
        
        return new Money(newDollars, newCents);
    }
    
    public Money minus(Money amount){
        int newCents = cents - amount.cents;
        int newDollars = dollars - amount.dollars;
        
        if (newCents < 0){
            newCents += 100;
            newDollars--;
        }
        
        return new Money(newDollars, newCents);
    }
	@Override
	public boolean equals(Object obj) {
		Money target = (Money) obj;
		return dollars == target.dollars && cents == target.cents;
	}
}