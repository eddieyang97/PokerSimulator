package main;

import java.util.ArrayList;

import card.Card;
import dealer.Dealer;
import hand.HandFactory;

public class Main {
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		ArrayList<Card> hand = dealer.getCardsFromDeck(10);
		HandFactory fac = new HandFactory();
		fac.getHand(hand);
		hand.forEach(card -> System.out.println(card));
	}
	
}
