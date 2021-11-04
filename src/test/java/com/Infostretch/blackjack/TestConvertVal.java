package com.Infostretch.blackjack;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class TestConvertVal {

	@Test
	void given11return10() {
		//given: when List.of(11)
		//when: converting
		//then: return List.of(10)
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(11);
		List<Integer> result = c.convertTo10(sample);
		assertEquals(List.of(10),result);
	}
	
	@Test
	void given10return10() {
		//given: when List.of(10)
		//when: converting
		//then: return List.of(10)
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(10);
		List<Integer> result = c.convertTo10(sample);
		assertEquals(List.of(10),result);
	}
	@Test
	void given14return10() {
		//given: when List.of(14)
		//when: converting
		//then: return List.of(11)
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(14);
		List<Integer> result = c.convertTo10(sample);
		assertEquals(List.of(11),result);
	}
	
	@Test
	void given11And12And13return10() {
		//given: when List.of(11,12,13,14)
		//when: converting
		//then: return List.of(10)
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(11,12,13,14);
		List<Integer> result = c.convertTo10(sample);
		assertEquals(List.of(10,10,10,11),result);
	}
	
	@Test
	void testConvert11To1WithOthers() {
		//given: 23 and List.of(10,2,11)
		//when: sum is bigger than 21
		//then: convert 11 to 1 and return List<Integer>
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(10,2,11);
		List<Integer> result = c.convert11To1(sample);
		assertEquals(List.of(10,2,1),result);
	}
	@Test
	void testConvert11To1() {
		//given: 23 and List.of(10,2,11)
		//when: sum is bigger than 21
		//then: convert 11 to 1 and return List<Integer>
		IConvertor c = new Convertor();
		List<Integer> sample = List.of(11);
		List<Integer> result = c.convert11To1(sample);
		assertEquals(List.of(1),result);
	}

}
