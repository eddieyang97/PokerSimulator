package hand;

import java.util.List;

import card.Card;

public class FullHouse extends Hand {

	private int trip;
	private int pair;
	
	public FullHouse(List<Card> cards) {
		super(cards, Hand.FULLHOUSE);
		trip = cards.get(2).getValue();
		pair = (cards.get(0).getValue() == trip)? cards.get(3).getValue():cards.get(0).getValue();
	}

	@Override
	public String toString() {
		return Card.valNames[trip] + " full of " + Card.valNames[pair] + "'s";
	}

}
