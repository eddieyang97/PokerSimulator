package dealer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.*;

public class Dealer {
	
	public static final int MINVAL = 2;
	public static final int MAXVAL = 14;
	
	private List<Card> deck;
	
	public Dealer() {
		getNewDeck();
		shuffleDeck();
		//sortDeck();
	}
	
	public void getNewDeck() {
		deck = new ArrayList<Card>();
		for(int i = MINVAL; i <= MAXVAL; i++) {
			deck.add(new SpadeCard(i));
			deck.add(new HeartCard(i));
			deck.add(new ClubCard(i));
			deck.add(new DiamondCard(i));
		}
	}
	
	public ArrayList<Card> getCards(int num) {
		ArrayList<Card> cards = new ArrayList<>();
		for(int i = 0; i < num; i++) {
			cards.add(getCardFromDeck());
		}
		return cards;
	}
	
	public Card getCardFromDeck() {
		return deck.remove(0);
	}
	
	public List<Card> getDeck() {
		return deck;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void sortDeck() {
		Collections.sort(deck, Card.SuitComparator);
		Collections.sort(deck, Card.ValueComparator);
	}
}
