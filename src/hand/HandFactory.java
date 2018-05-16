package hand;

import java.util.Collections;
import java.util.List;

import card.Card;

public class HandFactory {
	
	public static Hand getHand(List<Card> cards) {
		/*
		int strength = getStrength(cards);
		List<Card> bestCombination = getBestCombination(cards);
		switch(strength) {
			case Hand.STRAIGHTFLUSH: return new StraightFlush(bestCombination);
			case Hand.FOUROFAKIND: return new FourOfAKind(bestCombination);
			case Hand.FULLHOUSE: return new StraightFlush(bestCombination);
			case Hand.FLUSH: return new StraightFlush(bestCombination);
			case Hand.STRAIGHT: return new StraightFlush(bestCombination);
			case Hand.THREEOFAKIND: return new StraightFlush(bestCombination);
			case Hand.TWOPAIR: return new StraightFlush(bestCombination);
			case Hand.ONEPAIR: return new StraightFlush(bestCombination);
			default: return new High(bestCombination);
		}*/
		return null;
	}
	
	private static boolean containsFour(List<Card> cards) {
		//if(containsTrip(cards))
		return false;
	}
	
	private static boolean containsTrip(List<Card> cards) {
		return false;
	}
	
	private static boolean containsPair(List<Card> cards) {
		Collections.sort(cards, Card.SuitComparator);
		for(int i = 0; i < cards.size(); i ++) {
			for(int j = i; j < cards.size(); j++) {
				//if(cards(i).)
			}
		}
		return false;
	}
	
}
