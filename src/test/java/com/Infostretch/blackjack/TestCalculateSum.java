package com.Infostretch.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCalculateSum {

	@Test
	void playerHas10and5() {
		ICalculate c = new Calculate();
		List<Integer> test = List.of(10,5);
		int result = c.sumArrayList(test);
		assertEquals(15,result);
	}
	
	@Test
	void playerHas10and11() {
		ICalculate c = new Calculate();
		List<Integer> test = List.of(10,11);
		int result = c.sumArrayList(test);
		assertEquals(21,result);
	}
	@Test
	void playerHasdouble10and11() {
		ICalculate c = new Calculate();
		List<Integer> test = List.of(10,10,11);
		int result = c.sumArrayList(test);
		assertEquals(31,result);
	}
}
