package hand;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class Hand implements Comparable<Hand> {
	
	public static final int ROYALFLUSH = 9;
	public static final int FOUROFAKIND = 8;
	public static final int FULLHOUSE = 7;
	public static final int FLUSH = 6;
	public static final int STRAIGHT = 5;
	
	private ArrayList<Card> myCards;
	private int myStrength;
	private int myRank;
	
	public Hand(List<Card> cards, int strength) {
		myCards = ((ArrayList<Card>) cards);
		myStrength = strength;
		myRank = calculateRank();
	}
	
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
