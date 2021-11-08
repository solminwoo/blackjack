package com.Infostretch.blackjack;

import java.util.HashMap;

public class DrawHandCardFlow implements IDrawHandCardFlow{
	private IGenerator _G = new Generator();
	private IHashMapVal _HMV = new HashMapVal();
	private HashMap<Integer,Integer> _deck =_G.generateDeck();
	
//	public DrawHandCardFlow(IGenerator G, IHashMapVal HMV, HashMap deck) {
//		this._G = G;
//		this._HMV = HMV;
//		this._deck = deck;
//	}


	@Override
	public int getCard() {
		int randNum = _G.generateRandomNumBetween2and14();
		boolean validation = _HMV.isValuePositive(_deck, randNum);
		while(!validation) {
			//There might be a chance when _deck is empty it will have error
			randNum = _G.generateRandomNumBetween2and14();
			validation = _HMV.isValuePositive(_deck, randNum);
		}
		_deck.put(randNum, _deck.get(randNum)-1);	
		return randNum;
	}

}
