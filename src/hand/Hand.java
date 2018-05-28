package hand;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public abstract class Hand implements Comparable<Hand> {
	
	public static final int STRAIGHTFLUSH = 9;
	public static final int FOUROFAKIND = 8;
	public static final int FULLHOUSE = 7;
	public static final int FLUSH = 6;
	public static final int STRAIGHT = 5;
	public static final int THREEOFAKIND = 4;
	public static final int TWOPAIR = 3;
	public static final int ONEPAIR = 2;
	public static final int HIGH = 1;
	
	private ArrayList<Card> myCards;
	private int myType;
	private int myHigh5;

	public Hand(List<Card> cards, int type) {
		myCards = ((ArrayList<Card>) cards);
		myType = type;
		myHigh5 = myCards.get(4).getValue();
	}
	
	@Override
	public int compareTo(Hand hand) {
		if(myType != hand.myType) {
			return myType - hand.myType;
		}
		int index = 4;
		while(myCards.get(index).getValue() == hand.myCards.get(index).getValue() && index != 0) {
			index--;
		}
		return myCards.get(index).getValue() - hand.myCards.get(index).getValue();
	}

	public ArrayList<Card> getMyCards() {
		return myCards;
	}
	
	public int getMyHigh5() {
		return myHigh5;
	}
	
	public abstract String toString();
	
}
