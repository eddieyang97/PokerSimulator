package hand;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class Hand implements Comparable<Hand>{
	private ArrayList<Card> myCards;
	private int myRank;
	
	public Hand(List<Card> cards) {
		myCards = ((ArrayList<Card>) cards);
		myRank = calculateRank();
	}
	
	public abstract int calculateRank();
	
	@Override
	public int compareTo(Hand hand) {
		return myRank - hand.getRank();
	}
	
	public void setRank(int rank) {
		myRank = rank;
	}
	
	public int getRank() {
		return myRank;
	}

	public ArrayList<Card> getMyCards() {
		return myCards;
	}
	
}
