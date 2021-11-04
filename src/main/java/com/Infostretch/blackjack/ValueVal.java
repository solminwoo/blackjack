package com.Infostretch.blackjack;

public class ValueVal implements IValueVal{

	@Override
	public boolean valueBetween2And14(int i) {
		if(2<=i && i<=14) {
			return true;
		}
		return false;
	}
	
}
