package com.Infostretch.blackjack;

import java.util.HashMap;

public class HashMapVal implements IHashMapVal{

	@Override
	public boolean isValuePositive(HashMap<Integer, Integer> hashMap, int key) {
		if(hashMap.get(key)>0) {
			return true;
		}
		return false;
	}

}
