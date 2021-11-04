package com.Infostretch.blackjack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestCardValue {

	@Test
	void cardWith7() {
		// Given: i am a user
		// when : create a card 7
		// result : card has value of 7;
		ICard card = new Card(7);
		int result = card.getValue();
		assertEquals(7,result);
	}
	
	@Test
	void cardWith10() {
		// Given: i am a user
		// when : create a card 10
		// result : card has value of 10;
		ICard card = new Card(10);
		int result = card.getValue();
		assertEquals(10,result);
	}
	
	@Test
	void cardWith11() {
		// Given: i am a user
		// when : create a card 11
		// result : card has value of 11
		ICard card = new Card(11);
		int result = card.getValue();
		assertEquals(11,result);
	}
	
	@Test
	void cardWith14() {
		// Given: i am a user
		// when : create a card 14 -> represents A
		// result : card has value of 14
		ICard card = new Card(14);
		int result = card.getValue();
		assertEquals(14,result);
	}
	

}
