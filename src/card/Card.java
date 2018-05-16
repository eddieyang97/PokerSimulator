package card;

public class Card implements Comparable<Card>{
	public final String[] suits = {"Spade", "Heart", "Club", "Diamond"};
	private String mySuit;
	private int myValue;
	
	public Card(String suit, int value) {
		mySuit = suit;
		myValue = value;
	}
	
	public String getSuit() {
		return mySuit;
	}
	
	public int getValue() {
		return myValue;
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
		return temp + " of " + mySuit;
	}

	@Override
	public int compareTo(Card card) {
		return myValue - card.myValue;
	}
}
