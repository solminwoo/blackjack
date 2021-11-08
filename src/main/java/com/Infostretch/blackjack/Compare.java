package com.Infostretch.blackjack;

public class Compare implements ICompare{

	@Override
	public String withPoints(int playerPoints, int casinoPoints) {
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
