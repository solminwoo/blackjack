package com.Infostretch.blackjack;

public class HandleDealer implements IHandleDealer{
	private ICalculate _scoreCalculate;
	private IDrawHandCardFlow _drawHandCardFlow;

	public HandleDealer(ICalculate scoreCalculate, IDrawHandCardFlow drawHandCardFlow) {
		this._scoreCalculate = scoreCalculate;
		this._drawHandCardFlow = drawHandCardFlow;
	}

	@Override
	public int drawCardIfBelow17(IPlayer casino, int playerPoints) {
		int casinoPoints = _scoreCalculate.sumArrayList(casino.getHand());
		System.out.println("Dealers Hand: "+casino.getHand());
		while (casinoPoints < 17 && casinoPoints<=playerPoints) {
			casino.addToHand(_drawHandCardFlow.getCard());
			System.out.println("dealer's hand"+casino.getHand());
			casinoPoints = _scoreCalculate.sumArrayList(casino.getHand());
		}
		return casinoPoints;
	}

}
