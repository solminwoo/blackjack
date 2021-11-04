package com.Infostretch.blackjack;

import java.util.HashMap;
import java.util.Random;

public class Generator implements IGenerator{

	@Override
	public HashMap generateDeck() {
		HashMap<Integer,Integer> deck = new HashMap<>();
		for(int i = 2; i<15;i++) {
			deck.put(i,4);
		}
		return deck;
	}

	@Override
	public int generateRandomNumBetween2and14() {
		Random rn = new Random();
		int range = 14 - 2 + 1;
		int randomNum =  rn.nextInt(range) + 2;
		return randomNum;
	}

}
