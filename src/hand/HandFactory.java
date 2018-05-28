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
	
	public Hand getHand(List<Card> cards) {
		updateSuitMap(cards);
		updateValueMap(cards);

		if(containsFour()) {
			return new FourOfAKind(cards);
		}
		if(containsTrip() && containsPair()) {
			return new FullHouse(cards);
		}
		
		return new High(cards);
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
	
	private boolean containsFlush() {
		return suitMap.entrySet().iterator().next().getValue() > 4;
	}
	
	private boolean containsStraight(List<Card> cards) {
		int interval = 1;
		for(int i = 1; i < cards.size(); i++) {
			if(cards.get(i).getValue() == cards.get(i - 1).getValue() + 1) {
				interval++;
			} else if (cards.get(i).getValue() > cards.get(i - 1).getValue() + 1) {
				interval = 1;
			}
		}
		return interval > 4;
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
