package main;


import dealer.Dealer;
import hand.HandFactory;

public class Main {
	
	public static void main(String[] args) {
		Simulator sim = new Simulator();
		HandFactory fac = new HandFactory(sim.getDeck());
		/*sim.getDeck().forEach(card -> {
			System.out.println(card);
		});*/
	}
	
}
