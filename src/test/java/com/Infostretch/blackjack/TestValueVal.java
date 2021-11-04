package com.Infostretch.blackjack;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestValueVal {

	@Test
	void given2ReturnTrue() {
		//given: i am a user
		//when: int 2
		//then: true
		IValueVal VV = new ValueVal();
		boolean result = VV.valueBetween2And14(2);
		assertTrue(result);
	}
	
	@Test
	void given14ReturnTrue() {
		//given: i am a user
		//when: int 14
		//then: true
		IValueVal VV = new ValueVal();
		boolean result = VV.valueBetween2And14(14);
		assertTrue(result);
	}
	
	@Test
	void given15ReturnTrue() {
		//given: i am a user
		//when: int 15
		//then: return false
		IValueVal VV = new ValueVal();
		boolean result = VV.valueBetween2And14(15);
		assertFalse(result);
	}
	
	@Test
	void given1ReturnTrue() {
		//given: i am a user
		//when: int 1
		//then: return false
		IValueVal VV = new ValueVal();
		boolean result = VV.valueBetween2And14(1);
		assertFalse(result);
	}

}
