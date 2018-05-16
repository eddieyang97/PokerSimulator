package simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.*;

public class Simulator {
	
	public static final int MINVAL = 2;
	public static final int MAXVAL = 14;
	
	private List<Card> myDeck;
	
	public Simulator() {
		myDeck = new ArrayList<Card>();
		for(int i = MINVAL; i <= MAXVAL; i++) {
			myDeck.add(new SpadeCard(i));
			myDeck.add(new HeartCard(i));
			myDeck.add(new ClubCard(i));
			myDeck.add(new DiamondCard(i));
		}
		shuffle();
		//sort();
	}
	
	public List<Card> getDeck() {
		return myDeck;
	}
	
	public void shuffle() {
		Collections.shuffle(myDeck);
	}
	
	public void sort() {
		Collections.sort(myDeck);
	}
}
