package com.Infostretch.blackjack;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TestBlackJackFlow {

	@Mock
	ICard mockC = mock(Card.class);
	
	@Mock
	IGenerator mockG = mock(Generator.class);
	
	@Mock
	IPlayer mockP = mock(Player.class);
	@Mock
	IPlayer mockCasino = mock(Player.class);
	
	@Mock
	ICalculate mockCal = mock(Calculate.class);
	@Mock
	IConvertor mockConv = mock(Convertor.class);
	@Mock
	IHashMapVal mockHMV = mock(HashMapVal.class);
	
	
	
	
	@Test
	void test(){
		HashMap<Integer,Integer> deck = new HashMap<>();
		deck.put(10,4);
		deck.put(7,4);
		deck.put(6,4);
		IDrawHandCardFlow DHCF = new DrawHandCardFlow(mockG,mockHMV,deck);
		ICalculate scoreCalculate = new ScoreCalculate(mockConv,mockCal);
		
		given(mockG.generateDeck()).willReturn(deck);
		given(mockG.generateRandomNumBetween2and14()).willReturn(10,7,10,6);
		given(mockHMV.isValuePositive(deck, 10)).willReturn(true);
		given(mockHMV.isValuePositive(deck, 7)).willReturn(true);
		given(mockHMV.isValuePositive(deck, 6)).willReturn(true);
		given(DHCF.getCard()).willReturn(10,7,10,6);
		mockP.addToHand(10);
		mockP.addToHand(7);
		mockCasino.addToHand(10);
		mockCasino.addToHand(6);
		scoreCalculate.sumArrayList(mockP.getHand());
	}

}
