package main;

import java.util.ArrayList;

import card.Card;
import dealer.Dealer;
import hand.*;

public class Main {
	
	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		HandFactory fac = new HandFactory();
		int[] count = new int[10];
		for(int i = 0; i < 10000000; i++) {
			ArrayList<Card> cards = dealer.getCardsFromDeck(5);
			dealer.getNewDeck();
			dealer.shuffleDeck();
			Hand myHand = fac.getHand(cards);
			count[myHand.getMyType()]++;
		}
		for(int i: count) {
			System.out.println(i);
		}
//		ArrayList<Card> cards = dealer.getCardsFromDeck(7);
//		cards.forEach(card -> System.out.println(card));
//		Hand myHand = fac.getHand(cards);
//		System.out.println(myHand);
//		myHand.getMyCards().forEach(card -> System.out.println(card));
	}
	
}
