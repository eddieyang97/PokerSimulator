package hand;

import java.util.List;

import card.Card;

public class ThreeOfAKind extends Hand {

	private int trip;
	
	public ThreeOfAKind(List<Card> cards) {
		super(cards, Hand.THREEOFAKIND);
		trip = cards.get(2).getValue();
	}

	@Override
	public String toString() {
		return "Trip " + Card.valNames[trip] + "s";
	}

}
