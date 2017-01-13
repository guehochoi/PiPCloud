package transforms;

import cucumber.api.Transformer;
import skeletons.Money;

public class MoneyConverter extends Transformer<Money>{

	@Override
	public Money transform(String amount) {
		String[] numbers = amount.split("\\.");
		
		int dollars = Integer.parseInt(numbers[0]);
		int cents = Integer.parseInt(numbers[1]);
		
		return new Money(dollars, cents);
	}
}