package hand;

import java.util.List;

import card.Card;

public class OnePair extends Hand {

	private int pair;
	
	public OnePair(List<Card> cards) {
		super(cards, Hand.ONEPAIR);
		for(int i = 1; i < cards.size(); i++) {
			if(cards.get(i).getValue() == cards.get(i - 1).getValue()) {
				pair = cards.get(i).getValue();
			}
		}
	}

	@Override
	public String toString() {
		return "One pair of " + Card.valNames[pair] + "s";
	}

}
