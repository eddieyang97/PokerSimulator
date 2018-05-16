package hand;

import java.util.List;

import card.Card;

public class Straight extends Hand {

	public Straight(List<Card> cards) {
		super(cards, Hand.STRAIGHT);
	}

}
