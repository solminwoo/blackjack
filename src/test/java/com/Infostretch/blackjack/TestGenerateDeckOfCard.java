package com.Infostretch.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class TestGenerateDeckOfCard {

	@Test
	void deckHasFour2s() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck should have 4 2's
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(4,deck.get(2));
	}
	
	@Test
	void deckHasFour10s() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck should have 4 10's
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(4,deck.get(10));
	}
	
	@Test
	void deckHasFour14s() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck should have 4 14's
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(4,deck.get(14));
	}
	
	@Test
	void deckHasNo15() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck should have no 15
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(null,deck.get(15));
	}
	
	@Test
	void deckHasNo1() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck should have no 1
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(null,deck.get(1));
	}
	
	@Test
	void deckHas13Values() {
		//given: a user
		//when : gerating Deck out of HashMap
		//then: Deck with 13 keys
		IGenerator G = new Generator();
		HashMap deck = G.generateDeck();
		assertEquals(13,deck.size());
	}
	

}
