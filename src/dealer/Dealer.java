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
		//sortDeck();
	}
	
	public void getNewDeck() {
		deck = new ArrayList<Card>();
		int vals[] = Card.values;
		for(int i = vals[0]; i <= vals[vals.length - 1]; i++) {
			deck.add(new SpadeCard(i));
			deck.add(new HeartCard(i));
			deck.add(new ClubCard(i));
			deck.add(new DiamondCard(i));
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
