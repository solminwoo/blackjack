package com.Infostretch.blackjack;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TestDrawRandCardFlow {

	@Mock
	IGenerator mockG = mock(Generator.class);
	@Mock
	IHashMapVal mockHMV = mock(HashMapVal.class);
	
	@Test
	void testIfRandomCardDrawn() {
		
		HashMap<Integer,Integer> deck = new HashMap<>();
		deck.put(5, 4);
		given(mockG.generateRandomNumBetween2and14()).willReturn(5);
		given(mockHMV.isValuePositive(deck, 5)).willReturn(true);
		IDrawHandCardFlow DRCF = new DrawHandCardFlow(mockG,mockHMV,deck);
		DRCF.getCard();
		verify(mockG,times(1)).generateRandomNumBetween2and14();
		verify(mockHMV,times(1)).isValuePositive(deck, 5);
	}
	
	@Test
	void testIfRandomCardNotDrawnOnFistAttempt() {
		
		HashMap<Integer,Integer> deck = new HashMap<>();
		deck.put(5, 0);
		deck.put(6, 1);
		given(mockG.generateRandomNumBetween2and14()).willReturn(5,6);
		given(mockHMV.isValuePositive(deck, 5)).willReturn(false);
		given(mockHMV.isValuePositive(deck, 6)).willReturn(true);
		IDrawHandCardFlow DRCF = new DrawHandCardFlow(mockG,mockHMV,deck);
		DRCF.getCard();
		verify(mockG,times(2)).generateRandomNumBetween2and14();
		verify(mockHMV,times(1)).isValuePositive(deck, 5);
		verify(mockHMV,times(1)).isValuePositive(deck, 6);
	}

}
