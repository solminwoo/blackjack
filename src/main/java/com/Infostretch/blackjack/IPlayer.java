package com.Infostretch.blackjack;

import java.util.List;

public interface IPlayer {
	public List<Integer> getHand();
	public void addToHand(int i);
	public String toString();
}
