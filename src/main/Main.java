package main;

import simulator.Simulator;

public class Main {
	public static void main(String[] args) {
		Simulator mySim = new Simulator();
		mySim.getDeck().forEach(card -> {
			System.out.println(card);
		});
	}
}
