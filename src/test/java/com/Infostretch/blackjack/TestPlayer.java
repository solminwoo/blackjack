package com.Infostretch.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class TestPlayer {

	@Test
	void addValueToPlayersHand() {
		//given: a player
		//when: int 2 is passed
		//then: user.getHand return [2]
		Player P = new Player();
		P.addToHand(2);
		List<Integer> expected = List.of(2);
		List<Integer> result = P.getHand();
		assertEquals(expected,result);
	}

	@Test
	void addMultipleValueToPlayersHand() {
		//given: a player
		//when: int 2 and int 5 is added to hand
		//then: user.getHand return [2]
		Player P = new Player();
		P.addToHand(2);
		P.addToHand(5);
		List<Integer> expected = List.of(2,5);
		List<Integer> result = P.getHand();
		assertEquals(expected,result);
	}

}
