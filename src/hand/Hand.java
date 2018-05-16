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
	private int myHigh1;
	private int myHigh2;
	private int myHigh3;
	private int myHigh4;
	private int myHigh5;
	
	public Hand(List<Card> cards, int type) {
		myCards = ((ArrayList<Card>) cards);
		myType = type;
		myHigh1 = myCards.get(0).getValue();
		myHigh2 = myCards.get(1).getValue();
		myHigh3 = myCards.get(2).getValue();
		myHigh4 = myCards.get(3).getValue();
		myHigh5 = myCards.get(4).getValue();
	}
	
	@Override
	public int compareTo(Hand hand) {
		if(myType != hand.myType) {
			return myType - hand.myType;
		}
		if(myHigh1 != hand.myHigh1) {
			return myHigh1 - hand.myHigh1;
		}
		if(myHigh2 != hand.myHigh2) {
			return myHigh2 - hand.myHigh2;
		}
		if(myHigh3 != hand.myHigh3) {
			return myHigh3 - hand.myHigh3;
		}
		if(myHigh4 != hand.myHigh4) {
			return myHigh4 - hand.myHigh4;
		}
		return myHigh5 - hand.myHigh5;
	}

	public ArrayList<Card> getMyCards() {
		return myCards;
	}
	
}
