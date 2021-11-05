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

	public BlackJackFlow(IPlayer _player, IPlayer _casino, IGenerator _generator, ICalculate _calculate,
			IConvertor _convertor, IHashMapVal _hashMapVal) {
		super();
		this._player = _player;
		this._casino = _casino;
		this._generator = _generator;
		this._calculate = _calculate;
		this._convertor = _convertor;
		this._hashMapVal = _hashMapVal;
		this._deck = _generator.generateDeck();
		this._drawHandCardFlow = new DrawHandCardFlow(_generator, _hashMapVal, _deck);
		this._scoreCalculate = new ScoreCalculate(_convertor,_calculate);
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

		System.out.println("Dealer's first hand: " +_casino.getHand().get(0));
		System.out.println("here's you cards");
		System.out.println("Your Hand: " + _player.toString());
		System.out.println("Would you want another card? Y/N");
		String wantMore =  scanner.nextLine();
		boolean hit = (wantMore.equals("Y") || wantMore.equals("y"));
		int playerPoints = _scoreCalculate.sumArrayList(_player.getHand());
		System.out.println("pp"+playerPoints);
		while (hit) {
			_player.addToHand(_drawHandCardFlow.getCard());
			playerPoints = _scoreCalculate.sumArrayList(_player.getHand());
			System.out.println("Your Hand: " + _player.toString()+"Score: "+playerPoints);
			if (playerPoints > 21) {
				return "Busted";
			}
			System.out.println("Would you want another card? Y/N");
			String wantMore2 = scanner.nextLine();
			if(wantMore2.equals("Y") || wantMore2.equals("y")) {
				hit = true;
			} else {
				hit = false;
			}
		}

		int casinoPoints = _scoreCalculate.sumArrayList(_casino.getHand());
		System.out.println("Dealers Hand: "+_casino.getHand());
		while (casinoPoints < 17 && casinoPoints<=playerPoints) {
			_casino.addToHand(_drawHandCardFlow.getCard());
			System.out.println("dealer's hand"+_casino.getHand());
			casinoPoints = _scoreCalculate.sumArrayList(_casino.getHand());
		}

		if (casinoPoints > 21) {
			return "Dealer is busted! You Won!";
		}

		String compare = "Your hand: " + playerPoints + " vs Dealer's hand: " + casinoPoints;
		if (playerPoints > casinoPoints) {
			return compare + "\nYou Won!";
		} else if (playerPoints < casinoPoints) {
			return compare + "\nYouLost :(";
		} else {
			return "Draw";
		}

	}

}
