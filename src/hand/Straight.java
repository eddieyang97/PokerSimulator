package hand;

import java.util.List;

import card.Card;

public class Straight extends Hand {

	public Straight(List<Card> cards) {
		super(cards, Hand.STRAIGHT);
	}

	@Override
	public String toString() {
		return Card.valNames[getMyHigh5()] + " high straight";
	}

}
