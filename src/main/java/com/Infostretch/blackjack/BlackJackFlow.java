package com.Infostretch.blackjack;

import java.util.HashMap;
import java.util.Scanner;

public class BlackJackFlow implements IBlackJackFlow {
	private IPlayer _player;
	private IPlayer _casino;
	private IGenerator _generator;
	private ICalculate _calculate;
	private IConvertor _convertor;
	private IHashMapVal _hashMapVal;
	private IDrawHandCardFlow _drawHandCardFlow;
	private HashMap<Integer, Integer> _deck;
	private ICalculate _scoreCalculate;
	private IHandleHit _handleHit;
	private IHandleDealer _handleDealer;
	private ICompare _compare;

	public BlackJackFlow(IPlayer _player, IPlayer _casino, IGenerator _generator, ICalculate _calculate,
			IConvertor _convertor, IHashMapVal _hashMapVal,IDrawHandCardFlow _drawHandCardFlow, IHandleHit handleHit, IHandleDealer handleDealer,
			ICompare compare) {

		this._player = _player;
		this._casino = _casino;
		this._generator = _generator;
		this._calculate = _calculate;
		this._convertor = _convertor;
		this._hashMapVal = _hashMapVal;
		this._deck = _generator.generateDeck();
		this._drawHandCardFlow = _drawHandCardFlow;
		this._scoreCalculate = new ScoreCalculate(_convertor, _calculate);
		this._handleHit = handleHit;
		this._handleDealer = handleDealer;
		this._compare = compare;
	}

	@Override
	public String play() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome To InfoStretch Casino.");
		System.out.println("You decided to play black jack");

		_player.addToHand(_drawHandCardFlow.getCard());
		_casino.addToHand(_drawHandCardFlow.getCard());
		_player.addToHand(_drawHandCardFlow.getCard());
		_casino.addToHand(_drawHandCardFlow.getCard());

		System.out.println("Dealer's first hand: " + _casino.getHand().get(0));
		System.out.println("here's you cards");
		int playerPoints = _scoreCalculate.sumArrayList(_player.getHand());

		playerPoints =_handleHit.whenPlayerHit(_player, playerPoints);
		System.out.println("Your Hand: " + _player.toString() + "Score: " + playerPoints);
		if(playerPoints>21) {
			return "Ahh Busted";
		}
		int casinoPoints = _handleDealer.drawCardIfBelow17(_casino, playerPoints);

		return _compare.withPoints(playerPoints, casinoPoints);

	}

}
