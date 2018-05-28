package hand;

import java.util.List;

import card.Card;

public class TwoPair extends Hand {

	private int pairOne;
	private int pairTwo;
	
	public TwoPair(List<Card> cards) {
		super(cards, Hand.TWOPAIR);
		int counter = 0;
		for(int i = 1; i < cards.size(); i++) {
			if(cards.get(i).getValue() == cards.get(i - 1).getValue()) {
				if(counter == 0) {
					pairOne = cards.get(i).getValue();
					counter++;
				} else {
					pairTwo = cards.get(i).getValue();
				}
			}
		}
	}

	@Override
	public String toString() {
		return Card.valNames[pairOne] + ", " + Card.valNames[pairTwo] + " two pairs";
	}

}
