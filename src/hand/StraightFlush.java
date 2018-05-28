package hand;

import java.util.List;

import card.Card;

public class StraightFlush extends Hand {

	public StraightFlush(List<Card> cards) {
		super(cards, Hand.STRAIGHTFLUSH);
	}

	@Override
	public String toString() {
		return Card.valNames[getMyHigh5()] + " high straight flush";
	}

}
