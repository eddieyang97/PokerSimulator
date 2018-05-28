package hand;

import java.util.List;

import card.Card;

public class Flush extends Hand {

	public Flush(List<Card> cards) {
		super(cards, Hand.FLUSH);
	}

	@Override
	public String toString() {
		return Card.valNames[getMyHigh5()] + " high " + Hand.FLUSH;
	}

}
