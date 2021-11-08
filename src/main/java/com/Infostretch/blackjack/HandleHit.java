package com.Infostretch.blackjack;

public class HandleHit implements IHandleHit {
	private IAskForHit _AFH;
	private ICalculate _scoreCalculate;
	private IGenerator _generator = new Generator();
	private IHashMapVal _hashMapVal = new HashMapVal();
	private IDrawHandCardFlow _drawHandCardFlow = new DrawHandCardFlow();

	public HandleHit(IAskForHit AFH, ICalculate scoreCalculate, IDrawHandCardFlow drawHandCardFlow) {
		this._AFH = AFH;
		this._scoreCalculate = scoreCalculate;
		this._drawHandCardFlow = drawHandCardFlow;
		
	}

	@Override
	public int whenPlayerHit(IPlayer player, int playerPoints) {
		int result = 0;
		boolean hit = true;

		while (playerPoints<21 && hit) {
			System.out.println("Your Hand: " + player.toString() + "Score: " + playerPoints);
			hit = _AFH.getResponse();
			if (hit) {
				result = _drawHandCardFlow.getCard();
				player.addToHand(result);
				playerPoints = _scoreCalculate.sumArrayList(player.getHand());
			}
		}
		return playerPoints;

	}

}
