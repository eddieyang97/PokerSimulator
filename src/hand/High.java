package hand;

import java.util.List;

import card.Card;

public class High extends Hand {

	public High(List<Card> cards) {
		super(cards, Hand.HIGH);
	}

	@Override
	public String toString() {
		return Card.valNames[getMyHigh5()] + " high";
	}

}
