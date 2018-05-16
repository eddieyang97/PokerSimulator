package hand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import card.Card;
import map_sorter.MapUtil;

public class HandFactory {
	
	private Map<Integer, Integer> suitMap;
	private Map<Integer, Integer> valueMap;
	
	public HandFactory() {
		suitMap = new HashMap<>();
		valueMap = new HashMap<>();
	}

	private void updateSuitMap(List<Card> cards) {
		cards.forEach(card -> {
			int suit = card.getSuit();
			putValue(suitMap, suit);
		});
		suitMap = MapUtil.sortByValue(suitMap);
	}
	
	private void updateValueMap(List<Card> cards) {
		valueMap = new HashMap<>();
		cards.forEach(card -> {
			int val = card.getValue();
			putValue(valueMap, val);
		});
		valueMap = MapUtil.sortByValue(valueMap);
	}
	
	private void putValue(Map<Integer, Integer> map, int val) {
		if(!map.keySet().contains(val)) {
			map.put(val, 0);
		}
		map.put(val, map.get(val) + 1);
	}

	public Hand getHand(List<Card> cards) {
		updateSuitMap(cards);
		updateValueMap(cards);
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
	
	private boolean containsFlush() {
		return suitMap.entrySet().iterator().next().getValue() > 4;
	}
	
	private boolean containsStraight(List<Card> cards) {
		return false;
	}
	
	private boolean containsFour() {
		return valueMap.entrySet().iterator().next().getValue() == 4;
	}
	
	private boolean containsTrip() {
		return valueMap.entrySet().iterator().next().getValue() == 3;
	}
	
	private boolean containsPair() {
		return valueMap.entrySet().iterator().next().getValue() == 2;
	}
	
}
