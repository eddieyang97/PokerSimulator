package hand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import card.Card;
import map_sorter.MapUtil;

public class HandFactory {
	
	private Map<Integer, Integer> suitMap;
	private Map<Integer, Integer> valueMap;
	
	public HandFactory(List<Card> cards) {
		setUpSuitMap(cards);
		setUpValueMap(cards);
		MapUtil.printMap(suitMap);
		MapUtil.printMap(valueMap);
	}

	private void setUpSuitMap(List<Card> cards) {
		suitMap = new HashMap<>();
		cards.forEach(card -> {
			int suit = card.getSuit();
			putValue(suitMap, suit);
		});
		suitMap = MapUtil.sortByValue(suitMap);
	}
	
	private void setUpValueMap(List<Card> cards) {
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

	public Hand getHand() {
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
	
	private boolean containsFlush(List<Card> cards) {
		return suitMap.entrySet().iterator().next().getValue() > 4;
	}
	
	private boolean containsFour(List<Card> cards) {
		return valueMap.entrySet().iterator().next().getValue() == 4;
	}
	
	private boolean containsTrip(List<Card> cards) {
		return valueMap.entrySet().iterator().next().getValue() == 3;
	}
	
	private boolean containsPair(List<Card> cards) {
		return valueMap.entrySet().iterator().next().getValue() == 3;
	}
	
}
