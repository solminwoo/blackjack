package com.Infostretch.blackjack;

import java.util.List;

public class Calculate implements ICalculate {

	@Override
	public int sumArrayList(List<Integer> arrList) {
		int sum = 0;
		for (int i : arrList) {
			sum += i;
		}
		return sum;
	}

}
