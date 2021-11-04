package com.Infostretch.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player implements IPlayer{
	public List<Integer> hand;

	public List<Integer> getHand() {
		return hand;
	}
	
	@Override
	public String toString() {
		return "Player [hand=" + hand + "]";
	}

	public void addToHand(int i) {
		this.hand.add(i);
	}

	public Player() {
		this.hand = new ArrayList();
	}
}
