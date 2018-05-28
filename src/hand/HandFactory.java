package hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import card.Card;
import map_sorter.MapUtil;

public class HandFactory {
	
	private Map<Integer, Integer> suitMap;
	private Map<Integer, Integer> valueMap;
	private Iterator<Entry<Integer, Integer>> suitIterator;
	private Iterator<Entry<Integer, Integer>> valueIterator;
	
	public HandFactory() {
		suitMap = new HashMap<>();
		valueMap = new HashMap<>();
	}
	
	public Hand getHand(List<Card> cards) {
		updateSuitMap(cards);
		updateValueMap(cards);
		Card.sortbySuit(cards);
		Card.sortbyValue(cards);

		if(containsFour()) {
			return new FourOfAKind(getFourOfAKindCards(cards));
		}
		if(containsTrip() && containsPair()) {
			return new FullHouse(cards);
		}
		return new High(getHighCards(cards));
	}

	private void updateSuitMap(List<Card> cards) {
		cards.forEach(card -> {
			int suit = card.getSuit();
			putValue(suitMap, suit);
		});
		suitMap = MapUtil.sortByValue(suitMap);
		suitIterator = suitMap.entrySet().iterator();
	}
	
	private void updateValueMap(List<Card> cards) {
		valueMap = new HashMap<>();
		cards.forEach(card -> {
			int val = card.getValue();
			putValue(valueMap, val);
		});
		valueMap = MapUtil.sortByValue(valueMap);
		valueIterator = valueMap.entrySet().iterator();
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
	
	private List<Card> getFourOfAKindCards(List<Card> cards) {
		List<Card> ret = new ArrayList<>();
		boolean found = false;
		for(int i = 0; i < cards.size() - 4; i++) {
			if(cards.get(i).getValue() == cards.get(i + 1).getValue() &&
					cards.get(i).getValue() == cards.get(i + 2).getValue() &&
					cards.get(i).getValue() == cards.get(i + 3).getValue()) {
				found = true;
				for(int j = i; j < i + 4; j++) {
					ret.add(cards.get(j));
				}
				ret.add(cards.get(cards.size() - 1));
			}
		}
		if(!found) {
			ret = getLastFive(cards);
		}
		return ret;
	}
	
	private boolean containsTrip() {
		return valueIterator.next().getValue() == 3;
	}
	
	private boolean containsPair() {
		return valueIterator.next().getValue() == 2;
	}
	

	private List<Card> getHighCards(List<Card> cards) {
		return getLastFive(cards);
	}
	
	private List<Card> getLastFive(List<Card> cards) {
		List<Card> ret = new ArrayList<>();
		for(int i = cards.size() - 5; i < cards.size(); i++) {
			ret.add(cards.get(i));
		}
		return ret;
	}
}
