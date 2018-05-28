package hand;

import java.util.List;

import card.Card;

public class FourOfAKind extends Hand{
	
	private int four;
	private int kicker;
	
	public FourOfAKind(List<Card> cards) {
		super(cards, Hand.FOUROFAKIND);
		four = cards.get(1).getValue();
		kicker = (cards.get(0).getValue() == four)? cards.get(4).getValue():cards.get(0).getValue();
	}

	@Override
	public String toString() {
		return "Four " + Card.valNames[four] + "s with a " + Card.valNames[kicker] + " kicker";
	}

}
