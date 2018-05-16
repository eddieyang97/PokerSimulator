package dealer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.*;

public class Dealer {
	
	public static final int MAXDECKSIZE = Card.suits.length * Card.values.length;
	
	private List<Card> deck;
	
	public Dealer() {
		getNewDeck();
		shuffleDeck();
		sortDeck();
	}
	
	public void getNewDeck() {
		deck = new ArrayList<Card>();
		int vals[] = Card.values;
		for(int i = 0; i < Card.suits.length; i++) {
			for(int j = vals[0]; j <= vals[vals.length - 1]; j++) {
				try {
					Class<?> clazz = Class.forName("card." + Card.suits[i]);
					deck.add((Card) clazz.getDeclaredConstructor(int.class).newInstance(j));
				} catch (Exception e) {
					// not ideal, but for now
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param num should be not larger than 52
	 * @return
	 */
	public ArrayList<Card> getCardsFromDeck(int num) {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0; i < (num < MAXDECKSIZE? num:MAXDECKSIZE); i++) {
			cards.add(getOneCardFromDeck());
		}
		return cards;
	}
	
	public Card getOneCardFromDeck() {
		return deck.remove(0);
	}
	
	public List<Card> getDeck() {
		return deck;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void sortDeck() {
		Card.sortbyValue(deck);
		Card.sortbySuit(deck);
	}
}
