package card;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Card {
	
	public static final int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	public static final String[] suits = {"Spade", "Heart", "Club", "Diamond"};
	public static final Comparator<Card> SuitComparator = (c1, c2) -> c1.mySuit - c2.mySuit;
	public static final Comparator<Card> ValueComparator = (c1, c2) -> c1.myValue - c2.myValue;
	
	private int mySuit;
	private int myValue;
	
	public Card(int suit, int value) {
		mySuit = suit;
		myValue = value;
	}
	
	public int getSuit() {
		return mySuit;
	}
	
	public int getValue() {
		return myValue;
	}
	
	public boolean sameSuit(Card card) {
		return mySuit == card.mySuit;
	}	
	
	public boolean sameValue(Card card) {
		return myValue == card.myValue;
	}
	
	@Override
	public String toString() {
		String temp;
		if(myValue < 11) {
			temp = myValue + "";
		} else if(myValue == 11) {
			temp = "Jack";
		} else if(myValue == 12) {
			temp = "Queen";
		} else if(myValue == 13) {
			temp = "King";
		} else {
			temp = "Ace";
		}
		return temp + " of " + suits[mySuit - 1];
	}

	public static void sortbySuit(List<Card> cards) {
		Collections.sort(cards, SuitComparator);
	}
	
	public static void sortbyValue(List<Card> cards) {
		Collections.sort(cards, ValueComparator);
	}
}
