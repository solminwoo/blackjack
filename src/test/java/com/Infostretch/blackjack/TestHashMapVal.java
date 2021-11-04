package com.Infostretch.blackjack;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class TestHashMapVal {

	@Test
	void ifValueIsPositive() {
		//given: HashMap and key
		//when : value is bigger Than 1
		//then:  return true
		IHashMapVal HMV = new HashMapVal();
		int key = 2;
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		hashMap.put(2, 1);
		boolean result = HMV.isValuePositive(hashMap,key);
		assertTrue(result);
	}
	
	@Test
	void ifValueIs0() {
		//given: HashMap and key
		//when : value is bigger Than 1
		//then:  return true
		IHashMapVal HMV = new HashMapVal();
		int key = 2;
		HashMap<Integer,Integer> hashMap = new HashMap<>();
		hashMap.put(2, 0);
		boolean result = HMV.isValuePositive(hashMap,key);
		assertFalse(result);
	}

}
